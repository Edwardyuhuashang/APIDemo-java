package com.bitstar.rest.util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.http.Consts;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

public class HttpUtil {
	private String rootUrl;
	private CloseableHttpClient httpClient;
	
	public enum Method {
	     GET,POST
	}
	
	private HttpUtil(String rootUrl){
		this.rootUrl = rootUrl;
	}
	
	public static  HttpUtil createInstance(String rootUrl){
		return new HttpUtil(rootUrl);
	}
	
	public String sendMessage(String relativeUrl,Map<String,Object>requestMap) throws Exception{
		return this.sendMessage(relativeUrl, requestMap,HttpUtil.Method.GET);
	}
	
	public String sendMessage(String relativeUrl) throws Exception{
		return this.sendMessage(relativeUrl, null,HttpUtil.Method.GET);
	}
	
	public String sendMessage(String relativeUrl,Map<String,Object>requestMap,Method method) throws Exception{
		if(httpClient==null){
			httpClient = HttpClientBuilder.create().build();
		}
		String absluteUrl = rootUrl+relativeUrl;
		HttpUriRequest req = null;
		if(method==null){
			method = Method.GET;
		}
		if(method==Method.POST){
			HttpPost hp = new HttpPost(absluteUrl);
			if(requestMap!=null){
				List<BasicNameValuePair> nvps = new ArrayList<BasicNameValuePair>();
				for(String key:requestMap.keySet()){
					Object value = requestMap.get(key);
					if(value!=null){
						nvps.add(new BasicNameValuePair(key, value.toString()));  
						
					}
				}
				hp.setEntity(new UrlEncodedFormEntity(nvps,Consts.UTF_8));  
			}
			req = hp;
		}else{
			if(requestMap!=null){
				List<BasicNameValuePair> nvps = new ArrayList<BasicNameValuePair>();
				for(String key:requestMap.keySet()){
					Object value = requestMap.get(key);
					if(value!=null){
						nvps.add(new BasicNameValuePair(key, value.toString()));  
						
					}
				}
				String str = EntityUtils.toString(new UrlEncodedFormEntity(nvps,Consts.UTF_8));
				if(absluteUrl.indexOf("?")>=0){
					absluteUrl = absluteUrl+"&"+str;
				}else{
					absluteUrl = absluteUrl+"?"+str;
				}
			}
			req = new HttpGet(absluteUrl);
		}
		try {
			CloseableHttpResponse htrp = httpClient.execute(req);
			int statuscode = htrp.getStatusLine().getStatusCode();
			if(statuscode!=200){
				throw new Exception("返回错误：状态码"+statuscode);
			}else{
				String responseString = EntityUtils.toString(htrp.getEntity()).trim();
				return responseString;
			}
		} catch (ClientProtocolException e) {
			throw new Exception("URL地址错误",e);
		} catch (IOException e) {
			throw new Exception("传输错误",e);
		}
	}
}
