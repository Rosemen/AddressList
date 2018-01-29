package com.xml.dom4j.tools;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

public class Dom4jUtils {

	/** 得到指定xml文件的Document对象 */
	public static Document getDocument(String path) {
		try {
			SAXReader saxReader = new SAXReader();// 新建解析器

			Document document = saxReader.read(path);// 得到document

			return document;
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/** 将document回写到XML文件中*/
	public static void writeToXML(String path,Document document) {
		try {
			OutputFormat format = OutputFormat.createPrettyPrint();//创建格式
			
			XMLWriter xmlWriter = new XMLWriter(new FileOutputStream(path), format);//创建XMLWriter对象
			
			xmlWriter.write(document);//回写
			
			xmlWriter.close();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	

}
