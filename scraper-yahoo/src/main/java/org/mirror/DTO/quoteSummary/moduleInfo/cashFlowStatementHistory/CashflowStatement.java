package org.mirror.DTO.quoteSummary.moduleInfo.cashFlowStatementHistory;

import lombok.Data;
import org.mirror.DTO.quoteSummary.moduleInfo._common.FormattedData;
@Data
public class CashflowStatement {
    private Integer maxAge;
    private FormattedData endDate;
    private FormattedData netIncome;
}
