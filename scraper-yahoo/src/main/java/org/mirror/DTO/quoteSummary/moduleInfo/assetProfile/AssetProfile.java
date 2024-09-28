package org.mirror.DTO.quoteSummary.moduleInfo.assetProfile;

import lombok.Data;
import org.mirror.DTO.quoteSummary.moduleInfo.ModuleInfo;

import java.util.List;

@Data
public class AssetProfile extends ModuleInfo {
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
    private Integer auditRisk;
    private Integer boardRisk;
    private Integer compensationRisk;
    private Integer shareHolderRightsRisk;
    private Integer overallRisk;
    private Long governanceEpochDate;
    private Long compensationAsOfEpochDate;
    private String irWebsite;
    private Integer maxAge;
}
