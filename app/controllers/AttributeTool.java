package controllers;

import java.io.IOException;

import com.codifyd.automation.attribute.AttributeExcelHandler;
import com.codifyd.automation.util.UserInputFileUtilDO;

public class AttributeTool {
	
	public String convertXMLToExcel(String inputFilePath, String outputFilePath, String fileName, String configFilePath, String delimeter){
		UserInputFileUtilDO userInputFileUtilDO = new UserInputFileUtilDO();
		userInputFileUtilDO.setInputPath(inputFilePath);
		userInputFileUtilDO.setOutputPath(outputFilePath);
		userInputFileUtilDO.setFilename(fileName);
		userInputFileUtilDO.setPropertiesFile(null);
		userInputFileUtilDO.setDelimeters(delimeter);
		
		AttributeExcelHandler convertXMLToExcel = new AttributeExcelHandler();
		try {
			convertXMLToExcel.handleFile(userInputFileUtilDO);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "File Generated in path : " + outputFilePath;
	}

	public String convertExcelToXML(){
		return "need to do this";
	}
	
}
