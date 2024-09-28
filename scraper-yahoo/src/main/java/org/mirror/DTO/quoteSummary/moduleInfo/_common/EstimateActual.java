package org.mirror.DTO.quoteSummary.moduleInfo._common;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class EstimateActual {
    private String date;
    private BigDecimal actual;
    private BigDecimal estimate;
}
