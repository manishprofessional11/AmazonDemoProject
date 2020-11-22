/*****************************************************************************************************
Author: Manish Gairola
File Name: TestUtils
Date Created: 13 July 2020
About: Implements the methods to
1) Parse txtData.xml file which contains static text for the test
2) Implement Logger method for log4j logs
#*****************************************************************************************************/


package com.utils;

import java.util.HashMap;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.basepackage.BaseTestClass;

import java.io.InputStream;

public class TestUtils {
	
	public static final int WAIT = 30;

	public HashMap<String,String> parseXML (InputStream file) throws Exception {
		
			HashMap <String,String> map = new HashMap <String,String> ();
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			
			Document document = builder.parse(file);
			
			document.getDocumentElement().normalize();
			
			Element root = document.getDocumentElement();
			NodeList nodelist = document.getElementsByTagName("string");
			
			for(int i=0; i< nodelist.getLength();i++) {
				
				Node node = nodelist.item(i);
				if(node.getNodeType() == Node.ELEMENT_NODE) {
					
					Element xmlElement = (Element) node;
					map.put(xmlElement.getAttribute("name"),xmlElement.getTextContent());
					
				}

			}
			
			return map;
	}
	
	public Logger log() {
		
		return LogManager.getLogger(BaseTestClass.class.getName());
		
	}
	
	
}
