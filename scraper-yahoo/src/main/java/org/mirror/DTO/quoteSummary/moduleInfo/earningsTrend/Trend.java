package org.mirror.DTO.quoteSummary.moduleInfo.earningsTrend;

import lombok.Data;
import org.mirror.DTO.quoteSummary.moduleInfo._common.FormattedData;

@Data
public class Trend {

    private Integer maxAge;
    private String period;
    private String endDate;
    private FormattedData growth;
    private EarningsEstimate earningsEstimate;
    private RevenueEstimate revenueEstimate;
    private EpsTrend epsTrend;
    private EpsRevisions epsRevisions;
}
