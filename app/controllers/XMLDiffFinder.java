package controllers;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import models.*;

public class XMLDiffFinder {
	
	public String sourceFilePath;
	public String targetFilePath;
	
	
	public XMLDiffFinder() {
		super();
	}


	public XMLDiffFinder(String sourceFilePath, String targetFilePath) {
		super();
		this.sourceFilePath = sourceFilePath;
		this.targetFilePath = targetFilePath;
	}
	
	public String findDifference(String srcFilePath, String tFilePath) {
		
		try {
			InputStream sourceInputStream = new FileInputStream( srcFilePath );
			InputStream targetInputStream = new FileInputStream( tFilePath );
			JAXBContext jaxbContext     = JAXBContext.newInstance( STEPProductInformation.class );
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			
			STEPProductInformation sourceObj = (STEPProductInformation) jaxbUnmarshaller.unmarshal( sourceInputStream );
			STEPProductInformation targetObj = (STEPProductInformation) jaxbUnmarshaller.unmarshal( targetInputStream );
			List<String> differences = new ArrayList<>();
			differences = findDifference(sourceObj,targetObj,differences);
			
			String reportFPath = new File(tFilePath).getParent()+"\\Diff_Report.txt";
			Path out = Paths.get(reportFPath);
			Files.write(out,differences,Charset.defaultCharset());
			
			return "Difference Report TXT file is placed at : "+reportFPath;
		} catch (JAXBException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return e.getMessage();
		}
	}
	
	private static List<String> findDifference(STEPProductInformation sourceObj, STEPProductInformation targetObj, List<String> diff) {
		//List attributes from source xml & target xml
		List<STEPProductInformation.AttributeList.Attribute> sourceAttrList = sourceObj.getAttributeList().attribute;
		List<STEPProductInformation.AttributeList.Attribute> targetAttrList = targetObj.getAttributeList().attribute;
		
		//IDs set - which haven't compared
		List<String> sourceAttrIDs = new ArrayList<String>();
		List<String> targetAttrIDs = new ArrayList<String>();
		
		for(STEPProductInformation.AttributeList.Attribute eachTarAttr : targetAttrList) {
			targetAttrIDs.add(eachTarAttr.getID());
		}
		
		for(STEPProductInformation.AttributeList.Attribute eachsrcAttr : sourceAttrList) {
			//Check if attr exists in target file?
			boolean isCompared = false;
			for(STEPProductInformation.AttributeList.Attribute eachTarAttr : targetAttrList) {
				if(eachsrcAttr.getID().equals(eachTarAttr.getID())) {
					targetAttrIDs.remove(eachTarAttr.getID());
					isCompared = true;
					
					
					if(!eachsrcAttr.getMandatory().toString().equals(eachTarAttr.getMandatory().toString())) {
						diff = catchDifference(diff,"Mandatory is changed to "+eachTarAttr.getMandatory());
					}
					if(!eachsrcAttr.getMultiValued().toString().equals(eachTarAttr.getMultiValued().toString())) {
						diff = catchDifference(diff,"Multivalued is changed to "+eachTarAttr.getMultiValued());
					}
					if(!eachsrcAttr.getReferenced().toString().equals(eachTarAttr.getReferenced().toString())) {
						diff = catchDifference(diff,"Referenced is changed to "+eachTarAttr.getReferenced());
					}
					if(!eachsrcAttr.getDerived().toString().equals(eachTarAttr.getDerived().toString())) {
						diff = catchDifference(diff,"Derived is changed to "+eachTarAttr.getDerived());
					}
					if(!eachsrcAttr.getExternallyMaintained().toString().equals(eachTarAttr.getExternallyMaintained().toString())) {
						diff = catchDifference(diff,"ExternallyMaintained is changed to "+eachTarAttr.getExternallyMaintained());
					}
					if(!eachsrcAttr.getFullTextIndexed().toString().equals(eachTarAttr.getFullTextIndexed().toString())) {
						diff = catchDifference(diff,"FullTextIndexed is changed to "+eachTarAttr.getFullTextIndexed());
					}
					if(!eachsrcAttr.getProductMode().toString().equals(eachTarAttr.getProductMode().toString())) {
						diff = catchDifference(diff,"ProductMode is changed to "+eachTarAttr.getProductMode());
					}
					
					if(!eachsrcAttr.getName().toString().equals(eachTarAttr.getName().toString())) {
						diff = catchDifference(diff,"Name is changed to "+eachTarAttr.getName());
					}
					
					diff = compareValidation(eachsrcAttr,eachTarAttr,diff);
					diff = compareAttributeGroupLink(eachsrcAttr,eachTarAttr,diff);
					diff = compareUserTypeLink(eachsrcAttr,eachTarAttr,diff);
//					if(!eachsrcAttr.getUserTypeLink().getUserTypeID().toString().equals(eachTarAttr.getUserTypeLink().getUserTypeID().toString())) {
//						diff = catchDifference(diff,"UserTypeLink is changed to "+eachTarAttr.getUserTypeLink().getUserTypeID());
//					}
					
				}
			}
			if(!isCompared) {
				sourceAttrIDs.add(eachsrcAttr.getID());
			}
		}
		for(String srcAttrID : sourceAttrIDs) {
			diff = catchDifference(diff,"Attribute ID : "+ srcAttrID+ " is not present in target File");
		}
		for(String targetAttrID : targetAttrIDs) {
			diff = catchDifference(diff,"Attribute ID : "+ targetAttrID+ " is not present in source File");
		}
		
		return diff;
	}

	private static List<String> compareUserTypeLink(STEPProductInformation.AttributeList.Attribute eachsrcAttr, STEPProductInformation.AttributeList.Attribute eachTarAttr, List<String> diff) {
		List<STEPProductInformation.AttributeList.Attribute.UserTypeLink> srcUserTypeLinks = eachsrcAttr.getUserTypeLink();
		List<STEPProductInformation.AttributeList.Attribute.UserTypeLink> tarUserTypeLinks = eachTarAttr.getUserTypeLink();
		
//		for(STEPProductInformation.AttributeList.Attribute.UserTypeLink srcUserTypeLink : srcUserTypeLinks) {
//			
//			//Does Attr-Grp Link exists in target
//			boolean linkExists = false;
//			for(STEPProductInformation.AttributeList.Attribute.UserTypeLink tarUserTypeLink : tarUserTypeLinks) {
//				if(srcUserTypeLink.getUserTypeID().toString().equals(tarUserTypeLink.getUserTypeID().toString())) {
//					linkExists = true;
//				}
//			}
//			if(!linkExists) {
//				diff = catchDifference(diff,"UserTypeLink : UserTypeID "+srcUserTypeLink.getUserTypeID()+" has been removed");
//			}
//		}
		

        List<String> sourceIds = new ArrayList<String>();
        List<String> targetIds = new ArrayList<String>();
        for (STEPProductInformation.AttributeList.Attribute.UserTypeLink userTypeLink : srcUserTypeLinks) {
            sourceIds.add(userTypeLink.getUserTypeID());
        }
        for (STEPProductInformation.AttributeList.Attribute.UserTypeLink userTypeLink : tarUserTypeLinks) {
            targetIds.add(userTypeLink.getUserTypeID());
        }
        ArrayList<String> commons = new ArrayList<>();
        for (String s2 : targetIds) {
            for (String s1 : sourceIds) {
                if (s2.contains(s1)) {
                    commons.add(s2);
                }
            }
        }
        sourceIds.removeAll(commons);
        targetIds.removeAll(commons);
        
        diff = catchDifference(diff,"Attribute ID:"+eachsrcAttr.getID()+" --Removed UserType Links: "+sourceIds+ " -- Added UserType Links: "+targetIds);
        return diff;
		
	}

	private static List<String> compareAttributeGroupLink(STEPProductInformation.AttributeList.Attribute eachsrcAttr, STEPProductInformation.AttributeList.Attribute eachTarAttr, List<String> diff) {
		List<STEPProductInformation.AttributeList.Attribute.AttributeGroupLink> srcAttrGrpLinks = eachsrcAttr.getAttributeGroupLink();
		List<STEPProductInformation.AttributeList.Attribute.AttributeGroupLink> targetAttrGrpLinks = eachTarAttr.getAttributeGroupLink();
		
//		for(STEPProductInformation.AttributeList.Attribute.AttributeGroupLink srcAttrGrpLink : srcAttrGrpLinks) {
//			
//			//Does Attr-Grp Link exists in target
//			boolean linkExists = false;
//			for(STEPProductInformation.AttributeList.Attribute.AttributeGroupLink tarAttrGrpLink : targetAttrGrpLinks) {
//				if(srcAttrGrpLink.getAttributeGroupID().toString().equals(tarAttrGrpLink.getAttributeGroupID().toString())) {
//					linkExists = true;
//				}
//			}
//			if(!linkExists) {
//				diff = catchDifference(diff,"AttributeGroupLink : AttributeGroupID has been removed");
//			}
//		}
		
		List<String> sourceIds = new ArrayList<String>();
        List<String> targetIds = new ArrayList<String>();
        for (STEPProductInformation.AttributeList.Attribute.AttributeGroupLink srAttrLink : srcAttrGrpLinks) {
            sourceIds.add(srAttrLink.getAttributeGroupID());
        }
        for (STEPProductInformation.AttributeList.Attribute.AttributeGroupLink tarAttrLink : targetAttrGrpLinks) {
            targetIds.add(tarAttrLink.getAttributeGroupID());
        }
        ArrayList<String> commons = new ArrayList<>();
        for (String s2 : targetIds) {
            for (String s1 : sourceIds) {
                if (s2.contains(s1)) {
                    commons.add(s2);
                }
            }
        }
        sourceIds.removeAll(commons);
        targetIds.removeAll(commons);
        diff = catchDifference(diff,"Attribute ID:"+eachsrcAttr.getID()+" --Removed Attr Group Links: "+sourceIds+ " -- Added Attr Group Links: "+targetIds);
        
		return diff;
	}

	private static List<String> compareValidation(STEPProductInformation.AttributeList.Attribute eachsrcAttr, STEPProductInformation.AttributeList.Attribute eachTarAttr, List<String> diff) {
		STEPProductInformation.AttributeList.Attribute.Validation srcValidation = eachsrcAttr.getValidation();
		STEPProductInformation.AttributeList.Attribute.Validation targetValidation = eachTarAttr.getValidation();
		
		if(!srcValidation.getBaseType().toString().equals(targetValidation.getBaseType().toString())) {
			diff = catchDifference(diff," Validation : BaseType is changed to "+targetValidation.getBaseType());
		}
		if(!srcValidation.getInputMask().toString().equals(targetValidation.getInputMask().toString())) {
			diff = catchDifference(diff," Validation : InputMask is changed to "+targetValidation.getBaseType());
		}
		if(!srcValidation.getMaxLength().toString().equals(targetValidation.getMaxLength().toString())) {
			diff = catchDifference(diff," Validation : MaxLength is changed to "+targetValidation.getMaxLength());
		}
		if(!srcValidation.getMaxValue().toString().equals(targetValidation.getMaxValue().toString())) {
			diff = catchDifference(diff," Validation : MaxValue is changed to "+targetValidation.getMaxValue());
		}
		if(!srcValidation.getMinValue().toString().equals(targetValidation.getMinValue().toString())) {
			diff = catchDifference(diff," Validation : MinValue is changed to "+targetValidation.getMinValue());
		}
		
		return diff;
	}
	
	private static List<String> catchDifference(List<String> differences, String foundDiff) {
		differences.add(foundDiff);
		return differences;
	}

	
}
