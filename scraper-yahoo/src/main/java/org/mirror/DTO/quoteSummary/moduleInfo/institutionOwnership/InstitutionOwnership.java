package org.mirror.DTO.quoteSummary.moduleInfo.institutionOwnership;

import lombok.Data;
import org.mirror.DTO.quoteSummary.moduleInfo.ModuleInfo;
import org.mirror.DTO.quoteSummary.moduleInfo._common.Ownership;

import java.util.List;

@Data
public class InstitutionOwnership extends ModuleInfo {

    private Integer maxAge;
    private List<Ownership> ownershipList;
}
