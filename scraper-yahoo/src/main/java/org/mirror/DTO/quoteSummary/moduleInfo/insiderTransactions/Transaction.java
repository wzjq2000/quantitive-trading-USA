package org.mirror.DTO.quoteSummary.moduleInfo.insiderTransactions;

import lombok.Data;
import org.mirror.DTO.quoteSummary.moduleInfo._common.FormattedData;
@Data
public class Transaction {
    private Integer maxAge;
    private FormattedData shares;
    private FormattedData value;
    private String filerUrl;
    private String transactionText;
    private String filerName;
    private String filerRelation;
    private String moneyText;
    private FormattedData startDate;
    private String ownership;
}
