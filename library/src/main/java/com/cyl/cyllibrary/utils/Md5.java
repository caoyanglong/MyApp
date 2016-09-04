package com.cyl.cyllibrary.utils;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
/**
 * md5 加密  方法
 * @author 曹阳龙
 *
 * 2015-9-9
 */
public class Md5 {
    /**
	 * 将字符串 进行 md5加密
	 * @param msg
	 * @return
	 */
	public static String md5(String msg) {
	    byte[] hash;
	    try {
	        hash = MessageDigest.getInstance("MD5").digest(msg.getBytes("UTF-8"));
	    } catch (NoSuchAlgorithmException e) {
	        throw new RuntimeException("Huh, MD5 should be supported?", e);
	    } catch (UnsupportedEncodingException e) {
	        throw new RuntimeException("Huh, UTF-8 should be supported?", e);
	    }

	    StringBuilder hex = new StringBuilder(hash.length * 2);
	    for (byte b : hash) {
	        if ((b & 0xFF) < 0x10) hex.append("0");
	        hex.append(Integer.toHexString(b & 0xFF));
	    }
	    return hex.toString();
	}
}
