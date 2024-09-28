package org.mirror.DTO.quoteSummary.moduleInfo.fundOwnership;

import lombok.Data;
import org.mirror.DTO.quoteSummary.moduleInfo.ModuleInfo;
import org.mirror.DTO.quoteSummary.moduleInfo._common.Ownership;

import java.util.List;

@Data
public class FundOwnership extends ModuleInfo {
    private Integer maxAge;
    private List<Ownership> ownershipList;

}
