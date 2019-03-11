package edu.javacource.xml;


import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class StaxWriteExample {
    public static void main(String[] args) {
        try {

            XMLOutputFactory output = XMLOutputFactory.newInstance();
            XMLStreamWriter writer = output.createXMLStreamWriter(new FileWriter("result.xml"));
            writer.writeStartDocument("1.0");
            writer.writeStartElement("BookCatalogue");
            for (int i = 0; i < 5 ; i++) {
                //title
                writer.writeStartElement("Book");

                writer.writeStartElement("Title");
                writer.writeCharacters("Book #" + i);
                writer.writeEndElement();
                //author
                writer.writeStartElement("Author");
                writer.writeCharacters("Author #" + i);
                writer.writeEndElement();
                //date
                writer.writeStartElement("Date");
                writer.writeCharacters(new SimpleDateFormat("yyyy - MM- dd").format(new Date()));
                writer.writeEndElement();
                //isbn
                writer.writeStartElement("ISBN");
                writer.writeCharacters("ISBN" + i);
                writer.writeEndElement();
                //publisher
                writer.writeStartElement("Publisher");
                writer.writeCharacters("Publisher" + i);
                writer.writeEndElement();
                //cost
                writer.writeStartElement("Cost");
                writer.writeAttribute("currency", "USD");
                writer.writeCharacters("" + (i+10));
                writer.writeEndElement();
                //закрываем тег book
                writer.writeEndElement();
            }
            //закрываем корневой элемент
            writer.writeEndElement();
            //закрываем документ
            writer.writeEndDocument();
            writer.flush();

        } catch (XMLStreamException | IOException ex){
            ex.printStackTrace();
        }

    }
}