package org.mirror.DTO.quoteSummary.moduleInfo._common;

import lombok.Data;



@Data
public class Ownership  {
    private Integer maxAge;
    private FormattedData reportDate;
    private String organization;
    private FormattedData pctHeld;
    private FormattedData position;
    private FormattedData value;
    private FormattedData pctChange;
}
