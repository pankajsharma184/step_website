package controllers;

import models.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

import javax.inject.Inject;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.codifyd.automation.attribute.AttributeExcelFileHandler;
import com.codifyd.automation.attribute.AttributeXMLFileHandler;
import com.codifyd.automation.attributelink.AttributeLinkExcelFileHandler;
import com.codifyd.automation.attributelink.AttributeLinkXMLFileHandler;
import com.codifyd.automation.lov.LovExcelFileHandler;
import com.codifyd.automation.lov.LovXMLFileHandler;
import com.codifyd.automation.util.FileConversionHandler;

import play.data.DynamicForm;
import play.data.DynamicForm.Dynamic;
import play.data.Form;
import play.data.Form.Field;
import play.data.FormFactory;
import play.i18n.Lang;
import play.i18n.Messages;
import play.i18n.MessagesApi;
import play.libs.Files.TemporaryFile;
import play.mvc.*;
import views.html.*;

/**
 * This controller contains an action to handle HTTP requests to the
 * application's home page.
 */
public class HomeController extends Controller {

	FormFactory formFactory;
	MessagesApi messages;

	@Inject
	public HomeController(FormFactory formFactory, MessagesApi messages) {
		super();
		this.formFactory = formFactory;
		this.messages = messages;
	}

	/**
	 * An action that renders an HTML page with a welcome message. The
	 * configuration in the <code>routes</code> file means that this method will
	 * be called when the application receives a <code>GET</code> request with a
	 * path of <code>/</code>.
	 */
	public Result index() {

		return ok(views.html.index.render("This is HOMEPAGE!"));
	}

	
	public Result openAttributeToolForm(Http.Request request) {
		Form<AttributeTool> attrToolForm = formFactory.form(AttributeTool.class);		
		List<String> options = new ArrayList<String>();
		options.add("Excel to XML");
		options.add("XML to Excel");		
		return ok(views.html.attributeTool.render(attrToolForm,options, request, messages.preferred(request)));

	}

	public Result attributeTool(Http.Request request) {
		DynamicForm form = formFactory.form().bindFromRequest(request);	
		String errors = FileValidationUtil.validateFormForValidFiles(form);
		if(!errors.isEmpty()){
			return redirect(routes.HomeController.openAttributeToolForm()).flashing("info", errors);	
		}
		
		String inputFilePath = form.get("inputFilePath");
		String outputFilePath = form.get("outputFilePath");
		String fileName = form.get("fileName");
		String configFilePath = form.get("configFilePath");
		String delimeter = form.get("delimeter");
		
		if(FileValidationUtil.isNullOrBlank(outputFilePath)){
			outputFilePath = FileValidationUtil.getDefaultOutputDirectoryFromInput(inputFilePath);
		}				
		
		String selectedOpt = formFactory.form().bindFromRequest(request).get("types");
		 
		FileConversionHandler handler;
		if(selectedOpt.equals("Excel to XML")){
			if(FileValidationUtil.isNullOrBlank(fileName)){
				fileName = FileValidationUtil.setDefaultXMLFilenameFromInput(inputFilePath);
			}
			handler = new AttributeExcelFileHandler();
			
		}else{
			if(FileValidationUtil.isNullOrBlank(fileName)){
				fileName = FileValidationUtil.setDefaultExcelFilenameFromInput(inputFilePath);
			}	
			handler = new AttributeXMLFileHandler();			
		}
		AttributeTool attrTool = new AttributeTool();
		String response = attrTool.convertFile(inputFilePath, outputFilePath, fileName, configFilePath, delimeter, handler);
			 
		return redirect(routes.HomeController.openAttributeToolForm()).flashing("info", response);		
		
	}
	
	public Result openAttributeLinksToolForm(Http.Request request) {
		Form<AttributeLinksTool> attrLinksToolForm = formFactory.form(AttributeLinksTool.class);		
		List<String> options = new ArrayList<String>();
		options.add("Excel to XML");
		options.add("XML to Excel");		
		return ok(views.html.attributeLinksTool.render(attrLinksToolForm,options, request, messages.preferred(request)));

	}

	public Result attributeLinksTool(Http.Request request) {
		DynamicForm form = formFactory.form().bindFromRequest(request);	
		String errors = FileValidationUtil.validateFormForValidFiles(form);
		if(!errors.isEmpty()){
			return redirect(routes.HomeController.openAttributeToolForm()).flashing("info", errors);	
		}
		String inputFilePath = form.get("inputFilePath");
		String outputFilePath = form.get("outputFilePath");
		String fileName = form.get("fileName");
		String configFilePath = form.get("configFilePath");
		String delimeter = form.get("delimeter");
		
		if(FileValidationUtil.isNullOrBlank(outputFilePath)){
			outputFilePath = FileValidationUtil.getDefaultOutputDirectoryFromInput(inputFilePath);
		}				
		
		String selectedOpt = formFactory.form().bindFromRequest(request).get("types");
		 
		FileConversionHandler handler;
		if(selectedOpt.equals("Excel to XML")){
			if(FileValidationUtil.isNullOrBlank(fileName)){
				fileName = FileValidationUtil.setDefaultXMLFilenameFromInput(inputFilePath);
			}
			handler = new AttributeLinkExcelFileHandler();
			
		}else{
			if(FileValidationUtil.isNullOrBlank(fileName)){
				fileName = FileValidationUtil.setDefaultExcelFilenameFromInput(inputFilePath);
			}	
			handler = new AttributeLinkXMLFileHandler();			
		}
		AttributeLinksTool attrLinksTool = new AttributeLinksTool();
		String response = attrLinksTool.convertFile(inputFilePath, outputFilePath, fileName, configFilePath, delimeter, handler);
			 
		return redirect(routes.HomeController.openAttributeLinksToolForm()).flashing("info", response);		
		
	}
	
	public Result openLOVSchemaForm(Http.Request request) {
		Form<LOVSchema> lovSchema = formFactory.form(LOVSchema.class);		
		List<String> options = new ArrayList<String>();
		options.add("Excel to XML");
		options.add("XML to Excel");		
		return ok(views.html.lovSchema.render(lovSchema,options, request, messages.preferred(request)));

	}

	public Result lovSchema(Http.Request request) {
		DynamicForm form = formFactory.form().bindFromRequest(request);	
		String errors = FileValidationUtil.validateFormForValidFiles(form);
		if(!errors.isEmpty()){
			return redirect(routes.HomeController.openAttributeToolForm()).flashing("info", errors);	
		}
				
		String inputFilePath = form.get("inputFilePath");
		String outputFilePath = form.get("outputFilePath");
		String fileName = form.get("fileName");
		String configFilePath = form.get("configFilePath");
		String delimeter = form.get("delimeter");
		
		if(FileValidationUtil.isNullOrBlank(outputFilePath)){
			outputFilePath = FileValidationUtil.getDefaultOutputDirectoryFromInput(inputFilePath);
		}				
		
		String selectedOpt = formFactory.form().bindFromRequest(request).get("types");
		 
		FileConversionHandler handler;
		if(selectedOpt.equals("Excel to XML")){
			if(FileValidationUtil.isNullOrBlank(fileName)){
				fileName = FileValidationUtil.setDefaultXMLFilenameFromInput(inputFilePath);
			}
			handler = new LovExcelFileHandler();
			
		}else{
			if(FileValidationUtil.isNullOrBlank(fileName)){
				fileName = FileValidationUtil.setDefaultExcelFilenameFromInput(inputFilePath);
			}	
			handler = new LovXMLFileHandler();			
		}
		LOVSchema lovSchema = new LOVSchema();	
		String response = lovSchema.convertFile(inputFilePath, outputFilePath, fileName, configFilePath, delimeter, handler);
		
		return redirect(routes.HomeController.openLOVSchemaForm()).flashing("info", response);		
		
	}
	
	public Result openBGPReportForm(Http.Request request) {
		Form<BGPReport> bgpReport = formFactory.form(BGPReport.class);				
		return ok(views.html.bgpreport.render(bgpReport,request, messages.preferred(request)));

	}

	public Result bgpReport(Http.Request request) {
		DynamicForm form = formFactory.form().bindFromRequest(request);	
		String errors = FileValidationUtil.validateFormForValidFiles(form);
		if(!errors.isEmpty()){
			return redirect(routes.HomeController.openBGPReportForm()).flashing("info", errors);	
		}
		BGPReport bgpReport = new BGPReport();			
		String response = bgpReport.generateReport(form.get("inputServerPath"),form.get("username"),
				form.get("password"),form.get("contextID"),form.get("inputFile"));			 
		return redirect(routes.HomeController.openBGPReportForm()).flashing("info", response);		
		
	}

}
