package org.mirror.DTO.quoteSummary.moduleInfo.insiderHolders;

import lombok.Data;
import org.mirror.DTO.quoteSummary.moduleInfo._common.FormattedData;

@Data
public class Holder {

    private Integer maxAge;
    private String name;
    private String relation;
    private String url;
    private String transactionDescription;
    private FormattedData latestTransDate;
    private FormattedData positionDirect;
    private FormattedData positionDirectDate;

}