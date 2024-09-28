package org.mirror.DTO.quoteSummary.moduleInfo.earnings;

import lombok.Data;

import java.util.List;
@Data
public class FinancialsChart {
    private List<RevenueEarningYearly> yearly;
    private List<RevenueEarningQuarterly> quarterly;
}
