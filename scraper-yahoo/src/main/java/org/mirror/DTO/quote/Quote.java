package org.mirror.DTO.quote;

import lombok.Data;

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
    private Double regularMarketOpen;
    private Double regularMarketPrice;
    private Double regularMarketChangePercent;
    private Double regularMarketChange;
    private Long regularMarketTime;
    private Double regularMarketDayHigh;
    private String regularMarketDayRange;
    private Double regularMarketDayLow;
    private Long regularMarketVolume;
    private Double regularMarketPreviousClose;


    // post market
    private Double postMarketChangePercent;
    private Long postMarketTime;
    private Double postMarketPrice;
    private Double postMarketChange;


    // bid and ask
    private Double bid;
    private Double ask;
    private Integer bidSize;
    private Integer askSize;


    // volume
    private Long averageDailyVolume3Month;
    private Long averageDailyVolume10Day;
    private Long sharesOutstanding;

    // market indicator
    private Long marketCap;
    private Double trailingPE;  // TTM
    private Double forwardPE;  // expected PE
    private Double priceToBook;


    // technical indicator
    private Double fiftyDayAverage;
    private Double fiftyDayAverageChange;
    private Double fiftyDayAverageChangePercent;
    private Double twoHundredDayAverage;
    private Double twoHundredDayAverageChange;
    private Double twoHundredDayAverageChangePercent;
    private String averageAnalystRating;


    // 52-week indicator
    private Double fiftyTwoWeekLowChange;
    private Double fiftyTwoWeekLowChangePercent;
    private String fiftyTwoWeekRange;
    private Double fiftyTwoWeekHighChange;
    private Double fiftyTwoWeekHighChangePercent;
    private Double fiftyTwoWeekLow;
    private Double fiftyTwoWeekHigh;
    private Double fiftyTwoWeekChangePercent;

    // fiscal indicator
    private Double bookValue;
    private Double trailingAnnualDividendRate;
    private Double dividendRate;
    private Double trailingAnnualDividendYield;
    private Double dividendYield;
    private Double epsTrailingTwelveMonths;
    private Double epsForward;
    private Double epsCurrentYear;
    private Double priceEpsCurrentYear;


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
