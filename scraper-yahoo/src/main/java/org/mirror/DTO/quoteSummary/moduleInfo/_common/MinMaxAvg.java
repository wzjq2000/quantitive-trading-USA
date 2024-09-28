package org.mirror.DTO.quoteSummary.moduleInfo._common;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class MinMaxAvg {

    private BigDecimal min;
    private BigDecimal avg;
    private BigDecimal max;
}
