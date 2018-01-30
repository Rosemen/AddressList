package com.testdom4j;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.UnsupportedEncodingException;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter; 

/**
 * ��ʾdom4j���� xml
 * @author Administrator
 *
 */
public class Demo {

	public static void main(String[] args) throws Exception {
		/*getNameElements();
		getSingleNameElement();*/
		//addSexToUser();
//		addEmailBefore();
		//modify("src/users.xml");
		//deleteSex();
		String attributeValue = getValue();
		System.out.println(attributeValue);
	}
	
	/**��ȡ��ǩ������ֵ����ڶ���user������id��ֵ*/
	public static String getValue() throws Exception {
		/*
		 * 1.���������� SAXReader
		 * 2.�õ�document
		 * 3.�õ������
		 * 
		 * 4.�õ���һ��user
		 * 5.�õ�����ֵ
		 */
		SAXReader saxReader = new SAXReader();
		Document document = saxReader.read("src/users.xml");
		Element root = document.getRootElement();
		
		List<Element> list = root.elements("user");
		Element secondUser = list.get(1);
		
		String value = secondUser.attributeValue("id");
		return value;
		
	}
	
	/**ɾ����һ��user�µ�sex���*/
	public static void deleteSex() throws Exception {
		/*
		 * 1.���������� SAXReader
		 * 2.�õ�document
		 * 3.�õ������
		 * 
		 * 4.�õ���һ��user
		 * 5.�õ�user�µ�sex���
		 * 6.ͨ��user��ɾ��sex���
		 * 
		 * 7.��д
		 */
		SAXReader saxReader = new SAXReader();
		Document document = saxReader.read("src/users.xml");
		Element root = document.getRootElement();
		
		Element firstUser = root.element("user");
		Element sex = firstUser.element("sex");
		
		firstUser.remove(sex);
		
		OutputFormat format = OutputFormat.createPrettyPrint();
		XMLWriter xmlWriter = new XMLWriter(new FileOutputStream("src/users.xml"), format);
		xmlWriter.write(document);
		xmlWriter.close();
		
	}
	
	
	/**�޸ĵ�һ��user�µ�email���*/
	public static void modify(String path) throws Exception{
		/**
		 * ����:
		 * 1.���������� SAXReader
		 * 2.�õ�document
		 * 3.�õ������
		 * 
		 * 4�õ���һ��user
		 * 5.�õ�user�µ������ӱ�ǩ����һ��list
		 * 6.�õ�email�ڵ�,ʹ��setText�����޸�
		 * 
		 * 7.��д��XML�ļ���
		 * 
		 */
		
		 SAXReader saxReader = new SAXReader();
		 Document document = saxReader.read(path);
		 Element root = document.getRootElement();
		 
		 Element firstUser = root.element("user");
		 List<Element> list = firstUser.elements();
		 
		 Element email = list.get(2);
		 email.setText("chen@163.com");
		 
		 OutputFormat format = OutputFormat.createPrettyPrint();
		 XMLWriter xmlWriter = new XMLWriter(new FileOutputStream(path),format);
		 xmlWriter.write(document);
		 xmlWriter.close();
	}
	
	/**
	 * ���ض�λ�����emailԪ�أ��˴��ڵ�һ��user��ǩ�µ�sexǰ���email
	 * 
	 * */
	public static void addEmailBefore() throws Exception{
		/**
		 * ����:
		 * 1.���������� SAXReader
		 * 2.�õ�document
		 * 3.�õ������
		 * 
		 * 4�õ���һ��user
		 * 5.�õ�user�µ������ӱ�ǩ����һ��list
		 * 6.ʹ��list��add(index,element)�������Ԫ�أ�
		 * a.ʹ��DocumentHelper�½�һ��element,
		 * b.element.setText(),�����ı�
		 * 
		 * 7.��д��XML�ļ���
		 * 
		 */
		
		SAXReader saxReader =new SAXReader();
		Document document = saxReader.read("src/users.xml");
		Element root = document.getRootElement();
		Element firstUser = root.element("user");
		
		List<Element> list = firstUser.elements();
		
		Element email = DocumentHelper.createElement("email");//����һ��emailԪ��
		email.setText("scott@163.com");
		
		list.add(2, email);
		
		//��д��XML��
		OutputFormat format = OutputFormat.createPrettyPrint();
		XMLWriter writer = new XMLWriter(new FileOutputStream("src/users.xml"), format);
		writer.write(document);
		writer.close();
	}
	
	/**���sexԪ�ص���һ��User��
	 * @throws DocumentException 
	 * @throws Exception 
	 * @throws UnsupportedEncodingException */
	public static void addSexToUser() throws DocumentException, UnsupportedEncodingException, Exception {
		/*
		 * ���裺
		 * 1.���������� SAXReader
		 * 2.�õ�document
		 * 3.�õ������
		 * 
		 * 4�õ���һ��user
		 * 5.���sexԪ�ص�user
		 * 6.Ϊsex����ı�
		 * 
		 * 7��д��XML��
		 * a.����XMLWriter����
		 * b.����OutputFormat����
		 * c.����XMLWriter�����write()����
		 * d.�ر���
		 * 
		 */
		
		SAXReader saxReader = new SAXReader();
		Document document = saxReader.read("src/users.xml");
		Element root = document.getRootElement();
		
		Element firstUser = root.element("user");
		
		Element sex = firstUser.addElement("sex");//��sex��ӵ���һ��user
		
		sex.setText("��");//Ϊsex�������ı�
		
		OutputFormat format = OutputFormat.createPrettyPrint();//���������ʽ��
		
		XMLWriter xmlWriter = new XMLWriter(new FileOutputStream("src/users.xml"),format);
		
	    xmlWriter.write(document);
	    
	    xmlWriter.close();
		
	    
		
	}

	/**��ȡ���е�nameԪ�ص�����*/
	public static void getNameElements() throws DocumentException {
		/*
		 * ����
		 * 1.���������� SAXReader
		 * 2.�õ�document
		 * 3.�õ������
		 * 
		 * 4.�õ�����user���
		 * 5.�õ�user�µ�����
		 */
		SAXReader reader = new SAXReader();//����������
		
		Document document = reader.read("src/users.xml");//�õ�document
		
		Element root = document.getRootElement();//�õ� �����
		
		List<Element> list = root.elements("user");//�õ�����������е�user���
		
		for(Element ele :list) {
			Element name = ele.element("name");
			System.out.println(name.getText());
		}
	}

	public static void getSingleNameElement() throws DocumentException{
		/**
		 * ���裺
		 * 1.����������
		 * 2.��ȡDocument
		 * 3.��ȡ�����
		 * 
		 * 4.�õ���һ��user
		 * 5.�õ���һ��name
		 * 6.�õ�name������
		 */
		SAXReader saxReader = new SAXReader();
		Document document = saxReader.read("src/users.xml");
		Element root = document.getRootElement();
		
		Element firstUser = root.element("user");
		Element name = firstUser.element("name");
		System.out.println(name.getText());
	}
}
