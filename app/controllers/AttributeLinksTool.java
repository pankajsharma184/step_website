package controllers;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import com.codifyd.automation.attributelink.AttributeLinkExcelHandler;
import com.codifyd.automation.util.UserInputFileUtilDO;

public class AttributeLinksTool {
	
	public String convertXMLToExcel(String inputFilePath, String outputFilePath, String fileName, String configFilePath, String delimeter){
//		UserInputFileUtilDO userInputFileUtilDO = new UserInputFileUtilDO();
//		userInputFileUtilDO.setInputPath(inputFilePath);
//		userInputFileUtilDO.setOutputPath(outputFilePath);
//		userInputFileUtilDO.setFilename(fileName);
//		Properties prop = new Properties();
//		FileReader reader;
//		try {
//			reader = new FileReader(configFilePath);
//			prop.load(reader);
//	        reader.close();
//			
//		} catch (FileNotFoundException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		userInputFileUtilDO.setPropertiesFile(prop);
//		userInputFileUtilDO.setDelimeters(delimeter);
//		
//		AttributeLinkExcelHandler convertXMLToExcel = new AttributeLinkExcelHandler();
//		try {
//			convertXMLToExcel.handleFile(userInputFileUtilDO);
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		return "File Generated in path : " + outputFilePath;
	}

	public String convertExcelToXML(){
		return "need to do this";
	}
	
}
