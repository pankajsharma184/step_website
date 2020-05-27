package controllers;

import java.io.IOException;
import javax.inject.Inject;

import com.codifyd.automation.attribute.AttributeSampleInfo;

import play.data.FormFactory;
import play.i18n.MessagesApi;
import play.mvc.Controller;
import play.mvc.Result;

public class FileController extends Controller {
	
	FormFactory formFactory;
	MessagesApi messages;
	AttributeSampleInfo attributeSampleInfo= new AttributeSampleInfo();

	@Inject
	public FileController(FormFactory formFactory, MessagesApi messages) {
		super();
		this.formFactory = formFactory;
		this.messages = messages;		
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
