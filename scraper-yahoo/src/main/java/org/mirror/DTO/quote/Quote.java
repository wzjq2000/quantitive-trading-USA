package org.mirror.DTO.quote;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class Quote {
    // basic info
    private String language;  // eg. en-US
    private String region;  // eg. US
    private String quoteType;  // eg. Equity
    private String typeDisp;  // eg. Equity
    private String quoteSourceName;  // eg. Nasdaq Real Time Price
    private String symbol;  // eg. MSFT
    private String market;


    // name info of financial product
    private String shortName;
    private String longName;
    private String displayName;


    // info about trades
    private String currency;  // eg. USD
    private String exchange;  // eg. NMS
    private String fullExchangeName;  // eg. NasdaqGS
    private String financialCurrency;  // eg. USD


    // market state
    private String marketState;  // eg. POSTPOST
    private Boolean hasPrePostMarketData;
    private Boolean tradeable;
    private Boolean cryptoTradeable;


    // time and timezone
    private String exchangeTimezoneName;  // eg. America/New_York
    private String exchangeTimezoneShortName;  // eg. EDT
    private Long gmtOffSetMilliseconds;
    private Long firstTradeDateMilliseconds;

    // regular market
    private BigDecimal regularMarketOpen;
    private BigDecimal regularMarketPrice;
    private BigDecimal regularMarketChangePercent;
    private BigDecimal regularMarketChange;
    private Long regularMarketTime;
    private BigDecimal regularMarketDayHigh;
    private String regularMarketDayRange;
    private BigDecimal regularMarketDayLow;
    private Long regularMarketVolume;
    private BigDecimal regularMarketPreviousClose;


    // post market
    private BigDecimal postMarketChangePercent;
    private Long postMarketTime;
    private BigDecimal postMarketPrice;
    private BigDecimal postMarketChange;


    // bid and ask
    private BigDecimal bid;
    private BigDecimal ask;
    private Integer bidSize;
    private Integer askSize;


    // volume
    private Long averageDailyVolume3Month;
    private Long averageDailyVolume10Day;
    private Long sharesOutstanding;

    // market indicator
    private Long marketCap;
    private BigDecimal trailingPE;  // TTM
    private BigDecimal forwardPE;  // expected PE
    private BigDecimal priceToBook;


    // technical indicator
    private BigDecimal fiftyDayAverage;
    private BigDecimal fiftyDayAverageChange;
    private BigDecimal fiftyDayAverageChangePercent;
    private BigDecimal twoHundredDayAverage;
    private BigDecimal twoHundredDayAverageChange;
    private BigDecimal twoHundredDayAverageChangePercent;
    private String averageAnalystRating;


    // 52-week indicator
    private BigDecimal fiftyTwoWeekLowChange;
    private BigDecimal fiftyTwoWeekLowChangePercent;
    private String fiftyTwoWeekRange;
    private BigDecimal fiftyTwoWeekHighChange;
    private BigDecimal fiftyTwoWeekHighChangePercent;
    private BigDecimal fiftyTwoWeekLow;
    private BigDecimal fiftyTwoWeekHigh;
    private BigDecimal fiftyTwoWeekChangePercent;

    // fiscal indicator
    private BigDecimal bookValue;
    private BigDecimal trailingAnnualDividendRate;
    private BigDecimal dividendRate;
    private BigDecimal trailingAnnualDividendYield;
    private BigDecimal dividendYield;
    private BigDecimal epsTrailingTwelveMonths;
    private BigDecimal epsForward;
    private BigDecimal epsCurrentYear;
    private BigDecimal priceEpsCurrentYear;


    // other company info
    private String messageBoardId;  // eg. finmb_21835
    private Boolean esgPopulated;


    // alert
    private Boolean triggerable;
    private String customPriceAlertConfidence;


    // earnings, dividend
    private Long dividendDate;
    private Long earningsTimestamp;
    private Long earningsTimestampStart;
    private Long earningsTimestampEnd;
    private Long earningsCallTimestampStart;
    private Long earningsCallTimestampEnd;
    private Boolean isEarningsDateEstimate;


    // info about datasource
    private Integer sourceInterval;
    private Integer exchangeDataDelayedBy;
    private Integer priceHint;


}
