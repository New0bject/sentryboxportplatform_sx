package com.example.demo.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class HttpClient {

    /**
     * 支持的Http method
     * 
     */
    private static enum HttpMethod {
	POST, DELETE, GET, PUT, HEAD;
    }

    private static String invokeUrl(String url, String params,
	    Map<String, String> headers, int connectTimeout, int readTimeout,
	    String encoding, HttpMethod method) {
	// 只有POST方法才能通过OutputStream(即form的形式)提交参数
	if (method != HttpMethod.POST) {
	    if (params.indexOf('=') != -1) {
		url += "?" + params;
	    } else {
		url += params;
	    }
	}
	URL uUrl = null;
	HttpURLConnection conn = null;
	BufferedWriter out = null;
	BufferedReader in = null;
	try {
	    if (url.indexOf(" ") != -1) {
		String path = url.replaceAll(" ", "%20");
		uUrl = new URL(path);
	    } else {
		uUrl = new URL(url);
	    }
//	    System.out.println(uUrl);
	    conn = (HttpURLConnection) uUrl.openConnection();
	    conn.setRequestProperty("content-type",
		    "application/x-www-form-urlencoded");

	    conn.setRequestMethod(method.toString());
	    conn.setDoInput(true);
	    conn.setDoOutput(true);
	    // 设置连接超时时间
	    conn.setConnectTimeout(connectTimeout);
	    // 设置读取超时时间
	    conn.setReadTimeout(readTimeout);
	    // 指定请求header参数
	    if (headers != null && headers.size() > 0) {
		Set<String> headerSet = headers.keySet();
		for (String key : headerSet) {
		    conn.setRequestProperty(key, headers.get(key));
		}
	    }

	    if (params != null && method == HttpMethod.POST) {
		// 发送请求参数
		out = new BufferedWriter(new OutputStreamWriter(
			conn.getOutputStream(), encoding));
		out.write(params);
		out.flush();
	    }

	    // 接收返回结果
	    StringBuilder result = new StringBuilder();
	    in = new BufferedReader(new InputStreamReader(
		    conn.getInputStream(), encoding));
	    if (in != null) {
		String line = "";
		while ((line = in.readLine()) != null) {
		    result.append(line);
		}
	    }
	    return result.toString().replace("null", "\"\"");// 把null转成空字符串
	} catch (Exception e) {
	    System.err.println("调用接口[" + url + "]失败!参数:" + params + new Date());
	    // 处理错误流，提高http连接被重用的几率
	    try {
		byte[] buf = new byte[100];
		InputStream es = conn.getErrorStream();
		if (es != null) {
		    while (es.read(buf) > 0) {
			es.close();
		    }
		}
	    } catch (Exception el) {
		el.printStackTrace();
	    }
	    return "";
	} finally {
	    try {
		if (out != null) {
		    out.close();
		}
	    } catch (Exception e) {
		e.printStackTrace();
	    }
	    try {
		if (in != null) {
		    in.close();
		}
	    } catch (Exception e) {
		e.printStackTrace();
	    }
	    // 关闭连接
	    if (conn != null) {
		conn.disconnect();
	    }
	}
    }

    /**
     * POST方法提交Http请求，语义为"增加" <br/>
     * 注意：Http方法中只有POST方法才能使用body来提交内容
     * 
     * @return
     */
    public static String post(String url, String params, int connectTimeout,
	    int readTimeout, String charset) {
	return invokeUrl(url, params, null, connectTimeout, readTimeout,
		charset, HttpMethod.POST);
    }

    /**
     * POST方法提交Http请求，语义为"增加" <br/>
     * 注意：Http方法中只有POST方法才能使用body来提交内容
     * 
     * @return
     */
    public static String sendPost(String url, String params,
	    int connectTimeout, int readTimeout, String charset) {
	Map<String, String> headers = new HashMap<String, String>();
	headers.put("Content-Type", "application/json");
	return invokeUrl(url, params, headers, connectTimeout, readTimeout,
		charset, HttpMethod.POST);
    }

    /**
     * GET方法提交Http请求，语义为"查询"
     * 
     * @return
     */
    public static String get(String url, String params, int connectTimeout,
	    int readTimeout, String charset) {
	return invokeUrl(url, params, null, connectTimeout, readTimeout,
		charset, HttpMethod.GET);
    }

    /**
     * GET方法提交Http请求，语义为"查询"
     * 
     * @return
     */
    public static String get(String url, String params,
	    Map<String, String> headers, int connectTimeout, int readTimeout,
	    String charset) {
	return invokeUrl(url, params, headers, connectTimeout, readTimeout,
		charset, HttpMethod.GET);
    }

    /**
     * PUT方法提交Http请求，语义为"更改"<br/>
     * 注意：PUT方法也是使用url提交参数内容而非body，所以参数最大长度收到服务器端实现的限制，Resin大概是8K
     * 
     * @return
     */
    public static String put(String url, String params, int connectTimeout,
	    int readTimeout, String charset) {
	return invokeUrl(url, params, null, connectTimeout, readTimeout,
		charset, HttpMethod.PUT);
    }

    /**
     * PUT方法提交Http请求，语义为"更改" <br/>
     * 注意：PUT方法也是使用url提交参数内容而非body，所以参数最大长度收到服务器端实现的限制，Resin大概是8K
     */
    public static String put(String url, String params,
	    Map<String, String> headers, int connectTimeout, int readTimeout,
	    String charset) {
	return invokeUrl(url, params, headers, connectTimeout, readTimeout,
		charset, HttpMethod.PUT);
    }

    /**
     * DELETE方法提交Http请求，语义为"删除"
     */
    public static String delete(String url, String params, int connectTimeout,
	    int readTimeout, String charset) {
	return invokeUrl(url, params, null, connectTimeout, readTimeout,
		charset, HttpMethod.DELETE);
    }

    public static String delete(String url, String params,
	    Map<String, String> headers, int connectTimeout, int readTimeout,
	    String charset) {
	return invokeUrl(url, params, headers, connectTimeout, readTimeout,
		charset, HttpMethod.DELETE);
    }

    public static String head(String url, String params, int connectTimeout,
	    int readTimeout, String charset) {
	return invokeUrl(url, params, null, connectTimeout, readTimeout,
		charset, HttpMethod.HEAD);
    }

    public static String head(String url, String params,
	    Map<String, String> headers, int connectTimeout, int readTimeout,
	    String charset) {
	return invokeUrl(url, params, headers, connectTimeout, readTimeout,
		charset, HttpMethod.HEAD);
    }

    /**
     * 将Map分割
     * 
     * @param paramMap
     * @return String
     */
    public static String prepareParam(Map<String, Object> paramMap) {
	if (paramMap == null || paramMap.isEmpty()) {
	    return null;
	} else {
	    StringBuffer sb = new StringBuffer();
	    for (String key : paramMap.keySet()) {
		if (sb.length() < 1) {
		    sb.append(key).append("=");
		} else {
		    sb.append("&").append(key).append("=");
		}
		if (paramMap.get(key) != null) {
		    String value = paramMap.get(key).toString();
		    sb.append(value);
		}
	    }
	    return sb.toString();
	}
    }

    /**
     * 将Map分割成 例如—id-name
     */
    public static String Param(Map<String, Object> paramMap) {
	if (paramMap == null || paramMap.isEmpty()) {
	    return null;
	} else {
	    StringBuffer sb = new StringBuffer();
	    for (String key : paramMap.keySet()) {
		if (paramMap.get(key) != null) {
		    String value = paramMap.get(key).toString();
		    if (sb.length() < 1) {
			sb.append("-").append(value);
		    } else {
			sb.append("-").append(value);
		    }
		}
	    }
	    return sb.toString();
	}
    }
}
