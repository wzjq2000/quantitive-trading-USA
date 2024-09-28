package org.mirror.DTO.quoteSummary.moduleInfo.earningsTrend;

import lombok.Data;
import org.mirror.DTO.quoteSummary.moduleInfo._common.FormattedData;

@Data
public class EarningsEstimate {

    private FormattedData avg;
    private FormattedData low;
    private FormattedData high;
    private FormattedData yearAgoEps;
    private FormattedData numberOfAnalysts;
    private FormattedData growth;
}
