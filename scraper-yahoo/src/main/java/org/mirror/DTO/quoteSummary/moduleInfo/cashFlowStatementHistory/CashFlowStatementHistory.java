package org.mirror.DTO.quoteSummary.moduleInfo.cashFlowStatementHistory;

import lombok.Data;
import org.mirror.DTO.quoteSummary.QuoteSummary;
import org.mirror.DTO.quoteSummary.moduleInfo.ModuleInfo;

import java.util.List;

@Data
public class CashFlowStatementHistory extends ModuleInfo {
    protected List<CashflowStatement> cashflowStatements;
    protected Integer maxAge;
}
