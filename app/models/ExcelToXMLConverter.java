package models;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import play.mvc.Http;
import play.mvc.Result;

public class ExcelToXMLConverter {

	public String opt;
	
	public String generateXML(File inputFile) {
    	//Properties file
    			Map<String,String> pCatIDsMap = new HashMap<>();
    			File propFile = new File("C:\\Users\\chann\\Downloads\\PCat_IDs.txt");
    			FileReader fr;
    			try {
    				fr = new FileReader(propFile);
    				BufferedReader br = new BufferedReader(fr);
    				String eachLine = br.readLine();
    				while(eachLine != null) {
    					String[] cats = eachLine.split("=");
    					pCatIDsMap.put(cats[0], cats[1]);
    					eachLine = br.readLine();
    				}
    				br.close();
    				fr.close();
    			} catch (FileNotFoundException e) {
    				// TODO Auto-generated catch block
    				e.printStackTrace();
    			} catch (IOException e) {
    				// TODO Auto-generated catch block
    				e.printStackTrace();
    			}
    			
    			
    			
    			XMLWriter xmlWriter = new XMLWriter();
    			Element attrsList = xmlWriter.attributesDoc();
    			Element prodAttrLinkDoc = xmlWriter.productsAttrLinkDoc();
    			ExcelReader excelReader = new ExcelReader();
    			Document attrsDoc = excelReader.readExcelContent(attrsList,xmlWriter.attrDoc,xmlWriter.prodAttrDoc,prodAttrLinkDoc,pCatIDsMap,inputFile);
    			String resp = "";
    			resp = resp+ xmlWriter.transformToResultFile(xmlWriter.prodAttrDoc,"C:\\Users\\chann\\Downloads\\productAttrLinks.xml");
    			resp = resp+ xmlWriter.transformToResultFile(xmlWriter.attrDoc,"C:\\Users\\chann\\Downloads\\attributes.xml");
				return resp;
				
    }
}
