package org.mirror.DTO;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Calendar;

@Data
public class HistoricalQuote {
    private String symbol;
    private Calendar date;
    private BigDecimal high;
    private BigDecimal low;
    private BigDecimal open;
    private BigDecimal close;
    private Long volume;
    private BigDecimal adjClose;
}
