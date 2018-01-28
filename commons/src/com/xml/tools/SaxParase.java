package com.xml.tools;

import javax.xml.parsers.SAXParserFactory;

import java.io.IOException;
import java.io.InputStream;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;

import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class SaxParase {

	private String filePath;
	private DefaultHandler defaultHandler;

	public SaxParase() {
	}

	public SaxParase(String filePath, DefaultHandler defaultHandler) throws ParserConfigurationException, SAXException, IOException {
		super();
		this.filePath = filePath;
		this.defaultHandler = defaultHandler;
		
		SAXParserFactory factory = SAXParserFactory.newInstance();//create SAXParaseFactory instance
		SAXParser parser = factory.newSAXParser();
		
		parser.parse(filePath, defaultHandler);
		
		System.out.println("hello");
	}

}
