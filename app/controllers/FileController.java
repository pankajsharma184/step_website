package controllers;

import java.io.IOException;
import javax.inject.Inject;

import com.codifyd.automation.bgp.BGPReportSampleInfo;
import com.codifyd.automation.stepconversion.attributelink.AttributeLinkSampleInfo;
import com.codifyd.automation.stepconversion.attributeschema.AttributeSampleInfo;
import com.codifyd.automation.stepconversion.lovschema.LovSampleInfo;
import com.codifyd.automation.stepconversion.mil.MILSampleInfo;

import play.data.FormFactory;
import play.i18n.MessagesApi;
import play.mvc.Controller;
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

	public Result downloadAttributeSample(String type) throws IOException {
		AttributeSampleInfo attributeSampleInfo = new AttributeSampleInfo();
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
		AttributeLinkSampleInfo attributeLinkSampleInfo = new AttributeLinkSampleInfo();
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
		LovSampleInfo lovSampleInfo = new LovSampleInfo();
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
		BGPReportSampleInfo bgpReportSampleInfo = new BGPReportSampleInfo();
		if (type.equals("input")) {
			return ok(bgpReportSampleInfo.getSampleInputFile());
		} 
		return ok();
	}
	
	public Result downloadMilConversionSample(String type) throws IOException {
		MILSampleInfo milSampleInfo = new MILSampleInfo();
		if (type.equals("properties")) {
			return ok(milSampleInfo.getSampleConfigPropertiesFile());
		} else if (type.equals("xml")) {
			return ok(milSampleInfo.getSampleInputXMLFile());
		}
		return ok();
	}

}
