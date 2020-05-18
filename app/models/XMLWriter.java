package models;

import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class XMLWriter {
	public Document attrDoc;
	public Document prodAttrDoc;
	public Element productsAttrLinkDoc() {
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
	    DocumentBuilder dBuilder;
	    try {
	        dBuilder = dbFactory.newDocumentBuilder();
	        prodAttrDoc= dBuilder.newDocument();
	        
	        Element stepRootElement =
	        		prodAttrDoc.createElement("STEP-ProductInformation");
	        stepRootElement.setAttribute("ContextID", "Context1");
	        stepRootElement.setAttribute("WorkspaceID", "Main");
	        prodAttrDoc.appendChild(stepRootElement);
	        
//	        Element attributeListEle = prodAttrDoc.createElement("AttributeList");
//	        stepRootElement.appendChild(attributeListEle);
//	        return attributeListEle;
	        
	        Element productsEle = prodAttrDoc.createElement("Products");
	        stepRootElement.appendChild(productsEle);
	        return productsEle;

	    } catch (Exception e) {
	        e.printStackTrace();
	    }
		return null;
		
	}
	
	public Element attributesDoc() {
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
	    DocumentBuilder dBuilder;
	   
	    try {
	        dBuilder = dbFactory.newDocumentBuilder();
	        attrDoc= dBuilder.newDocument();
	        
	        Element stepRootElement =
	        		attrDoc.createElement("STEP-ProductInformation");
	        stepRootElement.setAttribute("ContextID", "Context1");
	        stepRootElement.setAttribute("WorkspaceID", "Main");
	        attrDoc.appendChild(stepRootElement);
	        
//	        Element attributeListEle = attrDoc.createElement("AttributeList");
//	        stepRootElement.appendChild(attributeListEle);
//	        return attributeListEle;
	        
	        Element productsEle = attrDoc.createElement("AttributeList");
	        stepRootElement.appendChild(productsEle);
	        return productsEle;

	    } catch (Exception e) {
	        e.printStackTrace();
	    }
		return null;
		
	}
	
	public String transformToResultFile(Document doc, String filePath) {
		
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer;
		try {
			transformer = transformerFactory.newTransformer();
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
	        DOMSource source = new DOMSource(doc);

	        StreamResult file = new StreamResult(new File(filePath));

	        transformer.transform(source, file);
		} catch (TransformerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "File transformed and can be found at location on your computer :- "+filePath +" \n";
        
        
	}
	
}

