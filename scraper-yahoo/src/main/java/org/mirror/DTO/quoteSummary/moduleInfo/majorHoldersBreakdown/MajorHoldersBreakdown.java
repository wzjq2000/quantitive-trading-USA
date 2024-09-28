package org.mirror.DTO.quoteSummary.moduleInfo.majorHoldersBreakdown;

import lombok.Data;
import org.mirror.DTO.quoteSummary.moduleInfo.ModuleInfo;

import java.math.BigDecimal;

@Data
public class MajorHoldersBreakdown extends ModuleInfo {
    private Integer maxAge;
    private BigDecimal insidersPercentHeld;
    private BigDecimal institutionsPercentHeld;
    private BigDecimal institutionsFloatPercentHeld;
    private Integer institutionsCount;
}
