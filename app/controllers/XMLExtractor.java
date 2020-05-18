package controllers;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import models.XMLUtils;

public class XMLExtractor {
	
	public String stepNodeTypeIDs;
	public String stepNodeType;
	public String stepNodeIDs;
	public static String inputFilePath;
	public static String outputFilePath;
	
	
	static String outputFileName;
	public static ArrayList<String> exceptionList = new ArrayList<String>();
	//This is constant variable
	static String xmlRootName = "STEP-ProductInformation";
	
	public XMLExtractor() {
		super();
	}

	public XMLExtractor(String stepNodeTypeIDs, String xmlNodes, String xmlNodeIDs, String inputFilePath, String outputFilePath) {
		super();
		this.stepNodeTypeIDs = stepNodeTypeIDs;
		this.stepNodeType = xmlNodes;
		this.stepNodeIDs = xmlNodeIDs;
		this.inputFilePath = inputFilePath;
		this.outputFilePath = outputFilePath;
	}
	
	public String getStepNodeTypeIDs() {
		return stepNodeTypeIDs;
	}

	public void setStepNodeTypeIDs(String stepNodeTypeIDs) {
		this.stepNodeTypeIDs = stepNodeTypeIDs;
	}
	
	public String getXmlNodeIDs() {
		return stepNodeIDs;
	}

	public void setXmlNodeIDs(String xmlNodeIDs) {
		this.stepNodeIDs = xmlNodeIDs;
	}
	public String getXmlNodes() {
		return stepNodeType;
	}
	
	public void setXmlNodes(String xmlNodes) {
		this.stepNodeType = xmlNodes;
	}
	public String getInputFilePath() {
		return inputFilePath;
	}
	public void setInputFilePath(String inputFilePath) {
		this.inputFilePath = inputFilePath;
	}
	public String getOutputFilePath() {
		return outputFilePath;
	}
	public void setOutputFilePath(String outputFilePath) {
		this.outputFilePath = outputFilePath;
	}

	

	public String exctractPart(Map<String,List<String>> typeIDsMap, String inFPath, String outFPath) {

		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder;
		String resFilePath = "";
		try {
			builder = factory.newDocumentBuilder();
			File file = new File(inFPath);
			if (file.exists()) {
				Document document = builder.parse(file);
				document.getDocumentElement().normalize();
				Element root = document.getDocumentElement();
				
				//String[] nodeList = properties.getProperty("xmlNodes").split(";");
				Element finalNode = null;
				Set<String> nodeNames = typeIDsMap.keySet();
				ArrayList<String> nodeIDList = new ArrayList<String>();
				ArrayList<Element> nodeElements = new ArrayList<Element>();
				for (String nodeName : nodeNames) {
//					if (nodeName.contains(":")) {
//						// nodeIDList = new ArrayList<String>(Arrays.asList(nodeName.split(":")));
//						String[] tagNameID = nodeName.split(":");
//						nodeName = tagNameID[0];
//						nodeIDList = new ArrayList<String>(Arrays.asList(tagNameID[1].split(",")));
//					}
					nodeIDList = (ArrayList<String>) typeIDsMap.get(nodeName);
				
					if (XMLUtils.tagNameValidator(document, nodeName)) {
						NodeList node = document.getElementsByTagName(nodeName);
						Document doc = XMLUtils.generateDocument();
						Element rootElement = doc.createElement(root.getNodeName());
						XMLUtils.setElementAttributes(root, rootElement);
						doc.appendChild(rootElement);
						if (nodeIDList.size() > 0) {
							NodeList children = node.item(0).getChildNodes();
							for (String nodeID : nodeIDList) {
								for (int i = 0; i < children.getLength(); i++) {
									if ((children.item(i).getNodeType() == Node.ELEMENT_NODE)
											&& nodeID.equalsIgnoreCase(children.item(i).getAttributes()
													.getNamedItem("ID").getNodeValue())) {
										Node importedNode = doc.importNode((Element) children.item(i), true);
										nodeElements.add((Element) importedNode);
										break;
									}
								}

							}
							nodeIDList.clear();
							finalNode = createNode(doc, (Element) node.item(0), nodeElements);
							rootElement.appendChild((Element) finalNode);
						} else {
							Node importedNode = doc.importNode((Element) node.item(0), true);
							rootElement.appendChild((Element) importedNode);
						}

						// TODO appending dateTimeStamp in outputFileName
						// outputFileName = nodeName + "_" + XMLUtils.currentDate() + ".xml";
						outputFileName = nodeName;
						String outPath = generateOuput(doc, outputFileName);
						resFilePath = resFilePath + outPath +"\n";
						nodeElements.clear();
					}
				}
			} else {
				System.out.println("Input file cannot be found at: " + inFPath);
			}
		} catch (ParserConfigurationException e) {
			System.out.println("Cannnot create document due to parsing exception");
			e.printStackTrace();
		} catch (SAXException | IOException e) {
			System.out.println("Parsing exception due to file not found");
			e.printStackTrace();
		} finally {
			if (!exceptionList.isEmpty()) {
				System.out.println("\n" + "Following exceptions occured");
				for (String exception : exceptionList) {
					System.out.println(exception);
				}
			}
		}
		if(resFilePath == "") {
			return "Something Went Wrong!!";
		}else {
			return "Extracted XML(s) can be found at : \n"+ resFilePath;
		}
		

	}

	/**
	 * this method generates the new xml.
	 * 
	 * @param doc new created doc with only requested tag
	 * @param outFilePath 
	 * @return 
	 */
	private static String generateOuput(Document doc, String outFilePath) {
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer;
		System.out.println("Output File - Transformed : "+outFilePath);
		File file;
		try {
			transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(doc);
			
			file = new File(outputFilePath + "/" + outputFileName+".xml");
			if(file.exists()) {
				outputFileName = outputFileName+"_"+XMLUtils.currentDate()+".xml";
				file = new File(outputFilePath + "/" + outputFileName);
			}
			StreamResult result = new StreamResult(file);
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			transformer.transform(source, result);
			System.out.println("'" + outputFileName + "' generated at " + outputFilePath);
			return file.getPath();

		} catch (TransformerException e) {
			System.out.println("Transformation exception occured while creating XML.");
			e.printStackTrace();
		}
		
		return null;

	}

	/**
	 * this method checks and create parent node if parent exists for node
	 * 
	 * @param doc       - new document
	 * @param node      - current node for which parent is being validated and if
	 *                  present it is created.
	 * @param lastChild - this the xml tag element of the tagName provided. it is
	 *                  passed as null for all other contexts.
	 * @return returns an Element with all valid parents and child node.
	 */
	public Element createNode(Document doc, Element node, ArrayList<Element> children) {

		Element currentNode = doc.createElement(node.getNodeName());
		XMLUtils.setElementAttributes(node, currentNode);
		Element parentCurrentNode = (Element) node.getParentNode();
		Element parentNode = null;
		if (children.size() > 0) {
			for (Element child : children)
				currentNode.appendChild(child);
		}
		if (!(parentCurrentNode.getNodeName().equalsIgnoreCase(xmlRootName))) {
			parentNode = doc.createElement(parentCurrentNode.getNodeName());
			parentNode.appendChild(currentNode);
			createNode(doc, parentNode, null);
		} else {
			return currentNode;
		}
		return parentNode;
	}
}
