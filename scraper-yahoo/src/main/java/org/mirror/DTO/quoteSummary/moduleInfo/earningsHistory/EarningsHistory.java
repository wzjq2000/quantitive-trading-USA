package org.mirror.DTO.quoteSummary.moduleInfo.earningsHistory;


import lombok.Data;
import org.mirror.DTO.quoteSummary.moduleInfo.ModuleInfo;

import java.util.List;

@Data
public class EarningsHistory extends ModuleInfo {

    private List<History> history;
    private Integer maxAge;
}
