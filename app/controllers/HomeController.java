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

	public Result openCalculator(Http.Request request) {
		Form<Calculator> calculatorForm = formFactory.form(Calculator.class);
		return ok(views.html.calculator.render(calculatorForm, request, messages.preferred(request)));

	}

	// public Result explore() {
	// return ok(views.html.explore.render());
	// }
	//
	// public Result tutorial() {
	// return ok(views.html.tutorial.render());
	// }
	public Result add(Http.Request req) {
		DynamicForm cForm = formFactory.form().bindFromRequest(req);
		System.out.println("Calc : 1st num is " + cForm);
		int res = new Calculator((Integer.parseInt(cForm.get("a"))), Integer.parseInt(cForm.get("b"))).add();
		return ok(views.html.result.render("1"));
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
		AttributeTool attrTool = new AttributeTool();		
		String selectedOpt = formFactory.form().bindFromRequest(request).get("types");
		String response ;
		if(selectedOpt.equals("Excel to XML")){
			response = attrTool.convertExcelToXML();
		}else{
			response = attrTool.convertXMLToExcel(form.get("inputFilePath"),
					form.get("outputFilePath"), form.get("fileName"),
					form.get("configFilePath"), form.get("delimeter"));
		}
			 
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
		AttributeLinksTool attrLinksTool = new AttributeLinksTool();		
		String selectedOpt = formFactory.form().bindFromRequest(request).get("types");
		String response ;
		if(selectedOpt.equals("Excel to XML")){
			response = attrLinksTool.convertExcelToXML();
		}else{
			response = attrLinksTool.convertXMLToExcel(form.get("inputFilePath"),
					form.get("outputFilePath"), form.get("fileName"),
					form.get("configFilePath"), form.get("delimeter"));
		}
			 
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
		LOVSchema lovSchema = new LOVSchema();		
		String selectedOpt = formFactory.form().bindFromRequest(request).get("types");
		String response ;
		if(selectedOpt.equals("Excel to XML")){
			response = lovSchema.convertExcelToXML();
		}else{
			response = lovSchema.convertXMLToExcel(form.get("inputFilePath"),
					form.get("outputFilePath"), form.get("fileName"),
					form.get("configFilePath"), form.get("delimeter"));
		}
			 
		return redirect(routes.HomeController.openLOVSchemaForm()).flashing("info", response);		
		
	}

}
