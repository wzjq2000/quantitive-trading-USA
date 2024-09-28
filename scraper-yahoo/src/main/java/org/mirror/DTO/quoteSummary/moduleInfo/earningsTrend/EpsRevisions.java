package org.mirror.DTO.quoteSummary.moduleInfo.earningsTrend;

import lombok.Data;
import org.mirror.DTO.quoteSummary.moduleInfo._common.FormattedData;

@Data
public class EpsRevisions {
    private FormattedData upLast7days;
    private FormattedData upLast30days;
    private FormattedData downLast30days;
    private FormattedData downLast90days;
}
