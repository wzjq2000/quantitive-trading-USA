package org.mirror.DTO.quoteSummary.moduleInfo.quoteType;

import lombok.Data;
import org.mirror.DTO.quoteSummary.moduleInfo.ModuleInfo;

@Data
public class QuoteType extends ModuleInfo {
    private String exchange;
    private String quoteType;
    private String symbol;
    private String underlyingSymbol;
    private String shortName;
    private String longName;
    private Long firstTradeDateEpochUtc;
    private String timeZoneFullName;
    private String timeZoneShortName;
    private String uuid;
    private String messageBoardId;
    private Long gmtOffSetMilliseconds;
    private Integer maxAge;
}
