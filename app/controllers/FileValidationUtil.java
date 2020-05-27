package controllers;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import play.data.DynamicForm;

public class FileValidationUtil {

	public static String validateFormForValidFiles(DynamicForm form) {
		List<String> errors = new ArrayList<>();
		String value = form.get("inputFilePath");
		if (!isNullOrBlank(value)) {
			File tmpFile = new File(value);
			if (!tmpFile.isFile()) {
				errors.add("File does not exist2 - " + value);
			}
		}
		value = form.get("outputFilePath");
		if (!isNullOrBlank(value)) {
			File tmpFile = new File(value);
			if (!tmpFile.isDirectory()) {
				errors.add("Directory does not exist - " + value);
			}
		}
		value = form.get("configFilePath");
		if (!isNullOrBlank(value)) {
			File tmpFile = new File(value);
			if (!tmpFile.exists()) {
				errors.add("File does not exist - " + value);
			}
		}

		return String.join(",", errors);
	}

	public static boolean isNullOrBlank(String param) {
		if (param == null || param.trim().length() == 0) {
			return true;
		}
		return false;
	}

	public static String getDefaultOutputDirectoryFromInput(String inputFilePath) {
		File tmpFile = new File(inputFilePath);
		return tmpFile.getParentFile().getAbsolutePath();
	}
	
	public static String setDefaultXMLFilenameFromInput(String inputFilePath) {
		File tmpFile = new File(inputFilePath);
		String fileName = tmpFile.getName();
		int pos = fileName.lastIndexOf(".");
		if (pos > 0 && pos < (fileName.length() - 1)) { // If '.' is not the first or last character.
		    fileName = fileName.substring(0, pos);
		}
		DateFormat df = new SimpleDateFormat("yyyyMMddhhmmss");		
		return "Converted_"+fileName+"_"+df.format(new Date()) + ".xml";
	}
	
	public static String setDefaultExcelFilenameFromInput(String inputFilePath) {
		File tmpFile = new File(inputFilePath);
		String fileName = tmpFile.getName();
		int pos = fileName.lastIndexOf(".");
		if (pos > 0 && pos < (fileName.length() - 1)) { // If '.' is not the first or last character.
		    fileName = fileName.substring(0, pos);
		}
		DateFormat df = new SimpleDateFormat("yyyyMMddhhmmss");		
		return "Converted_"+fileName+"_"+df.format(new Date()) + ".xlsx";
	}

}
