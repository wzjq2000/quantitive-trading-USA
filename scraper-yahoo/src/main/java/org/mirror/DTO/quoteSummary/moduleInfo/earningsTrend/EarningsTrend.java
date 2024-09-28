package org.mirror.DTO.quoteSummary.moduleInfo.earningsTrend;

import lombok.Data;
import org.mirror.DTO.quoteSummary.moduleInfo.ModuleInfo;

import java.util.List;

@Data
public class EarningsTrend extends ModuleInfo {

    private List<Trend> trend;
    private Integer maxAge;
}
