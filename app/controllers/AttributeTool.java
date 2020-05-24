package controllers;

import java.io.File;
import java.io.IOException;

import com.codifyd.automation.attribute.AttributeXMLFileHandler;
import com.codifyd.automation.util.UserInputFileUtilDO;

public class AttributeTool {
	
	public String convertXMLToExcel(String inputFilePath, String outputFilePath, String fileName, String configFilePath, String delimeter){
		UserInputFileUtilDO userInputFileUtilDO = new UserInputFileUtilDO();
		userInputFileUtilDO.setInputPath(inputFilePath);
		userInputFileUtilDO.setOutputPath(outputFilePath);
		userInputFileUtilDO.setFilename(fileName);
		userInputFileUtilDO.setDelimeters(delimeter);
		try {
			userInputFileUtilDO.setPropertiesFile(configFilePath, "Attribute");
		} catch (IOException e) {
			throw new RuntimeException("Error occured while processing properties file : "+e.getMessage());
		}
		
		AttributeXMLFileHandler convertXMLToExcel = new AttributeXMLFileHandler();
		try {
			convertXMLToExcel.handleFile(userInputFileUtilDO);
		} catch (Exception e) {
			throw new RuntimeException("Error occured while converting file : "+e.getMessage());
		}
		return "File Generated in path : " + outputFilePath+File.separator+fileName;
	}

	public String convertExcelToXML(){
		return "need to do this";
	}
	
}
