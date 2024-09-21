package org.mirror.DTO;

import lombok.Data;

import java.util.Calendar;

@Data
public class HistoricalQuote {
    private String symbol;
    private Calendar date;
    private Double high;
    private Double low;
    private Double open;
    private Double close;
    private Long volume;
    private Double adjClose;
}
