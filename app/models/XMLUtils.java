package models;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.NodeList;

import controllers.XMLExtractor;

public class XMLUtils {

	/**
	 * @return new blank Document
	 */
	public static Document generateDocument() {
		DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder docBuilder = null;
		try {
			docBuilder = docFactory.newDocumentBuilder();

		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		}
		return docBuilder.newDocument();
	}

	/**
	 * This method sets all Attributes and Attribute values present on the original
	 * XmlTag on to the newly created xmlTag
	 * 
	 * @param originalNode - Original XMLTag
	 * @param newNode      - New XmlNode created on which the Attributes are set.
	 * @return returns new xmlNode with all Attributes.
	 */
	public static Element setElementAttributes(Element originalNode, Element newNode) {
		NamedNodeMap elementAttributes = originalNode.getAttributes();
		if (elementAttributes.getLength() > 0) {
			int elementAttributeCount = elementAttributes.getLength();
			for (int i = 0; i < elementAttributeCount; i++) {
				newNode.setAttribute(elementAttributes.item(i).getNodeName(), elementAttributes.item(i).getNodeValue());
			}
		}

		return newNode;
	}

	/**
	 * This method validates if the tagName provided exists in the Original Xml.
	 * 
	 * @param doc     - Xml provided as an input file
	 * @param tagName - tagName for which new Xml is to created
	 * @return returns true if tag is present else returns false
	 */
	public static boolean tagNameValidator(Document doc, String tagName) {
		NodeList node = doc.getElementsByTagName(tagName);
		if (node.getLength() > 0) {
			return true;
		}
		XMLExtractor.exceptionList.add("Tag '" + tagName + "' does not exist in the XML.");
		// System.out.println("Tag '"+ tagName+"' does not exist in the XML.");
		return false;
	}

	public static String currentDate() {
		DateFormat dateFormat = new SimpleDateFormat("ddMMMyy_HHmm");
		Date date = new Date();
		return dateFormat.format(date);
	}
}

