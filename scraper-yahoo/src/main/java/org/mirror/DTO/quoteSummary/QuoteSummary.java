package org.mirror.DTO.quoteSummary;

import lombok.Data;
import org.mirror.DTO.quoteSummary.moduleInfo.ModuleInfo;
import org.mirror.DTO.quoteSummary.moduleInfo.ModuleInfoWrapper;

import java.util.List;

@Data
public class QuoteSummary {
    private List<ModuleInfoWrapper> result;
    private String error;
}
