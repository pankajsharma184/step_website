package controllers;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import com.codifyd.automation.stepconversion.util.AutomationConstants;
import com.codifyd.automation.stepconversion.util.FileConversionHandler;
import com.codifyd.automation.stepconversion.util.UserInputFileUtilDO;

public class LOVSchema {
	
	public String convertFile(String inputFilePath, String outputFilePath, String fileName, String configFilePath, String delimeter, FileConversionHandler handler){
		UserInputFileUtilDO userInputFileUtilDO = new UserInputFileUtilDO();
		userInputFileUtilDO.setInputPath(inputFilePath);
		userInputFileUtilDO.setOutputPath(outputFilePath);
		userInputFileUtilDO.setFilename(fileName);
		userInputFileUtilDO.setDelimeters(delimeter);
		try {
			userInputFileUtilDO.setPropertiesFile(configFilePath, AutomationConstants.LOV);
		} catch (IOException e) {
			return("Error occured while processing properties file : "+e.getMessage());
		}
		
		try {
			handler.handleFile(userInputFileUtilDO);
		} catch (Exception e) {
			return("Error occured while converting file : "+e.getMessage());
		}
		return "File Generated in path : " + outputFilePath+File.separator+fileName;
	}
	
}
