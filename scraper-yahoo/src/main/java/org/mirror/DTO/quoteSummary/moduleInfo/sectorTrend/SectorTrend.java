package org.mirror.DTO.quoteSummary.moduleInfo.sectorTrend;

import lombok.Data;
import org.mirror.DTO.quoteSummary.moduleInfo.ModuleInfo;

import java.util.List;

@Data
public class SectorTrend extends ModuleInfo {
    public Integer maxAge;
    public String symbol;
    // TODO: what is the exact type of "estimate"?
    public List<Object> estimates;
}
