package org.mirror.DTO.quoteSummary.moduleInfo.secFilings;

import lombok.Data;

import java.util.List;

@Data
public class Filing {

    private String date;
    private Integer epochDate;
    private String type;
    private String title;
    private String edgarUrl;
    private List<Exhibit> exhibits;
    private Integer maxAge;

}