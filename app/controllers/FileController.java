package controllers;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.inject.Inject;

import com.codifyd.automation.attribute.AttributeSampleInfo;

import play.data.FormFactory;
import play.i18n.MessagesApi;
import play.mvc.Controller;
import play.mvc.Http;
import play.mvc.Result;

public class FileController extends Controller {
	
	FormFactory formFactory;
	MessagesApi messages;
	AttributeSampleInfo attributeSampleInfo;

	@Inject
	public FileController(FormFactory formFactory, MessagesApi messages) {
		super();
		this.formFactory = formFactory;
		this.messages = messages;
		attributeSampleInfo = new AttributeSampleInfo();
	}
	
	public Result downloadAttributeProperties() throws IOException {			
		return ok(attributeSampleInfo.getSamplePropertiesFile());
	}
	
	public Result downloadAttributeExcel() throws IOException{	
		return ok(attributeSampleInfo.getSampleInputExcelFile());
	}
	
	public Result downloadAttributeXML() throws IOException{	
		return ok(attributeSampleInfo.getSampleInputXMLFile());
	}
	
	

}
