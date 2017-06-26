package com.bitstar.rest.util;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5EncoderUtil {
	
	public static String md5Encode(String str) throws NoSuchAlgorithmException{
		MessageDigest md5 = MessageDigest.getInstance("MD5");
		md5.update(str.getBytes());
		String encode = new BigInteger(1,md5.digest()).toString(16);
		while(encode.length()<32){
			encode = "0" + encode;
		}
		return encode;
	}
}
