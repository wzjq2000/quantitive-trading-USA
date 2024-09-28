package org.mirror.DTO.quoteSummary.moduleInfo.calendatEvents;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class Earnings {
    private List<Long> earningsDate;
    private List<Long> earningsCallDate;
    private Boolean isEarningsDateEstimate;
    private BigDecimal earningsAverage;
    private BigDecimal earningsLow;
    private BigDecimal earningsHigh;
    private Long revenueAverage;
    private Long revenueLow;
    private Long revenueHigh;
}
