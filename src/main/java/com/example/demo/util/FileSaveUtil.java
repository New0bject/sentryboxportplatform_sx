package com.example.demo.util;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.multipart.MultipartFile;

public class FileSaveUtil {

	public static String saveSignPic(String savePath,String visitPath, String picName, MultipartFile file) throws IOException {

		// 文件名 = userId + UUID
		String fileName = picName + UUID.randomUUID() + ".png";
		FileOutputStream fos = FileUtils.openOutputStream(new File(savePath , fileName));
		IOUtils.copy(file.getInputStream(), fos);
		fos.close();
		
		return visitPath + fileName;

	}
	
	public static String saveSignPic2(String savePath,String visitPath, String picName, MultipartFile file) throws IOException {

		// 文件名 = userId + 时间戳
		String fileName = picName;
		FileOutputStream fos = FileUtils.openOutputStream(new File(savePath + fileName));
		IOUtils.copy(file.getInputStream(), fos);
		fos.close();

		return visitPath + fileName;

	}
	
	public static String saveVoicefile(String savePath,String visitPath, String picName, MultipartFile file) throws IOException {

		// 文件名 = userId + 时间戳
		String fileName = picName+ ".amr";;
		FileOutputStream fos = FileUtils.openOutputStream(new File(savePath + fileName));
		try {
			int a = IOUtils.copy(file.getInputStream(), fos);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		fos.close();

		return visitPath + fileName;

	}
	
	public static String saveMp4file(String savePath,String visitPath, String picName, MultipartFile file) throws IOException {

		// 文件名 = userId + 时间戳
		String fileName = picName+ ".mp4";;
		FileOutputStream fos = FileUtils.openOutputStream(new File(savePath + fileName));
		IOUtils.copy(file.getInputStream(), fos);
		fos.close();

		return visitPath + fileName;

	}

}