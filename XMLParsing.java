package com.hsbc.xmlchecker;

import java.io.File;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class XMLParsing {
	
	public static void main(String[] args) {

	      try {
	         File inputFile = new File("product1.txt");
	         DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
	         DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
	         Document doc = dBuilder.parse(inputFile);
	         doc.getDocumentElement().normalize();
//	         System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
	         NodeList nList = doc.getElementsByTagName("product");
//	         System.out.println("----------------------------");
	         ArrayList<ArrayList<String>> detail1s = new ArrayList<ArrayList<String>>();
	         
	         
	         for (int temp = 0; temp < nList.getLength(); temp++) {
	            Node nNode = nList.item(temp);
	            ArrayList<String> mm = new ArrayList<String>();
	            
	            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
	               Element eElement = (Element) nNode;
	               String n = (String)eElement.getElementsByTagName("name").item(0).getTextContent();
	               String p = (String)eElement.getElementsByTagName("price").item(0).getTextContent();
	               String pc = (String)eElement.getElementsByTagName("product_categories").item(0).getTextContent();
	               
	               mm.add(n);
	               mm.add(p);
	               mm.add(pc);
	               detail1s.add(mm);
	            }
	         }
	         System.out.println(detail1s);
	      } catch (Exception e) { 
	         e.printStackTrace();
	      }
	   }

}
