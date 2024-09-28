package org.mirror.DTO.quoteSummary.moduleInfo.calendatEvents;

import lombok.Data;
import org.mirror.DTO.quoteSummary.moduleInfo.ModuleInfo;

@Data
public class CalendarEvents extends ModuleInfo {

    private Integer maxAge;
    private Earnings earnings;
    private Long exDividendDate;
    private Long dividendDate;
}
