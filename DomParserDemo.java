package com.hsbc.xmlchecker;

import java.io.File;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

public class DomParserDemo {

		   public static void main(String[] args) {

		      try {
		         File inputFile = new File("input.txt");
		         DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		         DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		         Document doc = dBuilder.parse(inputFile);
		         doc.getDocumentElement().normalize();
//		         System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
		         NodeList nList = doc.getElementsByTagName("student");
//		         System.out.println("----------------------------");
		         ArrayList<ArrayList<String>> detail1s = new ArrayList<ArrayList<String>>();
		         
		         
		         for (int temp = 0; temp < nList.getLength(); temp++) {
		            Node nNode = nList.item(temp);
//		            System.out.println("\nCurrent Element :" + nNode.getNodeName());
		            ArrayList<String> mm = new ArrayList<String>();
		            
		            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
		               Element eElement = (Element) nNode;
//		               System.out.println("Student roll no : " 
//		                  + eElement.getAttribute("rollno"));
//		               System.out.println("First Name : " 
//		                  + eElement
//		                  .getElementsByTagName("firstname")
//		                  .item(0)
//		                  .getTextContent());
//		               System.out.println("Last Name : " 
//		                  + eElement
//		                  .getElementsByTagName("lastname")
//		                  .item(0)
//		                  .getTextContent());
//		               System.out.println("Nick Name : " 
//		                  + eElement
//		                  .getElementsByTagName("nickname")
//		                  .item(0)
//		                  .getTextContent());
//		               System.out.println("Marks : " 
//		                  + eElement
//		                  .getElementsByTagName("marks")
//		                  .item(0)
//		                  .getTextContent());
		               String fn = (String)eElement.getElementsByTagName("firstname").item(0).getTextContent();
//		               System.out.println("fn is fetched : "+fn);
		               String ln = (String)eElement.getElementsByTagName("lastname").item(0).getTextContent();
		               String nn = (String)eElement.getElementsByTagName("nickname").item(0).getTextContent();
		               String m = (String) eElement.getElementsByTagName("marks").item(0).getTextContent();
		               
		               mm.add(fn);
		               mm.add(ln);
		               mm.add(nn);
		               mm.add(m);
//		               System.out.println(mm);
		               detail1s.add(mm);
		            }
		         }
		         System.out.println(detail1s);
		      } catch (Exception e) { 
		         e.printStackTrace();
		      }
		   }
}
