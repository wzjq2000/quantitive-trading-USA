package org.mirror.DTO.quoteSummary.moduleInfo.secFilings;

import lombok.Data;
import org.mirror.DTO.quoteSummary.moduleInfo.ModuleInfo;

import java.util.List;

@Data
public class SecFilings extends ModuleInfo {

    private List<Filing> filings;
    private Integer maxAge;
}
