package com.cyl.cyllibrary.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.telephony.TelephonyManager;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 * 对于手机固有属性的 一些值的提取，如何  iemi （设备的唯一标识码） 软件版本 （md5），软件版本，系统版本 ，操作系统 等信息
 * @author 曹阳龙
 *
 * 2015-9-12
 */
public class CylPhoneUtils {

    /**
	 * 手机操作系统
	 */
	private static String os;
	/**
	 * 手机的mac地址
	 */
	private static String macAddress;
	/**
	 * 手机iemi
	 */
	private static String iemi;
	/**
	 * 软件的版本
	 */
	private static String version;
	/**
	 * 手机型号
	 */
	private static String model;
    /**
	 * 得到用户手机的iemi
	 * 
	 * @param context
	 * @return
	 */
	public static String getIemi(Context context){
		//如果不等于null 直接返回
		if(iemi != null){
			return iemi;
		}
		TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
		iemi = telephonyManager.getSimSerialNumber();
		if(iemi==null){
			//如果用户没有安装手机卡  默认 为10 个0
			iemi = "";
		}
		return iemi;
	}
	/**
	 * 得到手机号  （不是很准确 ，仅仅可以得到手机中设置的手机号）
	 * @param context
	 * @return
	 */
	public static String getPhoneNumer(Context context){
		TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
		return telephonyManager.getLine1Number();
	}


	/**
	 * ^[a-z0-9]+([._\\-]*[a-z0-9])*@([a-z0-9]+[-a-z0-9]*[a-z0-9]+.){1,63}[a-z0-9]+$   邮箱格式  和哈 
	 * 根据提供正则 匹配所给的内容是否正确 
	 * @param expre      正则表达式
	 * @param content    需要匹配的内容
	 * @return
	 */
	public static boolean machContent(String expre,String content){
		Pattern p = Pattern.compile(expre);
		Matcher matcher = p.matcher(content);
		return matcher.matches();
	}
	/**
	 * 获取手机的唯一 mac 地址
	 * @param context
	 * @return
	 */
	public static String getMacAddress(Context context){
		if(macAddress == null){
			WifiManager wifi = (WifiManager) context.getSystemService(Context.WIFI_SERVICE);
			WifiInfo info = wifi.getConnectionInfo();
			macAddress = info.getMacAddress();
		}

		return macAddress;
	}
	/**
	 * 得到运营商的国际编码
	 * @param context
	 * @return
	 */
	public static String getSubscriberId(Context context){
		TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
		String imsi = telephonyManager.getSubscriberId();
		if(imsi==null){
			imsi = telephonyManager.getSimOperator(); 
		}
		return imsi;
	}

	  /**
	   * 获得系统的版本号
	   * @param context
	   * @return
	   */
	 public static String getVersion(Context context){
		 if(version == null){
			 PackageManager manager = context.getPackageManager();
			 PackageInfo info = null;
			 try {
				 info = manager.getPackageInfo(context.getPackageName(), 0);
				 version = info.versionName;
			 } catch (NameNotFoundException e) {
				 e.printStackTrace();
				 version = "";
			 }
		 }

		 return version;
	  }
	/**
	 * 获取当前手机操作系统版本
	 * @return
	 */
	@SuppressLint("DefaultLocale")
	public static String getOs(){
		if(os == null){
			os = android.os.Build.VERSION.RELEASE;
			if(!os.toLowerCase().contains("android")){
				os = "android "+os;
			}
		}
		return os;
	}
	/**
	 * 获取手机型号
	 * @return
	 */
	public static String getPhoneModel(){
		if(model != null){
			model = android.os.Build.MODEL;
		}
		return model;
	}
}
