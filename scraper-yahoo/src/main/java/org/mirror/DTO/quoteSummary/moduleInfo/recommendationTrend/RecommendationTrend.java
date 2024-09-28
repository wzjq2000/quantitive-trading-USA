package org.mirror.DTO.quoteSummary.moduleInfo.recommendationTrend;

import lombok.Data;
import org.mirror.DTO.quoteSummary.moduleInfo.ModuleInfo;

import java.util.List;


@Data
public class RecommendationTrend extends ModuleInfo {

    private List<Trend> trend;
    private Integer maxAge;
}
