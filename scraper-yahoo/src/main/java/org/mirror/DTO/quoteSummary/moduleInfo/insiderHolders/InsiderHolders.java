package org.mirror.DTO.quoteSummary.moduleInfo.insiderHolders;

import lombok.Data;
import org.mirror.DTO.quoteSummary.moduleInfo.ModuleInfo;

import java.util.List;

@Data
public class InsiderHolders extends ModuleInfo {
    private List<Holder> holders;
    private Integer maxAge;
}
