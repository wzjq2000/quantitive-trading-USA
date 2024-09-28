package org.mirror.DTO.quoteSummary.moduleInfo.earningsHistory;

import lombok.Data;
import org.mirror.DTO.quoteSummary.moduleInfo._common.FormattedData;

@Data
public class History {
    private Integer maxAge;
    private FormattedData epsActual;
    private FormattedData epsEstimate;
    private FormattedData epsDifference;
    private FormattedData surprisePercent;
    private FormattedData quarter;
    private String period;
}
