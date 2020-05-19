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
		return ok(views.html.result.render(res));
	}

	public Result openExcelToXMLForm(Http.Request r) {
		Form<ExcelToXMLConverter> calculatorForm = formFactory.form(ExcelToXMLConverter.class);
		List<String> options = new ArrayList<String>();
		options.add("Yes");
		options.add("No");
		options.add("One");
		options.add("Two");
		options.add("Three");
		options.add("Four");
		return ok(views.html.exceltoxml.render(calculatorForm, options, r, messages.preferred(r)));

	}

	public Result generateXMLFile(Http.Request r) {
		Http.MultipartFormData<TemporaryFile> body = r.body().asMultipartFormData();
		Http.MultipartFormData.FilePart<TemporaryFile> excelFile = body.getFile("excelFile");
		String selectedOpt = formFactory.form().bindFromRequest(r).get("opt");
		System.out.println("Option selected is : " + selectedOpt);

		if (excelFile != null) {
			String fileName = excelFile.getFilename();
			TemporaryFile file = excelFile.getRef();
			file.copyTo(Paths.get("\\Temp\\" + fileName), true);
			File inFile = new File("\\Temp\\" + fileName);
			ExcelToXMLConverter conv = new ExcelToXMLConverter();
			String response = conv.generateXML(inFile);
			if (inFile.exists()) {
				inFile.delete();
			}
			return ok(views.html.index.render("Conversion DONE: " + response));
		} else {
			return badRequest().flashing("error", "Missing file");
		}

	}

	public Result openXMLExtractForm(Http.Request request) {
		Form<XMLExtractor> extractorForm = formFactory.form(XMLExtractor.class);
		String[] nodeTypeArr = { "AttributeList", "Products", "Classifications", "Businss Rule", "Assets" };
		List<String> nodeTypes = new ArrayList<String>();
		for (String s : nodeTypeArr) {
			nodeTypes.add(s);
		}
		return ok(views.html.xmlextractor.render(extractorForm, nodeTypes, request, messages.preferred(request)));

	}

	public Result extractPartXML(Http.Request r) {
		DynamicForm extractXMLForm = formFactory.form().bindFromRequest(r);
		Set<String> stepNodeTypeIDsField = r.body().asFormUrlEncoded().keySet();// get("result");
		// String fieldVal = stepNodeTypeIDsField[0];
		// System.out.println("Res ; "+stepNodeTypeIDsField);
		// AttributeList:ATT_UPC,ATT_EAN|AttributeList:ATT_EAN|
		String nodeTypeIDs = extractXMLForm.get("stepNodeTypeIDs");
		// System.out.println(nodeTypeIDs);
		Map<String, List<String>> nodeIDsMap = new HashMap<>();
		String[] eachNodeArr = nodeTypeIDs.split("\\|");
		for (String s : eachNodeArr) {
			// System.out.println(s);
			if (!s.isEmpty()) {
				String[] typeArr = s.split(":");
				// System.out.println(typeArr.length );
				String type = typeArr[0];
				String rawIDsStr = typeArr[1];
				List<String> idsList = new ArrayList<>();
				if (rawIDsStr != null && !rawIDsStr.isEmpty()) {
					String[] idsArr = rawIDsStr.split(",");
					List<String> idsFromMap = nodeIDsMap.get(type);
					for (String a : idsArr) {
						if (!a.isEmpty()) {
							if (idsFromMap != null) {
								idsFromMap.add(a);
							} else {
								idsList.add(a);
							}
						}
					}
					if (idsFromMap != null) {
						nodeIDsMap.put(type, idsFromMap);
					} else {
						if (idsList.size() > 0) {
							nodeIDsMap.put(type, idsList);
						}
					}

				}
			}

		}
		// String nodeType = extractXMLForm.get("stepNodeType");
		// String nodeIDs = extractXMLForm.get("stepNodeIDs");
		String inputFilePath = extractXMLForm.get("inputFilePath");
		String outFilePath = extractXMLForm.get("outputFilePath");

		// System.out.println("Node Type : "+inputFilePath);
		// System.out.println("Node ID : "+nodeIDs);
		XMLExtractor extractor = new XMLExtractor(nodeTypeIDs, "", "", inputFilePath, outFilePath);
		String outPath = extractor.exctractPart(nodeIDsMap, extractor.getInputFilePath(),
				extractor.getOutputFilePath());
		return ok(views.html.index.render(outPath));
	}

	public Result openXMLDiffFinderForm(Http.Request request) {
		Form<XMLDiffFinder> diffFinderForm = formFactory.form(XMLDiffFinder.class);
		return ok(views.html.xmldifffinder.render(diffFinderForm, request, messages.preferred(request)));

	}

	public Result xmldifffinder(Http.Request request) {
		DynamicForm diffFindXMLForm = formFactory.form().bindFromRequest(request);
		String srcFPath = diffFindXMLForm.get("sourceFilePath");
		String tarFPath = diffFindXMLForm.get("targetFilePath");
		XMLDiffFinder diffFinder = new XMLDiffFinder(srcFPath, tarFPath);
		String response = diffFinder.findDifference(srcFPath, tarFPath);
		return ok(views.html.index.render(response));
	}

	public Result openAttributeToolForm(Http.Request request) {
		Form<AttributeTool> attrToolForm = formFactory.form(AttributeTool.class);
		return ok(views.html.attributeTool.render(attrToolForm, request, messages.preferred(request)));

	}

	public Result attributeTool(Http.Request request) {
		DynamicForm attrToolForm = formFactory.form().bindFromRequest(request);
		String srcFPath = attrToolForm.get("sourceFilePath");
		String tarFPath = attrToolForm.get("targetFilePath");
		// String inputFilePath, String outputFilePath, String fileName, String
		// configFilePath, String delimeter
		AttributeTool attrTool = new AttributeTool(attrToolForm.get("inputFilePath"),
				attrToolForm.get("outputFilePath"), attrToolForm.get("fileName"),
				attrToolForm.get("configFilePath"), attrToolForm.get("delimeter"));
		String response = attrTool.process();
		return ok(views.html.index.render(response));
	}

}
