package org.sitenv.common.utilities.enums;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

public enum CcdaType {
	ClinicalOfficeVisitSummary ("Clinical Office Visit Summary - 170.314(e)(2) - Clinical Summary"),
	TransitionsOfCareAmbulatorySummaryb2 ("Transitions Of Care Ambulatory Summary - 170.314(b)(2) Transition of Care/Referral Summary - For Ambulatory Care"),
	TransitionsOfCareAmbulatorySummaryb7 ("Transitions Of Care Ambulatory Summary - 170.314(b)(7) Data Portability - For Ambulatory Care"),
	TransitionsOfCareAmbulatorySummaryb1 ("Transitions Of Care Ambulatory Summary - 170.314(b)(1) Transition of Care Receive - For Ambulatory Care"),
	TransitionsOfCareInpatientSummaryb2 ("Transitions Of Care Inpatient Summary - 170.314(b)(2) Transition of Care/Referral Summary - For Inpatient Care"),
	TransitionsOfCareInpatientSummaryb7 ("Transitions Of Care Inpatient Summary - 170.314(b)(7) Data Portability - For Inpatient Care"),
	TransitionsOfCareInpatientSummaryb1 ("Transitions Of Care Inpatient Summary - 170.314(b)(1) Transition of Care Receive - For Inpatient Care"),
	VDTAmbulatorySummary ("VDT Ambulatory Summary - 170.314 (e)(1) Ambulatory Summary"),
	VDTInpatientSummary ("VDT Inpatient Summary - 170.314 (e)(1) Inpatient Summary"),
	NonSpecificCCDA ("C-CDA R1.1 IG conformance");
	
	private static final Map<String,CcdaType> lookup = new HashMap<String,CcdaType>();

	static {
		createReverseLookupMap();
	}

	private static void createReverseLookupMap() {
		for(CcdaType s : EnumSet.allOf(CcdaType.class))
			lookup.put(s.getCcdaType(), s);
	}
	
	private final String ccdaType;

	CcdaType(final String ccdaType) {
		this.ccdaType = ccdaType;
	}
	
	public String getCcdaType() {
		return ccdaType;
	}
	
	public static CcdaType get(String ccdaType) { 
        return lookup.get(ccdaType); 
   }

}
