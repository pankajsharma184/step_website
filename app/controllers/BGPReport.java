package controllers;

import java.io.File;

import com.codifyd.automation.bgp.BGPReportInputUtil;
import com.codifyd.automation.bgp.ReportGenerator;

public class BGPReport {
	
	public String generateReport(String inputServerPath, String username, String password, String contextID, String inputFile){
		BGPReportInputUtil userinput = new BGPReportInputUtil();
		userinput.setInputServerPath(inputServerPath);
		userinput.setUsername(username);
		userinput.setPassword(password);
		userinput.setContextID(contextID);
		userinput.setInputFile(new File(inputFile));
		System.out.println(userinput.getInputFile().getAbsolutePath());

		try {			
			ReportGenerator.generateReport(userinput);
		} catch (Exception e) {
			return("Error occured while converting file : "+e.getMessage());
		}
		return "File generated in the input parent folder with timestamp";
	}
	
}
