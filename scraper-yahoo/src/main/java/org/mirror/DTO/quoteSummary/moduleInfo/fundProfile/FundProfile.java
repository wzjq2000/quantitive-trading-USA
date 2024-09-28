package org.mirror.DTO.quoteSummary.moduleInfo.fundProfile;

import lombok.Data;
import org.mirror.DTO.quoteSummary.moduleInfo.ModuleInfo;

import java.util.List;

@Data
public class FundProfile extends ModuleInfo {

        private Integer maxAge;
        private String styleBoxUrl;
        private String family;
        private String categoryName;
        private String legalType;
        private ManagementInfo managementInfo;
        private FeesExpensesInvestment feesExpensesInvestment;
        private FeesExpensesInvestment feesExpensesInvestmentCat;

        // TODO: what is the type of brokerage?
        private List<Object> brokerages;

}
