package controllers;


import com.codifyd.automation.xmlextractor.StepDataXMLHandler;
import com.codifyd.automation.xmlextractor.XMLExtractorInputUtil;

public class XMLExtractor {
	
	public String extractFile(XMLExtractorInputUtil xmlExtractorInputUtil){
		try {			
			StepDataXMLHandler stepDataXMLHandler = new StepDataXMLHandler();
			stepDataXMLHandler.handleFile(xmlExtractorInputUtil);
		} catch (Exception e) {
			return("Error occured while converting file : "+e.getMessage());
		}
		return "File generated in the input parent folder with timestamp";		
	}
}

