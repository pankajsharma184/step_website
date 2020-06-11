package controllers;

import models.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
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

import com.codifyd.automation.stepconversion.attributelink.AttributeLinkExcelFileHandler;
import com.codifyd.automation.stepconversion.attributelink.AttributeLinkXMLFileHandler;
import com.codifyd.automation.stepconversion.attributeschema.AttributeExcelFileHandler;
import com.codifyd.automation.stepconversion.attributeschema.AttributeXMLFileHandler;
import com.codifyd.automation.stepconversion.lovschema.LovExcelFileHandler;
import com.codifyd.automation.stepconversion.lovschema.LovXMLFileHandler;
import com.codifyd.automation.stepconversion.util.FileConversionHandler;
import com.codifyd.automation.xmlextractor.XMLExtractorInputUtil;

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
		return ok(views.html.attributeTool.render(attrToolForm, options, request, messages.preferred(request)));

	}

	public Result attributeTool(Http.Request request) {
		DynamicForm form = formFactory.form().bindFromRequest(request);
		String errors = FileValidationUtil.validateFormForValidFiles(form);
		if (!errors.isEmpty()) {
			return redirect(routes.HomeController.openAttributeToolForm()).flashing("info", errors);
		}

		String inputFilePath = form.get("inputFilePath");
		String outputFilePath = form.get("outputFilePath");
		String fileName = form.get("fileName");
		String configFilePath = form.get("configFilePath");
		String delimeter = form.get("delimeter");

		if (FileValidationUtil.isNullOrBlank(outputFilePath)) {
			outputFilePath = FileValidationUtil.getDefaultOutputDirectoryFromInput(inputFilePath);
		}

		String selectedOpt = formFactory.form().bindFromRequest(request).get("types");

		FileConversionHandler handler;
		if (selectedOpt.equals("Excel to XML")) {
			if (FileValidationUtil.isNullOrBlank(fileName)) {
				fileName = FileValidationUtil.setDefaultXMLFilenameFromInput(inputFilePath);
			}
			handler = new AttributeExcelFileHandler();

		} else {
			if (FileValidationUtil.isNullOrBlank(fileName)) {
				fileName = FileValidationUtil.setDefaultExcelFilenameFromInput(inputFilePath);
			}
			handler = new AttributeXMLFileHandler();
		}
		AttributeTool attrTool = new AttributeTool();
		String response = attrTool.convertFile(inputFilePath, outputFilePath, fileName, configFilePath, delimeter,
				handler);

		return redirect(routes.HomeController.openAttributeToolForm()).flashing("info", response);

	}

	public Result openAttributeLinksToolForm(Http.Request request) {
		Form<AttributeLinksTool> attrLinksToolForm = formFactory.form(AttributeLinksTool.class);
		List<String> options = new ArrayList<String>();
		options.add("Excel to XML");
		options.add("XML to Excel");
		return ok(
				views.html.attributeLinksTool.render(attrLinksToolForm, options, request, messages.preferred(request)));

	}

	public Result attributeLinksTool(Http.Request request) {
		DynamicForm form = formFactory.form().bindFromRequest(request);
		String errors = FileValidationUtil.validateFormForValidFiles(form);
		if (!errors.isEmpty()) {
			return redirect(routes.HomeController.openAttributeToolForm()).flashing("info", errors);
		}
		String inputFilePath = form.get("inputFilePath");
		String outputFilePath = form.get("outputFilePath");
		String fileName = form.get("fileName");
		String configFilePath = form.get("configFilePath");
		String delimeter = form.get("delimeter");

		if (FileValidationUtil.isNullOrBlank(outputFilePath)) {
			outputFilePath = FileValidationUtil.getDefaultOutputDirectoryFromInput(inputFilePath);
		}

		String selectedOpt = formFactory.form().bindFromRequest(request).get("types");

		FileConversionHandler handler;
		if (selectedOpt.equals("Excel to XML")) {
			if (FileValidationUtil.isNullOrBlank(fileName)) {
				fileName = FileValidationUtil.setDefaultXMLFilenameFromInput(inputFilePath);
			}
			handler = new AttributeLinkExcelFileHandler();

		} else {
			if (FileValidationUtil.isNullOrBlank(fileName)) {
				fileName = FileValidationUtil.setDefaultExcelFilenameFromInput(inputFilePath);
			}
			handler = new AttributeLinkXMLFileHandler();
		}
		AttributeLinksTool attrLinksTool = new AttributeLinksTool();
		String response = attrLinksTool.convertFile(inputFilePath, outputFilePath, fileName, configFilePath, delimeter,
				handler);

		return redirect(routes.HomeController.openAttributeLinksToolForm()).flashing("info", response);

	}

	public Result openLOVSchemaForm(Http.Request request) {
		Form<LOVSchema> lovSchema = formFactory.form(LOVSchema.class);
		List<String> options = new ArrayList<String>();
		options.add("Excel to XML");
		options.add("XML to Excel");
		return ok(views.html.lovSchema.render(lovSchema, options, request, messages.preferred(request)));

	}

	public Result lovSchema(Http.Request request) {
		DynamicForm form = formFactory.form().bindFromRequest(request);
		String errors = FileValidationUtil.validateFormForValidFiles(form);
		if (!errors.isEmpty()) {
			return redirect(routes.HomeController.openAttributeToolForm()).flashing("info", errors);
		}

		String inputFilePath = form.get("inputFilePath");
		String outputFilePath = form.get("outputFilePath");
		String fileName = form.get("fileName");
		String configFilePath = form.get("configFilePath");
		String delimeter = form.get("delimeter");

		if (FileValidationUtil.isNullOrBlank(outputFilePath)) {
			outputFilePath = FileValidationUtil.getDefaultOutputDirectoryFromInput(inputFilePath);
		}

		String selectedOpt = formFactory.form().bindFromRequest(request).get("types");

		FileConversionHandler handler;
		if (selectedOpt.equals("Excel to XML")) {
			if (FileValidationUtil.isNullOrBlank(fileName)) {
				fileName = FileValidationUtil.setDefaultXMLFilenameFromInput(inputFilePath);
			}
			handler = new LovExcelFileHandler();

		} else {
			if (FileValidationUtil.isNullOrBlank(fileName)) {
				fileName = FileValidationUtil.setDefaultExcelFilenameFromInput(inputFilePath);
			}
			handler = new LovXMLFileHandler();
		}
		LOVSchema lovSchema = new LOVSchema();
		String response = lovSchema.convertFile(inputFilePath, outputFilePath, fileName, configFilePath, delimeter,
				handler);

		return redirect(routes.HomeController.openLOVSchemaForm()).flashing("info", response);

	}

	public Result openBGPReportForm(Http.Request request) {
		Form<BGPReport> bgpReport = formFactory.form(BGPReport.class);
		return ok(views.html.bgpreport.render(bgpReport, request, messages.preferred(request)));

	}

	public Result bgpReport(Http.Request request) {
		DynamicForm form = formFactory.form().bindFromRequest(request);
		String errors = FileValidationUtil.validateFormForValidFiles(form);
		if (!errors.isEmpty()) {
			return redirect(routes.HomeController.openBGPReportForm()).flashing("info", errors);
		}
		BGPReport bgpReport = new BGPReport();
		String response = bgpReport.generateReport(form.get("inputServerPath"), form.get("username"),
				form.get("password"), form.get("contextID"), form.get("inputFilePath"));
		return redirect(routes.HomeController.openBGPReportForm()).flashing("info", response);

	}

	public Result openMILConversionForm(Http.Request request) {
		Form<MILConversion> milConversionForm = formFactory.form(MILConversion.class);
		List<String> options = new ArrayList<String>();
		options.add("TypeA");
		options.add("TypeC");
		return ok(views.html.milConversion.render(milConversionForm, options, request, messages.preferred(request)));

	}

	public Result milConversion(Http.Request request) {
		DynamicForm form = formFactory.form().bindFromRequest(request);
		String errors = FileValidationUtil.validateFormForValidFiles(form);
		if (!errors.isEmpty()) {
			return redirect(routes.HomeController.openMILConversionForm()).flashing("info", errors);
		}
		String inputFilePath = form.get("inputFilePath");
		String outputFilePath = form.get("outputFilePath");
		String fileName = form.get("fileName");
		String configFilePath = form.get("configFilePath");

		if (FileValidationUtil.isNullOrBlank(outputFilePath)) {
			outputFilePath = FileValidationUtil.getDefaultOutputDirectoryFromInput(inputFilePath);
		}
		if (FileValidationUtil.isNullOrBlank(fileName)) {
			fileName = FileValidationUtil.setDefaultXMLFilenameFromInput(inputFilePath);
		}

		String selectedOpt = formFactory.form().bindFromRequest(request).get("types");

		boolean isSkeleton = true;
		if (selectedOpt.equals("TypeA")) {
			isSkeleton = true;
		} else if (selectedOpt.equals("TypeC")) {
			isSkeleton = false;
		}
		MILConversion milConversion = new MILConversion();
		String response = milConversion.convertFile(inputFilePath, outputFilePath, fileName, configFilePath,
				isSkeleton);
		return redirect(routes.HomeController.openMILConversionForm()).flashing("info", response);
	}

	public Result openXMLExtractorForm(Http.Request request) {
		Form<XMLExtractor> extractorForm = formFactory.form(XMLExtractor.class);
		List<String> nodeTypes = new ArrayList<>();
		Arrays.asList(XMLExtractorInputUtil.class.getFields()).forEach(field -> {
			if (Modifier.isPublic(field.getModifiers())) {
				nodeTypes.add(field.getName());
			}
		});

		return ok(views.html.xmlExtractor.render(extractorForm, nodeTypes, request, messages.preferred(request)));

	}

	public Result XMLExtractor(Http.Request request) {
		DynamicForm form = formFactory.form().bindFromRequest(request);
		String errors = FileValidationUtil.validateFormForValidFiles(form);
		if (!errors.isEmpty()) {
			return redirect(routes.HomeController.openXMLExtractorForm()).flashing("info", errors);
		}
		
		XMLExtractorInputUtil xmlExtractorInputUtil = new XMLExtractorInputUtil();
		try {
			int i = 1;
			while (form.get("stepNodeIDs_" + i) != null) {				
				String nodeType = form.get("stepNodeType_" + i);				
				String nodeIDs = form.get("stepNodeIDs_" + i);				
				if (!nodeIDs.isEmpty()) {
					// set the value					
					Method method = xmlExtractorInputUtil.getClass().getMethod("set" + nodeType,
							new Class[] { nodeIDs.getClass() });
					method.invoke(xmlExtractorInputUtil, nodeIDs);
				}
				i++;
			}
		} catch (NoSuchMethodException | IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}

		String inputFilePath = form.get("inputFilePath");
		xmlExtractorInputUtil.setInputFilePath(inputFilePath);
		XMLExtractor extractor = new XMLExtractor();
		String response = extractor.extractFile(xmlExtractorInputUtil);
		return redirect(routes.HomeController.openXMLExtractorForm()).flashing("info", response);
	}

}
