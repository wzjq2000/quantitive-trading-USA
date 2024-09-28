package org.mirror.DTO.quoteSummary.moduleInfo.price;

import lombok.Data;
import org.mirror.DTO.quoteSummary.moduleInfo.ModuleInfo;

import java.math.BigDecimal;

@Data
public class Price extends ModuleInfo {

    private Integer maxAge;
    private Long preMarketTime;
    private BigDecimal preMarketChange;
    private BigDecimal preMarketChangePercent;
    private String preMarketSource;
    private BigDecimal postMarketChangePercent;
    private BigDecimal postMarketChange;
    private Long postMarketTime;
    private BigDecimal postMarketPrice;
    private String postMarketSource;
    private BigDecimal regularMarketChangePercent;
    private BigDecimal regularMarketChange;
    private Long regularMarketTime;
    private Integer priceHint;
    private BigDecimal regularMarketPrice;
    private BigDecimal regularMarketDayHigh;
    private BigDecimal regularMarketDayLow;
    private Long regularMarketVolume;
    private Long averageDailyVolume10Day;
    private Long averageDailyVolume3Month;
    private BigDecimal regularMarketPreviousClose;
    private String regularMarketSource;
    private BigDecimal regularMarketOpen;
    private String exchange;
    private String exchangeName;
    private Integer exchangeDataDelayedBy;
    private String marketState;
    private String quoteType;
    private String symbol;
    private String underlyingSymbol;
    private String shortName;
    private String longName;
    private String currency;
    private String quoteSourceName;
    private String currencySymbol;
    private String fromCurrency;
    private String toCurrency;
    private String lastMarket;
    private Long marketCap;
    public Double preMarketPrice;

}
