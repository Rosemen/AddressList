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

	/** �õ�ָ��xml�ļ���Document���� */
	public static Document getDocument(String path) {
		try {
			SAXReader saxReader = new SAXReader();// �½�������

			Document document = saxReader.read(path);// �õ�document

			return document;
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/** ��document��д��XML�ļ���*/
	public static void writeToXML(String path,Document document) {
		try {
			OutputFormat format = OutputFormat.createPrettyPrint();//������ʽ
			
			XMLWriter xmlWriter = new XMLWriter(new FileOutputStream(path), format);//����XMLWriter����
			
			xmlWriter.write(document);//��д
			
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
