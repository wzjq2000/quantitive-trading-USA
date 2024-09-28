package org.mirror.DTO.quoteSummary.moduleInfo.recommendationTrend;

import lombok.Data;

@Data
public class Trend {
    private String period;
    private Integer strongBuy;
    private Integer buy;
    private Integer hold;
    private Integer sell;
    private Integer strongSell;
}
