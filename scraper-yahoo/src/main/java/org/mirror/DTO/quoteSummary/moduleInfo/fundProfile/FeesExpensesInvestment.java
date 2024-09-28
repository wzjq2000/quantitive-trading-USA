package org.mirror.DTO.quoteSummary.moduleInfo.fundProfile;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class FeesExpensesInvestment {

    private BigDecimal annualReportExpenseRatio;
    private BigDecimal annualHoldingsTurnover;
    private BigDecimal totalNetAssets;
    
    // TODO: what is the type of projectionValues and projectionValuesCat?
    private Object projectionValues;
    private Object projectionValuesCat;
}
