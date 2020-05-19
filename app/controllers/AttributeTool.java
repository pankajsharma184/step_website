package controllers;

import java.io.IOException;

import com.codifyd.automation.attribute.AttributeExcelHandler;
import com.codifyd.automation.util.UserInputFileUtilDO;

public class AttributeTool {
	
	private String inputFilePath;
	private String outputFilePath;
	private String fileName;
	private String configFilePath;
	private String delimeter;
	
	public AttributeTool() {
		super();
	}
	
	public AttributeTool(String inputFilePath, String outputFilePath, String fileName, String configFilePath, String delimeter) {
		super();
		this.inputFilePath = inputFilePath;
		this.outputFilePath = outputFilePath;
		this.fileName = fileName;
		this.configFilePath = configFilePath;
		this.delimeter = delimeter;
	}
	
	public String process() {
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

}
