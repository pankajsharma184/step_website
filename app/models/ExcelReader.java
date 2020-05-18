package models;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;


import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class ExcelReader {
	public Document readExcelContent(Element attrsList, Document doc, Document prodAttrLinksDoc,  Element prodAttrEle, Map<String, String> pCatIDsMap,File inputFile) {
		try {
			
			Map<String,String> attrIDs = new HashMap<>();
			File attrIDsFile = new File("C:\\Users\\chann\\Downloads\\AttrsIDs.txt");
			FileReader fr;
			try {
				fr = new FileReader(attrIDsFile);
				BufferedReader br = new BufferedReader(fr);
				String eachLine = br.readLine();
				while(eachLine != null) {
					String[] attrs = eachLine.split("=");
					attrIDs.put(attrs[0], attrs[1]);
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
			
			FileInputStream file = new FileInputStream(inputFile);
			 
            XSSFWorkbook workbook = new XSSFWorkbook(file);
 
            XSSFSheet sheet = workbook.getSheetAt(0);
 
            Iterator<Row> rowIterator = sheet.iterator();
            
            //Map to store attributes along with Tags to be added for Attributes
            Map<String,List<String>> tagAttributesMap = new HashMap<String,List<String>>();
            
            //Lists 
            List<String> attrTagList = new ArrayList<>();
            attrTagList.add("ID");
            attrTagList.add("ExternallyMaintained");
            attrTagList.add("Mandatory");
            attrTagList.add("MultiValued");
            attrTagList.add("Derived");
            
            List<String> validationTagList = new ArrayList<>();
            validationTagList.add("BaseType");
            validationTagList.add("InputMask");
            validationTagList.add("MaxLength");
            validationTagList.add("MaxValue");
            validationTagList.add("MinValue");
            
            //Populate map
            tagAttributesMap.put("Attribute", attrTagList);
            //tagAttributesMap.put("Name", new ArrayList<>());
            tagAttributesMap.put("Validation", validationTagList);
            //tagAttributesMap.put("MetaData", new ArrayList<>());
            //tagAttributesMap.put("AttributeGroupLink", new ArrayList<>());
            //tagAttributesMap.put("UserTypeLink", new ArrayList<>());
            
            
            //Uncomment - to import attribute definitions with 4 columns in excel file.
           int rowNum = 1;
            while (rowIterator.hasNext() ) 
            {
                Row row = rowIterator.next();
                Element attributeEle = null;
                Element validTag = null;
                
                //Meatadata tag
                Element metadataTag = doc.createElement("Metadata");
                if(rowNum > 1) {
                	Iterator<Cell> cellIterator = row.cellIterator();
                    int i=1;
                    boolean ignoreValidation = false;
                    boolean isNumber = false;
                   while (cellIterator.hasNext()) 
                   {
                       Cell cell = cellIterator.next();
                       String cellValue = "";
                       switch (cell.getCellType()) 
                       {
                          
                           case Cell.CELL_TYPE_STRING:
                           	cellValue = cell.getStringCellValue();
                               break;
                           case Cell.CELL_TYPE_BOOLEAN:
                           	cellValue  = cellValue+"" +cell.getBooleanCellValue();
                               break;
                       }
                       
                       //Check if the header is an attribute or node
                       Cell headerCell = workbook.getSheetAt(0).getRow(0).getCell(cell.getColumnIndex());
                       String tagName = null;
                       boolean createTag = false;
                       
                       for(String mapKey : tagAttributesMap.keySet()) {
                    	   List<String> tagAttriutes = tagAttributesMap.get(mapKey);
                    	 
                    	   if(tagAttriutes != null) {
                        	   //Add attributes to the tags
                        	   if(tagAttriutes.contains(headerCell.getStringCellValue())) {
                        		   //Get the Element if Exists
                        		   tagName = mapKey;
                        		   createTag = true;
                        		   break;
                        		   
                        	   }else {
                        		   createTag = false;
                        	   }
                        	   
                           }
                       }
                        
                       if(tagName != null && createTag) {
                    	   //Add attributes to the tags
                    	   if(headerCell.getStringCellValue().equals("BaseType") && cellValue.equals("LOV") && attributeEle != null) {
                    		   Element lovLink = doc.createElement("ListOfValueLink");
                    		   lovLink.setAttribute("ListOfValueID", "LOV-id");
                    		   ignoreValidation = true;
                    		   attributeEle.appendChild(lovLink);
                    		   
                    	   }else if(tagName.equals("Attribute") && attributeEle != null) {
                    		   attributeEle.setAttribute(headerCell.getStringCellValue(), cellValue);
                    	   }else if(tagName.equals("Attribute")){
                    		   attributeEle = doc.createElement("Attribute");
                    		   attributeEle.setAttribute(headerCell.getStringCellValue(), cellValue);
                    	   }else if(tagName.equals("Validation") && validTag != null && !ignoreValidation) {
                    		   validTag.setAttribute(headerCell.getStringCellValue(), cellValue);
                    	   }else if(tagName.equals("Validation") && !ignoreValidation){
                    		    if(cellValue.equals("Number")) {
                    		    	isNumber = true;
                    		    }
                			   validTag = doc.createElement("Validation");
                    		   validTag.setAttribute(headerCell.getStringCellValue(), cellValue);
                		   
                    		   
                    	   }
                    	   
                       }else {
                    	   if(headerCell.getStringCellValue().equals("Name")) {
                    		   //System.out.println("Header Cell: "+headerCell.getStringCellValue() +" and cell value is: "+cell.getStringCellValue());
                    		   String id = attrIDs.get(cell.getStringCellValue());
                    		   Element nameEle = doc.createElement("Name");
                    		   nameEle.setTextContent(cell.getStringCellValue());
                    		   if(attributeEle != null) {
                    			   attributeEle.appendChild(nameEle);
                    		   }else {
                    			   attributeEle = doc.createElement("Attribute");
                    			   attributeEle.appendChild(nameEle);
                    		   }
                    		   
                    		   if(id != null) {
                    			   attributeEle.setAttribute("ID", id);
                    		   }
                    	   }else if(headerCell.getStringCellValue().equals("UserTypeID")){
                    		   Element userType = doc.createElement("UserTypeLink");
                    		   if(cell.getStringCellValue().equals("SKU")) {
                    			   userType.setAttribute(headerCell.getStringCellValue(), "SKU");
                    		   }else {
                    			   userType.setAttribute(headerCell.getStringCellValue(), "Product_Family");
                    		   }
                    		   
                    		   attributeEle.appendChild(userType);
                    		   
                    		   //Decide the attribute Group
                    		   if(cell.getStringCellValue().equals("SKU")) {
                    			   Element grpLinkEle = doc.createElement("AttributeGroupLink");
                    			   grpLinkEle.setAttribute("AttributeGroupID", "SKU_Enrichment_Attributes");
                    			   attributeEle.appendChild(grpLinkEle);
                    		   }else if(cell.getStringCellValue().equals("Family")) {
                    			   Element grpLinkEle = doc.createElement("AttributeGroupLink");
                    			   grpLinkEle.setAttribute("AttributeGroupID", "Ecomm_Attributes");
                    			   attributeEle.appendChild(grpLinkEle);
                    		   }
                    	   }else if(headerCell.getStringCellValue().equals("Display_Name") || headerCell.getStringCellValue().equals("DisplaySequence")) {
                    		   Element metaValTag = doc.createElement("Value");
                    		   metaValTag.setAttribute("AttributeID",headerCell.getStringCellValue());
                    		   if(headerCell.getStringCellValue().equals("DisplaySequence")) {
                    			   metaValTag.setTextContent(""+(int)cell.getNumericCellValue());
                    		   }else {
                    			   metaValTag.setTextContent(cell.getStringCellValue());
                    		   }
                    		   
                    		   metadataTag.appendChild(metaValTag);
                    	   }
                    	   else if(headerCell.getStringCellValue().equals("Display_Name") || headerCell.getStringCellValue().equals("DisplaySequence")) {
                    		   Element metaValTag = doc.createElement("Value");
                    		   metaValTag.setAttribute("AttributeID",headerCell.getStringCellValue());
                    		   if(headerCell.getStringCellValue().equals("DisplaySequence")) {
                    			   metaValTag.setTextContent(""+(int)cell.getNumericCellValue());
                    		   }else {
                    			   metaValTag.setTextContent(cell.getStringCellValue());
                    		   }
                    		   
                    		   metadataTag.appendChild(metaValTag);
                    	   }else if(headerCell.getStringCellValue().equals("limit") && cellValue.equals("whole number") && isNumber) {
                    		   validTag.setAttribute("BaseType", "Integer");
                    	   }
                       }
                       if(cell.getColumnIndex() >= 15) {
                    	   String s = workbook.getSheetAt(0).getRow(0).getCell(cell.getColumnIndex()).getStringCellValue();
                    	   //System.out.println("Index is : " +cell.getColumnIndex()+" and the header is "+s);
                    	   
                    	   productAtterLinksCreator(prodAttrLinksDoc,workbook.getSheetAt(0).getRow(0),prodAttrEle,cell,cell.getColumnIndex(),pCatIDsMap,attrIDs);
                       }
                                                                     
                       i = i+1;
                       
                   }
            
           
            //productAtterLinksCreator(prodAttrLinksDoc,sheet,prodAttrEle);
//                   Element attrEle = doc.createElement("Attribute");
//                   attrEle.setAttribute("ID", cell1);
//                   attrEle.setAttribute("MultiValued", cell3);
//                   attrEle.setAttribute("ExternallyMaintained", "true");
//                   attrEle.setAttribute("Derived","false");
//                   attrEle.setAttribute("Mandatory", "false");
//                   
//                   attrsList.appendChild(attrEle);
//                   
//                   Element nameEle = doc.createElement("Name");
//                   nameEle.setTextContent(cell2);
//                   attrEle.appendChild(nameEle);
//                   
//                   Element validationEle = doc.createElement("Validation");
//                   validationEle.setAttribute("BaseType", cell4);
//                   validationEle.setAttribute("MinValue", "");
//                   validationEle.setAttribute("MaxValue", "");
//                   validationEle.setAttribute("MaxLength","");
//                   validationEle.setAttribute("InputMask", "");
//                   attrEle.appendChild(validationEle);
//                   
//                   Element metadataEle = doc.createElement("MetaData");
//                   attrEle.appendChild(metadataEle);
//                   Element groupEle = doc.createElement("AttributeGroupLink");
//                   groupEle.setAttribute("AttributeGroupID", "TEST");
//                   attrEle.appendChild(groupEle);
//                   
//                   Element typeLinkEle = doc.createElement("UserTypeLink");
//                   typeLinkEle.setAttribute("UserTypeID", "SKU");
//                   attrEle.appendChild(typeLinkEle);
                   if(validTag != null){
                	   attributeEle.appendChild(validTag);
                   }
                   
                   attributeEle.appendChild(metadataTag);
                   
                   //Add few attribute to attribute tag
                   attributeEle.setAttribute("ProductMode", "Normal");
                   attributeEle.setAttribute("ExternallyMaintained", "false");
                   attributeEle.setAttribute("Mandatory", "false");
                   attrsList.appendChild(attributeEle);
                }
                rowNum = rowNum + 1;
              
            }
            file.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
		return doc;
	}
	
	public Document productAtterLinksCreator(Document prodAttrLinksDoc, Row row, Element proAttrLinkEle, Cell currentCell, int cellIndex, Map<String, String> pCatIDsMap, Map<String, String> attrIDs) {
//		Iterator<Row> rowIterator = sheet.iterator();
//        
//		while (rowIterator.hasNext() ) 
//        {
                                    
            Cell headCell = row.getCell(cellIndex);
            String headCellValue = headCell.getStringCellValue();
            
            String catID = pCatIDsMap.get(headCellValue);
            
            //Check whether link exists
            String currentCellval = currentCell.getStringCellValue();
            String attrID = null;
            if(currentCellval.equals("FO") || currentCellval.equals("FR") || currentCellval.equals("SO") || currentCellval.equals("SR")) {
            	attrID = attrIDs.get(currentCell.getRow().getCell(0).getStringCellValue());
            }
            Element prodEle = null;
            if(catID != null) {
            	//Get the Product ele with this ID
            	NodeList elems = prodAttrLinksDoc.getElementsByTagName("Product");
            	for(int i=0;i<elems.getLength();i++) {
            		Node eachProdItem = elems.item(i);
            		NamedNodeMap attrMap = eachProdItem.getAttributes();
            		String pCatID = attrMap.getNamedItem("ID").getNodeValue();
            		if(pCatID.equals(catID)) {
            			prodEle = (Element) eachProdItem;
            		}
            		
            	}
            	
            	
            	if(prodEle != null) {
            		if(attrID != null) {
            			Element attrLink = prodAttrLinksDoc.createElement("AttributeLink"); 
                      	attrLink.setAttribute("AttributeID", attrID);
                      	prodEle.appendChild(attrLink);
            		}
            		
            	}else {
            		Element productEle = prodAttrLinksDoc.createElement("Product");
                    productEle.setAttribute("ID", catID);
                    proAttrLinkEle.appendChild(productEle);
                    if(attrID != null) {
                    	Element attrLink = prodAttrLinksDoc.createElement("AttributeLink");
                      	attrLink.setAttribute("AttributeID", attrID);
                      	productEle.appendChild(attrLink);
                    }
            	}
            }

		return prodAttrLinksDoc;
	}
}

