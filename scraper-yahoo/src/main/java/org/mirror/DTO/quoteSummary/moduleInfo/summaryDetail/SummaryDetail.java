package org.mirror.DTO.quoteSummary.moduleInfo.summaryDetail;

import lombok.Data;
import org.mirror.DTO.quoteSummary.moduleInfo.ModuleInfo;

import java.math.BigDecimal;

@Data   
public class SummaryDetail extends ModuleInfo{
    private Integer maxAge;
    private Integer priceHint;
    private BigDecimal previousClose;
    private BigDecimal open;
    private BigDecimal dayLow;
    private BigDecimal dayHigh;
    private BigDecimal regularMarketPreviousClose;
    private BigDecimal regularMarketOpen;
    private BigDecimal regularMarketDayLow;
    private BigDecimal regularMarketDayHigh;
    private BigDecimal dividendRate;
    private BigDecimal dividendYield;
    private Integer exDividendDate;
    private BigDecimal payoutRatio;
    private BigDecimal fiveYearAvgDividendYield;
    private BigDecimal beta;
    private BigDecimal trailingPE;
    private BigDecimal forwardPE;
    private Integer volume;
    private Integer regularMarketVolume;
    private Integer averageVolume;
    private Integer averageVolume10days;
    private Integer averageDailyVolume10Day;
    private BigDecimal bid;
    private BigDecimal ask;
    private Integer bidSize;
    private Integer askSize;
    private Long marketCap;
    private BigDecimal fiftyTwoWeekLow;
    private BigDecimal fiftyTwoWeekHigh;
    private BigDecimal priceToSalesTrailing12Months;
    private BigDecimal fiftyDayAverage;
    private BigDecimal twoHundredDayAverage;
    private BigDecimal trailingAnnualDividendRate;
    private BigDecimal trailingAnnualDividendYield;
    private String currency;
    private String fromCurrency;
    private String toCurrency;
    private String lastMarket;
    private String coinMarketCapLink;
    private String algorithm;
    private Boolean tradeable;
    private BigDecimal yield;
}
