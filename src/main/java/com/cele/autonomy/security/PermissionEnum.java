package com.cele.autonomy.security;


public enum PermissionEnum {
  /* CASE */
  CASE_OWNER_PERMISSION, CASE_PERMISSION, CASE_VALIDATION_PERMISSION, CASE_FINALIZATION_PERMISSION, CASES_PERMISSION, CASE_NOT_CHECK_MIGRATION_AND_CLO_PERMISSION, PAGE_CASE_SCENARIO_PERMISSION, PAGE_CASE_PERMISSION, CASE_CHECK_CONTRACT_STATUS_NOT_SIGNED_HUB,

  /* SCENARIO */
  SCENARIO_OWNER_PERMISSION, SCENARIO_PERMISSION, SCENARIO_VALIDATION_PERMISSION, SCENARIO_FINALIZATION_PERMISSION, SCENARIO_TRANSFER_GCC_PERMISSION, SCENARIO_NOT_INACTIVE_PERMISSION, SCENARIO_SAVE_IN_CUBE_PERMISSION, SCENARIO_NOT_CHECK_MIGRATION_AND_CLO_PERMISSION, SCENARIO_NOT_RENEWAL_PERMISSION,


  /* QUESTIONNAIRE */
  QUESTIONNAIRE_PERMISSION,

  /* BUYERSTUDY */
  BUYERSTUDY_PERMISSION,

  /* POLICY */
  POLICY_PERMISSION, POLICY_NOT_CHECK_MIGRATION_AND_CLO_PERMISSION, POLICY_NOT_INACTIVE_PERMISSION,


  /* PROPOSAL */
  PROPOSAL_PERMISSION, PROPOSAL_VALIDATION_PERMISSION, PROPOSAL_NOT_CHECK_MIGRATION_AND_CLO_PERMISSION, PROPOSAL_NOT_INACTIVE_PERMISSION, SCENARIO_CHECK_PROJECT_NOT_TRANSFORMATION, SCENARIO_CHECK_NEW_CLO_ENDORSEMENT,

  /* QUOTE */
  QUOTE_PERMISSION,


  /* OTHERS */
  CREATE_CONTRACT, CREATE_NBI, ENABLE_DISPLAY_CLAUSE;

}
