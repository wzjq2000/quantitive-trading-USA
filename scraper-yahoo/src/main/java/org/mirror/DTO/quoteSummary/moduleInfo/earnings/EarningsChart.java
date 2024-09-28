package org.mirror.DTO.quoteSummary.moduleInfo.earnings;

import lombok.Data;
import org.mirror.DTO.quoteSummary.moduleInfo._common.EstimateActual;

import java.math.BigDecimal;
import java.util.List;
@Data
public class EarningsChart {

    private List<EstimateActual> quarterly;
    private BigDecimal currentQuarterEstimate;
    private String currentQuarterEstimateDate;
    private Integer currentQuarterEstimateYear;
    private List<Long> earningsDate;
    private Boolean isEarningsDateEstimate;
}
