package com.cele.autonomy.security;


public enum RoleEnum {
  //@formatter:off
	//defect #424 : Visibility Rights adjustable per Entity - Country - Sector Co
	AUTONOMY_VISIBILITY,//no restriction = AUTONOMY_VISIBILITY_ALL
	AUTONOMY_VALIDATION, //no restriction
	AUTONOMY_VISIBILITY_ALL,//no restriction
	//defect #424 : Visibility Rights adjustable per Entity - Country - Sector Co
	AUTONOMY_SUPERVISION,
	AUTONOMY_BACKOFFICE,
	AUTONOMY_ADMIN_UPLOAD,
	AUTONOMY_CONTRACT_EDITION,
	AUTONOMY_TECHNICAL_ADMINISTRATOR,
	AUTONOMY_WORD_DOCUMENT,
	AUTONOMY_COUNTRY_MOVES,
	//Alm-1390: BR1:NAR - Agent_License control, - New Right in order to allow case Creation
	AUTONOMY_CREATION,
	AUTONOMY_QUOTATION,	
	// #defect 1643 : right to negotiate in autonomy
	AUTONOMY_NEGOTIATION,
	// #defect 1643 : right to change currency in autonomy
	AUTONOMY_CHANGE_CURRENCY,
	
	//CMAUT-337
	AUTONOMY_READ_ONLY,
	//CMAUT-498 allow to validate all derogation
	AUTONOMY_TRANSFORM_VALIDATION,
	
	AUTONOMY_MANUAL_QUOTATION,
	
	AUTONOMY_REFERENCE_MANAGER,
	
	AUTONOMY_PROGRAM,
	
    AUTONOMY_COUNTRY_SETTING
  ;
  
//@formatter:on
}
