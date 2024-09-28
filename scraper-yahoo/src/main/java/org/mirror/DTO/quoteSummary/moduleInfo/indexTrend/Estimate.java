package org.mirror.DTO.quoteSummary.moduleInfo.indexTrend;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class Estimate {

    private String period;
    private BigDecimal growth;
}
