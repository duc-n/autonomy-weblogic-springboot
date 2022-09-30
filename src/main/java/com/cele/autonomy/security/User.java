package com.cele.autonomy.security;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import lombok.Data;

@Component
@Data
public class User implements UserDetails {
  private static final long serialVersionUID = 1L;

  private String username;
  private String currentLanguage;
  private String title;
  private String email;
  private String firstName;
  private String lastName;
  private String subscriberId;
  private Set<String> managedEmployees;
  private List<String> workUnit = new ArrayList<>();
  // defect #424 : Visibility Rights adjustable per Entity - Country - Sector Co
  private Set<String> visibilityEntities = new HashSet<>();

  private Set<String> visibilityCountries = new HashSet<>();

  private Set<String> visibilityCommercialSectors = new HashSet<>();

  private Set<String> validationCountries = new HashSet<>(); // The countries in which user can validate derogations.

  private Integer derogationLevel;

  private Set<String> backOfficeEntities = new HashSet<>();

  private Boolean visibility = null;
  private Boolean backOffice = null;

  private Boolean adminUpload = null;
  private Boolean contractEdition = null;
  private Boolean supervision = null;
  private Boolean fullVisibility = null;
  private Boolean validation = null;
  private Boolean technicalAdministrator = null;
  // defect #616 : FR feedback: Create a specific right to generate documents in Word format
  private Boolean generateWordDocument = null;
  // Alm-1390: BR1:NAR - Agent_License control, - New Right in order to allow case Creation
  private Boolean rightCreateFile = null;

  private Boolean rightReferenceCaseManager = null;

  // defect 1491 : Add a new quotation right name AUTONOMY_QUOTE. This right allows user to realize quotation action.
  private Boolean rightQuotation = null;
  private boolean pepsAuthorized = false;
  private String pepsRole;
  private String isoCountryCode;

  /* Spring Security related fields */
  private String password;
  private List<Role> authorities = new ArrayList<>();
  private boolean accountNonExpired = true;
  private boolean accountNonLocked = true;
  private boolean credentialsNonExpired = true;
  private boolean enabled = true;

  private Boolean currentRateInPercent;

  private String currentRateLabel;


  private Boolean currentDateFormatIsStd;

  private String currentDateFormatLabel;


  private Boolean countryAreaMoveRight = null;

  // Defect #836: CofaLink - Control while generating the NBI
  private Long currentCaseId;

  // ALm-1390: adding licence services
  private String currentPartnerBrokerRoleReferenceId;
  private String currentPartnerBringingRoleReferenceId;


  // ALM - 1643
  private Boolean rightNegotiation = null;

  private Boolean rightManualQuotation = null;

  // ALM - 1851
  private Boolean rightChangeCurrency = null;

  private Boolean rightReadOnly = null;

  // CMAUT-498
  private Boolean rightTransformDerogationValidation = null;

  private boolean autonomyPlus;

  // CMAUT-1042
  private boolean unknowCountryInAdminTool;

  private boolean rightProgram;

  private boolean countrySetting;



}
