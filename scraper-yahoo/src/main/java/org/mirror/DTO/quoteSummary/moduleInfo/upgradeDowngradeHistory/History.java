package org.mirror.DTO.quoteSummary.moduleInfo.upgradeDowngradeHistory;

import lombok.Data;

@Data
public class History {
    private Long epochGradeDate;
    private String firm;
    private String toGrade;
    private String fromGrade;
    private String action;
    private Integer maxAge;
}
