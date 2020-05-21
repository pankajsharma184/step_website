package controllers;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.inject.Inject;

import play.data.FormFactory;
import play.i18n.MessagesApi;
import play.mvc.Controller;
import play.mvc.Http;
import play.mvc.Result;

public class FileController extends Controller {
	
	FormFactory formFactory;
	MessagesApi messages;

	@Inject
	public FileController(FormFactory formFactory, MessagesApi messages) {
		super();
		this.formFactory = formFactory;
		this.messages = messages;
	}
	
	public Result downloadAttributeProperties() {	
		String saveFilePath = System.getProperty("java.io.tmpdir") + File.separator + "t2.properties";
		File file = new File(saveFilePath);
		return ok(file);
	}
	
	public Result downloadAttributeExcel() {	
		String saveFilePath = System.getProperty("java.io.tmpdir") + File.separator + "t1.xlsx";
		File file = new File(saveFilePath);
		return ok(file);
	}
	
	public Result downloadAttributeXML() {	
		String saveFilePath = System.getProperty("java.io.tmpdir") + File.separator + "t1.xlsx";
		File file = new File(saveFilePath);
		return ok(file);
	}
	
	

}
