package org.mirror.DTO.quoteSummary.moduleInfo.majorDirectHolders;

import lombok.Data;
import org.mirror.DTO.quoteSummary.moduleInfo.ModuleInfo;

@Data
public class MajorDirectHolders extends ModuleInfo {
    // TODO: what is exact type here?
    private Object holders;
    private Integer maxAge;
}
