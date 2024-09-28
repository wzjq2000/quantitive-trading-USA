package org.mirror.DTO.quoteSummary.moduleInfo.defaultKeyStatistics;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.mirror.DTO.quoteSummary.moduleInfo.ModuleInfo;

import java.math.BigDecimal;

@Data
public class DefaultKeyStatistics extends ModuleInfo {
    private Integer maxAge;
    private Integer priceHint;
    private Long enterpriseValue;
    private BigDecimal forwardPE;
    private BigDecimal profitMargins;
    private Long floatShares;
    private Long sharesOutstanding;
    private Long sharesShort;
    private Long sharesShortPriorMonth;
    private Long sharesShortPreviousMonthDate;
    private Long dateShortInterest;
    private BigDecimal sharesPercentSharesOut;
    private BigDecimal heldPercentInsiders;
    private BigDecimal heldPercentInstitutions;
    private BigDecimal shortRatio;
    private BigDecimal shortPercentOfFloat;
    private BigDecimal beta;
    private Long impliedSharesOutstanding;
    private String category;
    private BigDecimal bookValue;
    private BigDecimal priceToBook;
    private String fundFamily;
    private String legalType;
    private Long lastFiscalYearEnd;
    private Long nextFiscalYearEnd;
    private Long mostRecentQuarter;
    private BigDecimal earningsQuarterlyGrowth;
    private Long netIncomeToCommon;
    private BigDecimal trailingEps;
    private BigDecimal forwardEps;
    private BigDecimal pegRatio;
    private String lastSplitFactor;
    private Long lastSplitDate;
    private BigDecimal enterpriseToRevenue;
    private BigDecimal enterpriseToEbitda;

    @JsonProperty("52WeekChange")
    private BigDecimal _52WeekChange;

    @JsonProperty("SandP52WeekChange")
    private BigDecimal sandP52WeekChange;
    private BigDecimal lastDividendValue;
    private Long lastDividendDate;

    private BigDecimal ytdReturn;
}
