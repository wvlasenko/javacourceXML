package edu.javacource.xml;

import jdk.internal.util.xml.XMLStreamException;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class StaxExample {
    public static void main(String[] args) {
        final  String filename  = "BoockCatalogue.xml";
        try {
            XMLStreamReader xmlr = XMLInputFactory.newInstance().createXMLStreamReader(filename,new FileInputStream(filename));
            while (xmlr.hasNext()){
                xmlr.next();
                if (xmlr.isStartElement()) {
                    System.out.println(xmlr.getLocalName());
                } else if (xmlr.isEndElement()){
                    System.out.println("/" + xmlr.getLocalName());
                } else  if (xmlr.hasText() &&  xmlr.getText().trim().length()>0){
                    System.out.println("    " + xmlr.getText());
                }
            }
        }catch (FileNotFoundException ex){
            ex.printStackTrace();
    } catch (javax.xml.stream.XMLStreamException e) {
            e.printStackTrace();
        }
    }
}