package org.mirror.DTO.quoteSummary.moduleInfo.earnings;

import lombok.Data;

@Data
public class RevenueEarningQuarterly {
    private String date;
    private Long revenue;
    private Long earnings;
}
