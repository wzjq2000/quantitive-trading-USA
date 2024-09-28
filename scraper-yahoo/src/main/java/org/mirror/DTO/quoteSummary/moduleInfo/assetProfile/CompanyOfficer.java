package org.mirror.DTO.quoteSummary.moduleInfo.assetProfile;

import lombok.Data;
import org.mirror.DTO.quoteSummary.moduleInfo._common.FormattedData;

@Data
public class CompanyOfficer {
    private Integer maxAge;
    private String name;
    private Integer age;
    private String title;
    private Integer yearBorn;
    private Integer fiscalYear;

    private FormattedData totalPay;
    private FormattedData exercisedValue;
    private FormattedData unexercisedValue;

}
