package org.mirror.DTO.quoteSummary.moduleInfo.indexTrend;

import lombok.Data;
import org.mirror.DTO.quoteSummary.moduleInfo.ModuleInfo;

import java.math.BigDecimal;
import java.util.List;

@Data
public class IndexTrend extends ModuleInfo{
    private Integer maxAge;
    private String symbol;
    private BigDecimal peRatio;
    private BigDecimal pegRatio;
    private List<Estimate> estimates;
}
