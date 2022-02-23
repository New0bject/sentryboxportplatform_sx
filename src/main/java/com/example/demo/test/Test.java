package com.example.demo.test;

import com.example.demo.util.Base64Utils;

public class Test {

	public static void main(String[] args) {
		String url = "https://xf-test6.obs.cn-east-3.myhuaweicloud.com:443/1598945442193";
		String aaa = Base64Utils.ImageToBase64ByOnline(url);
		System.out.println(aaa);
	}

}
