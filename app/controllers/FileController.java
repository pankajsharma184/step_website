package controllers;

import java.io.IOException;
import javax.inject.Inject;

import com.codifyd.automation.attribute.AttributeSampleInfo;
import com.codifyd.automation.attributelink.AttributeLinkSampleInfo;
import com.codifyd.automation.lov.LovSampleInfo;

import play.data.FormFactory;
import play.i18n.MessagesApi;
import play.mvc.Controller;
import play.mvc.Result;

public class FileController extends Controller {

	FormFactory formFactory;
	MessagesApi messages;
	AttributeSampleInfo attributeSampleInfo = new AttributeSampleInfo();
	AttributeLinkSampleInfo attributeLinkSampleInfo = new AttributeLinkSampleInfo();
	LovSampleInfo lovSampleInfo = new LovSampleInfo();

	@Inject
	public FileController(FormFactory formFactory, MessagesApi messages) {
		super();
		this.formFactory = formFactory;
		this.messages = messages;
	}

	public Result downloadAttributeSample(String type) throws IOException {
		if (type.equals("properties")) {
			return ok(attributeSampleInfo.getSamplePropertiesFile());
		} else if (type.equals("excel")) {
			return ok(attributeSampleInfo.getSampleInputExcelFile());
		} else if (type.equals("xml")) {
			return ok(attributeSampleInfo.getSampleInputXMLFile());
		}
		return ok();
	}
	
	public Result downloadAttributeLinksSample(String type) throws IOException {
		if (type.equals("properties")) {
			return ok(attributeLinkSampleInfo.getSamplePropertiesFile());
		} else if (type.equals("excel")) {
			return ok(attributeLinkSampleInfo.getSampleInputExcelFile());
		} else if (type.equals("xml")) {
			return ok(attributeLinkSampleInfo.getSampleInputXMLFile());
		}
		return ok();
	}
	
	public Result downloadLovSchemaSample(String type) throws IOException {
		if (type.equals("properties")) {
			return ok(lovSampleInfo.getSamplePropertiesFile());
		} else if (type.equals("excel")) {
			return ok(lovSampleInfo.getSampleInputExcelFile());
		} else if (type.equals("xml")) {
			return ok(lovSampleInfo.getSampleInputXMLFile());
		}
		return ok();
	}
	
	public Result downloadBgpReportSample(String type) throws IOException {
		if (type.equals("input")) {
			return ok(attributeSampleInfo.getSamplePropertiesFile());
		} 
		return ok();
	}

}
