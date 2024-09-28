package org.mirror.DTO.quoteSummary.moduleInfo.earningsTrend;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.mirror.DTO.quoteSummary.moduleInfo._common.FormattedData;

@Data
public class EpsTrend {
    private FormattedData current;
    @JsonProperty("7daysAgo")
    private FormattedData _7daysAgo;
    @JsonProperty("30daysAgo")
    private FormattedData _30daysAgo;
    @JsonProperty("60daysAgo")
    private FormattedData _60daysAgo;
    @JsonProperty("90daysAgo")
    private FormattedData _90daysAgo;
}
