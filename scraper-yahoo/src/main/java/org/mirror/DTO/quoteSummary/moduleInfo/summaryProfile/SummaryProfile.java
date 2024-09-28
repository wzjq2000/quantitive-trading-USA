package org.mirror.DTO.quoteSummary.moduleInfo.summaryProfile;

import lombok.Data;
import org.mirror.DTO.quoteSummary.moduleInfo.ModuleInfo;
import org.mirror.DTO.quoteSummary.moduleInfo.assetProfile.CompanyOfficer;

import java.util.List;

@Data
public class SummaryProfile extends ModuleInfo {
    private String address1;
    private String city;
    private String state;
    private String zip;
    private String country;
    private String phone;
    private String website;
    private String industry;
    private String industryKey;
    private String industryDisp;
    private String sector;
    private String sectorKey;
    private String sectorDisp;
    private String longBusinessSummary;
    private Integer fullTimeEmployees;
    private List<CompanyOfficer> companyOfficers;
    private String irWebsite;
    private Integer maxAge;
}


