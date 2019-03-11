package edu.javacource.xml;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class DomExample {
    public static void main(String[] args) {
        try {
            DocumentBuilder documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            Document document = documentBuilder.parse("BoockCatalogue.xml");
            Node root = document.getDocumentElement();
            System.out.println("List of books");
            System.out.println();
            NodeList books = ((Element) root).getChildNodes();
            for (int i = 0; i < books.getLength(); i++) {
                Node boock = books.item(i);
                if (boock.getNodeType()!= Node.TEXT_NODE){
                    NodeList boockProps = boock.getChildNodes();
                    for (int j = 0; j <boockProps.getLength() ; j++) {
                        Node boockProp = boockProps.item(j);
                        if (boockProp.getNodeType()!= Node.TEXT_NODE){
                            System.out.println(boockProp.getNodeName()  + ":" + boockProp.getChildNodes().item(0).getTextContent());

                        }

                    }
                    System.out.println("============>>>>>");
                }

            }
        }catch (ParserConfigurationException ex){
            ex.printStackTrace(System.out);
        }catch (SAXException ex){
            ex.printStackTrace(System.out);
        }catch (IOException ex){
            ex.printStackTrace(System.out);
        }

    }

}
