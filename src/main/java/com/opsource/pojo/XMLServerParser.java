package com.opsource.pojo;

import com.opsource.model.Server;
import org.springframework.beans.factory.annotation.Autowired;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.annotation.Resource;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.SchemaFactory;
import javax.xml.xpath.*;
import java.io.File;
import java.io.IOException;

public class XMLServerParser {

    // TODO: error handling - what if file is empty
    public static Server parse(String file) throws XPathExpressionException, ParserConfigurationException, IOException, SAXException {
        String SCHEMA =
                (new ResourceLocator()).getResourcePath("server.xsd");

        // parse XML file - using DOM since i don't see the file being too large
        File fXmlFile = new File(file);
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        SchemaFactory schemaFactory =
                SchemaFactory.newInstance("http://www.w3.org/2001/XMLSchema");

        dbFactory.setValidating(true);
        dbFactory.setNamespaceAware(true);
        dbFactory.setSchema(schemaFactory.newSchema(new Source[]{ new StreamSource(SCHEMA) }));

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
