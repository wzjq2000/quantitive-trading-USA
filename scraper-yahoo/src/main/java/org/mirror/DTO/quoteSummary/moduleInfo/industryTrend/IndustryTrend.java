package org.mirror.DTO.quoteSummary.moduleInfo.industryTrend;

import lombok.Data;
import org.mirror.DTO.quoteSummary.moduleInfo.ModuleInfo;

import java.util.List;

@Data
public class IndustryTrend extends ModuleInfo {
    public Integer maxAge;
    public String symbol;
    // TODO: what is the exact type of "estimate"?
    public List<Object> estimates;
}
