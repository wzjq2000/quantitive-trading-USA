package org.mirror.DTO;

import consts.*;
import lombok.Data;

import java.util.List;

// why would I write this class in the first place??
@Data
public class FinancialProductMeta {
    private CurrencyEnum currency;
    private String symbol;
    private ExchangeNameEnum exchangeName;
    private FullExchangeNameEnum fullExchangeName;
    private InstrumentTypeEnum instrumentType;
    private Long firstTradeDate;
    private Long regularMatketTime;
    private Boolean hasPrePostMarketData;
    private Long gmtOffset;
    private TimezoneEnum timezone;
    private ExchangeTimezoneNameEnum exchangeTimezoneName;
    private Double regularMarketPrice;
    private Double fiftyTwoWeekHigh;
    private Double fiftyTwoWeekLow;
    private Double regularMarketDayHigh;
    private Double regularMarketDayLow;
    private Double regularMarketVolume;
    private String longName;
    private String shortName;
    private Double chartPreviousClose;
    private Integer priceHint;  // 精度
    private List<CurrentTradingPeriod> currentTradingPeriod;  // pre, regular, post
    private DataGranularityEnum dataGranularity;
    private DataRangeEnum range;
    private List<DataRangeEnum> validRanges;
}
