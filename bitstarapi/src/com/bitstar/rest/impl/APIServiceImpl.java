package com.bitstar.rest.impl;

import java.util.HashMap;
import java.util.Map;

import com.bitstar.rest.feature.IAPIService;
import com.bitstar.rest.util.HttpUtil;
import com.bitstar.rest.util.MD5EncoderUtil;

public class APIServiceImpl implements IAPIService{
	
	private String accessKey;
	
	private String secretKey;
	
	private String rootUrl;
			
	public APIServiceImpl(String rootUrl){
		this.rootUrl = rootUrl;
	}
	
	public APIServiceImpl(String accessKey,String secretKey,String rootUrl){
		this.accessKey = accessKey;
		this.secretKey = secretKey;
		this.rootUrl = rootUrl;
	}

	@Override
	public String getTicker(String businessType) throws Exception {
		HttpUtil httpUtil = HttpUtil.createInstance(rootUrl);
		String message = httpUtil.sendMessage("/api/v1/market/ticker/"+businessType);
		return message;
	}

	@Override
	public String getDepth(String businessType, String size) throws Exception {
		HttpUtil httpUtil = HttpUtil.createInstance(rootUrl);
		Map<String,Object> requestMap = new HashMap<String,Object>();
		requestMap.put("size", size);
		String message = httpUtil.sendMessage("/api/v1/market/depth/"+businessType,requestMap);
		return message;
	}

	@Override
	public String getTrades(String businessType) throws Exception {
		HttpUtil httpUtil = HttpUtil.createInstance(rootUrl);
		String message = httpUtil.sendMessage("/api/v1/market/trades/"+businessType);
		return message;
	}

	@Override
	public String getkline(String businessType, String ktype, String size) throws Exception {
		HttpUtil httpUtil = HttpUtil.createInstance(rootUrl);
		Map<String,Object> requestMap = new HashMap<String,Object>();
		requestMap.put("size", size);
		String message = httpUtil.sendMessage("/api/v1/market/kline/"+businessType+"/"+ktype,requestMap);
		return message;
	}

	@Override
	public String publicInfo(String businessType) throws Exception {
		HttpUtil httpUtil = HttpUtil.createInstance(rootUrl);
		String message = httpUtil.sendMessage("/api/v1/market/publicInfo/"+businessType);
		return message;
	}

	@Override
	public String mainAccount(String currency) throws Exception {
		HttpUtil httpUtil = HttpUtil.createInstance(rootUrl);
		String signData = MD5EncoderUtil.md5Encode("/api/v1/fund/mainAccount/"+currency+"/" +secretKey);
		Map<String,Object> requestMap = new HashMap<String,Object>();
		requestMap.put("accessKey", accessKey);
		requestMap.put("signData", signData);
		String message = httpUtil.sendMessage("/api/v1/fund/mainAccount/"+currency,requestMap,HttpUtil.Method.POST);
		return message;
	}

	@Override
	public String subAccount(String contractCode) throws Exception {
		HttpUtil httpUtil = HttpUtil.createInstance(rootUrl);
		String signData = MD5EncoderUtil.md5Encode("/api/v1/fund/subAccount/"+contractCode+"/" +secretKey);
		Map<String,Object> requestMap = new HashMap<String,Object>();
		requestMap.put("accessKey", accessKey);
		requestMap.put("signData", signData);
		String message = httpUtil.sendMessage("/api/v1/fund/subAccount/"+contractCode,requestMap,HttpUtil.Method.POST);
		return message;
	}

	@Override
	public String transferToSub(String contractCode, String amount) throws Exception {
		HttpUtil httpUtil = HttpUtil.createInstance(rootUrl);
		String signData = MD5EncoderUtil.md5Encode("/api/v1/fund/transferToSub/"+contractCode+"/"+amount+"/" +secretKey);
		Map<String,Object> requestMap = new HashMap<String,Object>();
		requestMap.put("accessKey", accessKey);
		requestMap.put("signData", signData);
		String message = httpUtil.sendMessage("/api/v1/fund/transferToSub/"+contractCode+"/"+amount,requestMap,HttpUtil.Method.POST);
		return message;
	}

	@Override
	public String transferToMain(String contractCode, String amount) throws Exception {
		HttpUtil httpUtil = HttpUtil.createInstance(rootUrl);
		String signData = MD5EncoderUtil.md5Encode("/api/v1/fund/transferToMain/"+contractCode+"/"+amount+"/" +secretKey);
		Map<String,Object> requestMap = new HashMap<String,Object>();
		requestMap.put("accessKey", accessKey);
		requestMap.put("signData", signData);
		String message = httpUtil.sendMessage("/api/v1/fund/transferToMain/"+contractCode+"/"+amount,requestMap,HttpUtil.Method.POST);
		return message;
	}

	@Override
	public String placeOrder(String businessType, String tradeType, String price, String amount) throws Exception {
		HttpUtil httpUtil = HttpUtil.createInstance(rootUrl);
		String signData = MD5EncoderUtil.md5Encode("/api/v1/trade/order/"+businessType+"/"+tradeType+"/"+price+"/"+amount+"/" +secretKey);
		Map<String,Object> requestMap = new HashMap<String,Object>();
		requestMap.put("accessKey", accessKey);
		requestMap.put("signData", signData);
		String message = httpUtil.sendMessage("/api/v1/trade/order/"+businessType+"/"+tradeType+"/"+price+"/"+amount,requestMap,HttpUtil.Method.POST);
		return message;
	}

	@Override
	public String cancel(String businessType, String orderid) throws Exception {
		HttpUtil httpUtil = HttpUtil.createInstance(rootUrl);
		String signData = MD5EncoderUtil.md5Encode("/api/v1/trade/cancel/"+businessType+"/"+orderid+"/" +secretKey);
		Map<String,Object> requestMap = new HashMap<String,Object>();
		requestMap.put("accessKey", accessKey);
		requestMap.put("signData", signData);
		String message = httpUtil.sendMessage("/api/v1/trade/cancel/"+businessType+"/"+orderid,requestMap,HttpUtil.Method.POST);
		return message;
	}

	@Override
	public String orderinfo(String businessType, String orderid) throws Exception {
		HttpUtil httpUtil = HttpUtil.createInstance(rootUrl);
		String signData = MD5EncoderUtil.md5Encode("/api/v1/trade/orderinfo/"+businessType+"/"+orderid+"/" +secretKey);
		Map<String,Object> requestMap = new HashMap<String,Object>();
		requestMap.put("accessKey", accessKey);
		requestMap.put("signData", signData);
		String message = httpUtil.sendMessage("/api/v1/trade/orderinfo/"+businessType+"/"+orderid,requestMap,HttpUtil.Method.POST);
		return message;
	}

	@Override
	public String orders_in(String businessType) throws Exception {
		HttpUtil httpUtil = HttpUtil.createInstance(rootUrl);
		String signData = MD5EncoderUtil.md5Encode("/api/v1/trade/orders_in/"+businessType+"/" +secretKey);
		Map<String,Object> requestMap = new HashMap<String,Object>();
		requestMap.put("accessKey", accessKey);
		requestMap.put("signData", signData);
		String message = httpUtil.sendMessage("/api/v1/trade/orders_in/"+businessType,requestMap,HttpUtil.Method.POST);
		return message;
	}

	@Override
	public String orders_over(String businessType) throws Exception {
		HttpUtil httpUtil = HttpUtil.createInstance(rootUrl);
		String signData = MD5EncoderUtil.md5Encode("/api/v1/trade/orders_over/"+businessType+"/" +secretKey);
		Map<String,Object> requestMap = new HashMap<String,Object>();
		requestMap.put("accessKey", accessKey);
		requestMap.put("signData", signData);
		String message = httpUtil.sendMessage("/api/v1/trade/orders_over/"+businessType,requestMap,HttpUtil.Method.POST);
		return message;
	}

	@Override
	public String storeinfo(String businessType) throws Exception {
		HttpUtil httpUtil = HttpUtil.createInstance(rootUrl);
		String signData = MD5EncoderUtil.md5Encode("/api/v1/trade/storeinfo/"+businessType+"/" +secretKey);
		Map<String,Object> requestMap = new HashMap<String,Object>();
		requestMap.put("accessKey", accessKey);
		requestMap.put("signData", signData);
		String message = httpUtil.sendMessage("/api/v1/trade/storeinfo/"+businessType,requestMap,HttpUtil.Method.POST);
		return message;
	}

}
