package edu.javacource.xml;

import org.w3c.dom.Document;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;

public class XslConverter {
    public String xmlToString(String xmlFile, String xslFile) throws Exception{
        InputStream xml = new FileInputStream(xmlFile);
        InputStream xsl = new FileInputStream(xslFile);
        StreamSource xmlSource = new StreamSource(xml);
        StreamSource styleSource = new StreamSource(xsl);

        ByteArrayOutputStream  bos = new  ByteArrayOutputStream();
        StreamResult xmlOutput = new StreamResult(bos);

        Transformer transformer= TransformerFactory.newInstance().newTransformer(styleSource);
        transformer.transform(xmlSource,xmlOutput);
        return  bos.toString();
    }

    public static void main(String[] args)  throws IOException {
        XslConverter c = new XslConverter();
        final String xml = "BoockCatalogue.xml";
        final String xls = "BookCatalogue.xls";
        try {
            String result = c.xmlToString(xml, xls);
            //System.out.println(result);
            Files.write(Paths.get("BookCatalogue2.html"),Collections.singleton(result));

} catch (Exception e1) {
            e1.printStackTrace(System.out);
        }

    }


    }

