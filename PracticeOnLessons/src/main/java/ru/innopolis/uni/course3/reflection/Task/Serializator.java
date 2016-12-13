package ru.innopolis.uni.course3.reflection.Task;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.*;
import java.lang.reflect.Field;
import java.util.List;

/**
 * Created by Olga on 12.12.2016.
 */
public class Serializator {

    public void serialize(String fileName, List listOfObject){
        File file = new File(fileName);
        if(!file.exists()){
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        try {
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

            Document doc = docBuilder.newDocument();

            Element rootElement = doc.createElement("objects");
            doc.appendChild(rootElement);

            for(Object object : listOfObject){
                Class classObject = object.getClass();

                Element elementObject = doc.createElement("object");
                rootElement.appendChild(elementObject);

                Attr attr = doc.createAttribute("type");
                attr.setValue(classObject.getCanonicalName());
                elementObject.setAttributeNode(attr);

                for(Field field : classObject.getDeclaredFields()){
                    field.setAccessible(true);

                    Element fieldElement = doc.createElement("field");
                    elementObject.appendChild(fieldElement);

                    Attr attrType = doc.createAttribute("type");
                    attrType.setValue(field.getType().getSimpleName());
                    fieldElement.setAttributeNode(attrType);

                    Attr attrName = doc.createAttribute("name");
                    attrName.setValue(field.getName());
                    fieldElement.setAttributeNode(attrName);

                    Attr attrValue = doc.createAttribute("value");
                    attrValue.setValue(String.valueOf(field.get(object)));
                    fieldElement.setAttributeNode(attrValue);
                }

             }

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(file);

            transformer.transform(source, result);

        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (TransformerConfigurationException e) {
            e.printStackTrace();
        } catch (TransformerException e) {
            e.printStackTrace();
        }

    }
}
