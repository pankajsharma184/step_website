package controllers;

import java.io.File;
import java.io.IOException;

import com.codifyd.automation.stepconversion.mil.PIMDataXMLHandler;
import com.codifyd.automation.stepconversion.util.FileConversionHandler;
import com.codifyd.automation.stepconversion.util.UserInputFileUtilDO;
import com.codifyd.automation.util.AutomationConstants;
import com.codifyd.test.util.UserInputUtil;

public class MILConversion {
	
	public String convertFile(String inputFilePath, String outputFilePath, String fileName, String configFilePath, boolean isSkeleton){
		UserInputFileUtilDO userInputFileUtilDO = new UserInputFileUtilDO();
		userInputFileUtilDO.setInputPath(inputFilePath);
		userInputFileUtilDO.setOutputPath(outputFilePath);
		userInputFileUtilDO.setFilename(fileName);
		
		try {
			userInputFileUtilDO.setConfigFile(configFilePath, AutomationConstants.MIL);
		} catch (IOException e) {
			return("Error occured while processing properties file : "+e.getMessage());
		}
		
		try {
			PIMDataXMLHandler pimDataXMLHandler = new PIMDataXMLHandler();
			pimDataXMLHandler.handleFile(userInputFileUtilDO,isSkeleton);			
		} catch (Exception e) {
			return("Error occured while converting file : "+e.getMessage());
		}
		return "File Generated in path : " + outputFilePath+File.separator+fileName;
	}

	
	
}
