package org.mirror.DTO.quoteSummary.moduleInfo.finanacialData;

import lombok.Data;
import org.mirror.DTO.quoteSummary.moduleInfo.ModuleInfo;
import java.math.BigDecimal;

@Data
public class FinancialData extends ModuleInfo {
    private Integer maxAge;
    private BigDecimal currentPrice;
    private BigDecimal targetHighPrice;
    private BigDecimal targetLowPrice;
    private BigDecimal targetMeanPrice;
    private BigDecimal targetMedianPrice;
    private BigDecimal recommendationMean;
    private String recommendationKey;
    private Integer numberOfAnalystOpinions;
    private Long totalCash;
    private BigDecimal totalCashPerShare;
    private Long ebitda;
    private Long totalDebt;
    private BigDecimal quickRatio;
    private BigDecimal currentRatio;
    private Long totalRevenue;
    private BigDecimal debtToEquity;
    private BigDecimal revenuePerShare;
    private BigDecimal returnOnAssets;
    private BigDecimal returnOnEquity;
    private Long freeCashflow;
    private Long operatingCashflow;
    private BigDecimal earningsGrowth;
    private BigDecimal revenueGrowth;
    private BigDecimal grossMargins;
    private BigDecimal ebitdaMargins;
    private BigDecimal operatingMargins;
    private BigDecimal profitMargins;
    private String financialCurrency;
}
