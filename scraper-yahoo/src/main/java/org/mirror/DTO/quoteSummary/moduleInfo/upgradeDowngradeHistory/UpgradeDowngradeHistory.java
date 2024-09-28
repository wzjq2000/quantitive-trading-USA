package org.mirror.DTO.quoteSummary.moduleInfo.upgradeDowngradeHistory;

import lombok.Data;
import org.mirror.DTO.quoteSummary.moduleInfo.ModuleInfo;

import java.util.List;

@Data
public class UpgradeDowngradeHistory extends ModuleInfo {
    private List<History> history;
    private Integer maxAge;
}
