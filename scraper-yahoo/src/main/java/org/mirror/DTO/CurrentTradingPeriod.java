package org.mirror.DTO;

import consts.TradingPeriodEnum;
import lombok.Data;

@Data
public class CurrentTradingPeriod {
    private TradingPeriodEnum tradingPeriod;
    private Long end;
    private Long start;
    private Long gmtOffset;
}
