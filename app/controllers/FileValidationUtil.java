package controllers;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import play.data.DynamicForm;

public class FileValidationUtil {
	//attrToolForm.get("inputFilePath"),
	//attrToolForm.get("outputFilePath"), attrToolForm.get("fileName"),
	//attrToolForm.get("configFilePath"), attrToolForm.get("delimeter")
	public static String validateFormForValidFiles(DynamicForm form){
		List<String> errors = new ArrayList<>();
		String value = form.get("inputFilePath");
		if(!isNullOrBlank(value)){
			File tmpFile = new File(value);			
			if(!tmpFile.exists()){
				errors.add("File does not exist - "+value);
			}
		}
		value = form.get("outputFilePath");
		if(!isNullOrBlank(value)){
			File tmpFile = new File(value);			
			if(!tmpFile.isDirectory()){
				errors.add("Directory does not exist - "+value);
			}
		}
		value = form.get("configFilePath");
		if(!isNullOrBlank(value)){
			File tmpFile = new File(value);			
			if(!tmpFile.exists()){
				errors.add("File does not exist - "+value);
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


}
