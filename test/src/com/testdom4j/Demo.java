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
 * 演示dom4j解析 xml
 * @author Administrator
 *
 */
public class Demo {

	public static void main(String[] args) throws Exception {
		/*getNameElements();
		getSingleNameElement();*/
//		addSexToUser();
		addEmailBefore();
	}
	
	/**
	 * 在特定位置添加email元素，此处在第一个user标签下的sex前添加email
	 * 
	 * */
	public static void addEmailBefore() throws Exception{
		/**
		 * 步骤:
		 * 1.创建解析器 SAXReader
		 * 2.得到document
		 * 3.得到根结点
		 * 
		 * 4得到第一个user
		 * 5.得到user下的所有子标签，即一个list
		 * 6.使用list的add(index,element)方法添加元素，
		 * a.使用DocumentHelper新建一个element,
		 * b.element.setText(),设置文本
		 * 
		 * 7.回写到XML文件中
		 * 
		 */
		
		SAXReader saxReader =new SAXReader();
		Document document = saxReader.read("src/users.xml");
		Element root = document.getRootElement();
		Element firstUser = root.element("user");
		
		List<Element> list = firstUser.elements();
		
		Element email = DocumentHelper.createElement("email");//创建一个email元素
		email.setText("scott@163.com");
		
		list.add(2, email);
		
		//回写到XML中
		OutputFormat format = OutputFormat.createPrettyPrint();
		XMLWriter writer = new XMLWriter(new FileOutputStream("src/users.xml"), format);
		writer.write(document);
		writer.close();
	}
	
	/**添加sex元素到第一个User中
	 * @throws DocumentException 
	 * @throws Exception 
	 * @throws UnsupportedEncodingException */
	public static void addSexToUser() throws DocumentException, UnsupportedEncodingException, Exception {
		/*
		 * 步骤：
		 * 1.创建解析器 SAXReader
		 * 2.得到document
		 * 3.得到根结点
		 * 
		 * 4得到第一个user
		 * 5.添加sex元素到user
		 * 6.为sex添加文本
		 * 
		 * 7回写到XML中
		 * a.创建XMLWriter对象
		 * b.创建OutputFormat对象
		 * c.调用XMLWriter对象的write()方法
		 * d.关闭流
		 * 
		 */
		
		SAXReader saxReader = new SAXReader();
		Document document = saxReader.read("src/users.xml");
		Element root = document.getRootElement();
		
		Element firstUser = root.element("user");
		
		Element sex = firstUser.addElement("sex");//将sex添加到第一个user
		
		sex.setText("男");//为sex结点添加文本
		
		OutputFormat format = OutputFormat.createPrettyPrint();//创建输出格式，
		
		XMLWriter xmlWriter = new XMLWriter(new FileOutputStream("src/users.xml"),format);
		
	    xmlWriter.write(document);
	    
	    xmlWriter.close();
		
	    
		
	}

	/**获取所有的name元素的内容*/
	public static void getNameElements() throws DocumentException {
		/*
		 * 步骤
		 * 1.创建解析器 SAXReader
		 * 2.得到document
		 * 3.得到根结点
		 * 
		 * 4.得到所有user结点
		 * 5.得到user下的内容
		 */
		SAXReader reader = new SAXReader();//创建解析器
		
		Document document = reader.read("src/users.xml");//得到document
		
		Element root = document.getRootElement();//得到 根结点
		
		List<Element> list = root.elements("user");//得到根结点下所有的user结点
		
		for(Element ele :list) {
			Element name = ele.element("name");
			System.out.println(name.getText());
		}
	}

	public static void getSingleNameElement() throws DocumentException{
		/**
		 * 步骤：
		 * 1.创建解析器
		 * 2.获取Document
		 * 3.获取根结点
		 * 
		 * 4.得到第一个user
		 * 5.得到第一个name
		 * 6.得到name的内容
		 */
		SAXReader saxReader = new SAXReader();
		Document document = saxReader.read("src/users.xml");
		Element root = document.getRootElement();
		
		Element firstUser = root.element("user");
		Element name = firstUser.element("name");
		System.out.println(name.getText());
	}
}
