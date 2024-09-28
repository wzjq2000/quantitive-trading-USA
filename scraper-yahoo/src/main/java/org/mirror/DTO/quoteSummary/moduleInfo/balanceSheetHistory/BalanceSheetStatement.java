package org.mirror.DTO.quoteSummary.moduleInfo.balanceSheetHistory;

import lombok.Data;
import org.mirror.DTO.quoteSummary.moduleInfo._common.FormattedData;

@Data
public class BalanceSheetStatement {
    private Integer maxAge;
    private FormattedData endDate;
}
