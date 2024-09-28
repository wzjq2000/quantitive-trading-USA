package org.mirror.DTO.quoteSummary.moduleInfo.balanceSheetHistory;

import lombok.Data;
import org.mirror.DTO.quoteSummary.moduleInfo.ModuleInfo;

import java.util.List;

@Data
public class BalanceSheetHistory extends ModuleInfo {
    protected List<BalanceSheetStatement> balanceSheetStatements;
    protected Integer maxAge;
}
