package org.mirror.DTO.quoteSummary.moduleInfo._common;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class FormattedData {
    private BigDecimal raw;
    private String fmt;
    private String longFmt;
}
