package ru.innopolis.uni.course3.reflection.Task;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Olga on 12.12.2016.
 */
public class Deserializator {

    public List deserialize(String fileName) {
        List list = new ArrayList();

        File fXmlFile = new File(fileName);
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = null;
        try {
            dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(fXmlFile);
            NodeList listObject = doc.getElementsByTagName("object");

            for (int i = 0; i < listObject.getLength(); i++) {

                Node nodeObject = listObject.item(i);
                Class classObject = Class.forName(nodeObject.getAttributes().getNamedItem("type").getNodeValue());
                Object object = classObject.newInstance();

                NodeList listFields = nodeObject.getChildNodes();
                Map<String, String> mapFields = new HashMap<>();

                for (int j = 0; j < listFields.getLength(); j++){
                    Node nodeField = listFields.item(j);
                    if("field".equals(nodeField.getNodeName())){
                        String nameField = nodeField.getAttributes().getNamedItem("name").getNodeValue();
                        String typeField = nodeField.getAttributes().getNamedItem("type").getNodeValue();
                        String valueField = nodeField.getAttributes().getNamedItem("value").getNodeValue();

                        Field field = classObject.getDeclaredField(nameField);
                        field.setAccessible(true);
                        if("int".equals(typeField)){
                            field.setInt(object, Integer.valueOf(valueField));
                        }else if("StringTest".equals(typeField)){
                            field.set(object, valueField);
                        }
                    }
                }
                list.add(object);
            }
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
        return list;

    }

}
