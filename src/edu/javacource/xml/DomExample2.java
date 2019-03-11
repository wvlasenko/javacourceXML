package edu.javacource.xml;

import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.FileOutputStream;
import java.io.IOException;

public class DomExample2 {
    public static void main(String[] args) {
        try {
            DocumentBuilder documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            Document document = documentBuilder.parse("BoockCatalogue.xml");
            addNewBoock(document);
        } catch (ParserConfigurationException ex) {
            ex.printStackTrace(System.out);

        } catch (SAXException ex) {
            ex.printStackTrace(System.out);
        } catch (IOException ex) {
            ex.printStackTrace(System.out);
        }

    }

    private static void addNewBoock(Document document) throws TransformerFactoryConfigurationError, DOMException {
        Node root = document.getDocumentElement();
        Element boock = document.createElement("Book");
        Element title = document.createElement("Title");
        title.setTextContent("Incredible book about Java");
        Element author = document.createElement("Author");
        author.setTextContent("Saburov Anton");
        Element date = document.createElement("Date");
        date.setTextContent("2015");
        Element isbn = document.createElement("ISBN");
        Element publisher = document.createElement("Publisher");
        publisher.setTextContent("Veselka");
        isbn.setTextContent("0-06-9999-9");
        Element cost = document.createElement("Cost");
        cost.setTextContent("499");
        cost.setAttribute("currency", "UAH");
        boock.appendChild(title);
        boock.appendChild(author);
        boock.appendChild(date);
        boock.appendChild(isbn);
        boock.appendChild(publisher);
        boock.appendChild(cost);
        root.appendChild(boock);
        writeDocument(document);
    }

    private static void writeDocument(Document document) throws TransformerFactoryConfigurationError {
        try {
            Transformer tr = TransformerFactory.newInstance().newTransformer();
            DOMSource source = new DOMSource(document);
            FileOutputStream fos = new FileOutputStream("other.xml");
            StreamResult result = new StreamResult(fos);
            tr.transform(source, result);
        } catch (TransformerException | IOException e) {
            e.printStackTrace(System.out);
        }
    }
}
