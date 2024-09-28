package org.mirror.DTO.quoteSummary.moduleInfo.incomeStatementHistory;

import lombok.Data;
import org.mirror.DTO.quoteSummary.moduleInfo.ModuleInfo;

import java.util.List;

@Data
public class IncomeStatementHistory extends ModuleInfo {
    protected List<IncomeStatementHistoryInner> incomeStatementHistory;
    protected Integer maxAge;
}
