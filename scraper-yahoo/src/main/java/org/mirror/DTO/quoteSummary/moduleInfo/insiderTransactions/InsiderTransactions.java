package org.mirror.DTO.quoteSummary.moduleInfo.insiderTransactions;

import lombok.Data;
import org.mirror.DTO.quoteSummary.moduleInfo.ModuleInfo;

import java.util.List;

@Data
public class InsiderTransactions extends ModuleInfo {
    private List<Transaction> transactions;
    private Integer maxAge;
}
