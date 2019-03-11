package edy.javacource.xml.sax;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class SaxExample {
    public static void main(String[] args) {
        final  String fileName = "PhoneBock.xml";
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser  = factory.newSAXParser();
            DefaultHandler handler = new DefaultHandler(){
                boolean name = false;
           public void startElement (String url, String localName, String qName, Attributes attributes) throws SAXException{
               if (qName.equalsIgnoreCase("NAME")){
                   name=true;
               }
           }
           public void characters (char ch[],int start, int length) throws SAXException{
               if (name){
                   System.out.println("Name: " + new String(ch,start,length));
                   name = false;
               }
           }

            };
            ((SAXParser) saxParser).parse(fileName,handler);

        } catch (Exception e){
            e.printStackTrace();
        }


    }
}
