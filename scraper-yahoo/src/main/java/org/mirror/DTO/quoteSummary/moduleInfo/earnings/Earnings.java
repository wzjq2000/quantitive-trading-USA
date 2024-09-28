package org.mirror.DTO.quoteSummary.moduleInfo.earnings;


import lombok.Data;
import org.mirror.DTO.quoteSummary.moduleInfo.ModuleInfo;

@Data
public class Earnings extends ModuleInfo {

    private Integer maxAge;
    private EarningsChart earningsChart;
    private FinancialsChart financialsChart;
    private String financialCurrency;
}
