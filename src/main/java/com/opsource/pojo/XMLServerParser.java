package com.opsource.pojo;

import com.opsource.model.Server;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.*;
import java.io.File;
import java.io.IOException;

/**
 * Created by Nixka on 11/10/2014.
 */
public class XMLServerParser {

    // TODO: error handling - what if file is empty
    public static Server parse(String file) throws XPathExpressionException, ParserConfigurationException, IOException, SAXException {
        // parse XML file - using DOM since i don't see the file being too large
        File fXmlFile = new File(file);
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(fXmlFile);

        // normalizing because: http://stackoverflow.com/questions/13786607/normalization-in-dom-parsing-with-java-how-does-it-work
        doc.getDocumentElement().normalize();

        XPathFactory xPathfactory = XPathFactory.newInstance();
        XPath xpath = xPathfactory.newXPath();

        XPathExpression idExpr = xpath.compile("/server/id");
        XPathExpression nameExpr = xpath.compile("/server/name");

        int id = ((Double) idExpr.evaluate(doc, XPathConstants.NUMBER)).intValue();
        String name = nameExpr.evaluate(doc);

        return new Server(id, name);
    }
}
