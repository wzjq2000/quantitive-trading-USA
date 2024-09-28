package org.mirror.DTO.quoteSummary.moduleInfo.esgScores;

import lombok.Data;
import org.mirror.DTO.quoteSummary.moduleInfo.ModuleInfo;
import org.mirror.DTO.quoteSummary.moduleInfo._common.MinMaxAvg;

import java.math.BigDecimal;
import java.util.List;

@Data
public class EsgScores extends ModuleInfo {

    private Integer maxAge;
    private BigDecimal totalEsg;
    private BigDecimal environmentScore;
    private BigDecimal socialScore;
    private BigDecimal governanceScore;
    private Integer ratingYear;
    private Integer ratingMonth;
    private BigDecimal highestControversy;
    private Integer peerCount;
    private String esgPerformance;
    private String peerGroup;
    private List<String> relatedControversy;
    private MinMaxAvg peerEsgScorePerformance;
    private MinMaxAvg peerGovernancePerformance;
    private MinMaxAvg peerSocialPerformance;
    private MinMaxAvg peerEnvironmentPerformance;
    private MinMaxAvg peerHighestControversyPerformance;
    private BigDecimal percentile;
    private BigDecimal environmentPercentile;
    private BigDecimal socialPercentile;
    private BigDecimal governancePercentile;
    private Boolean adult;
    private Boolean alcoholic;
    private Boolean animalTesting;
    private Boolean catholic;
    private Boolean controversialWeapons;
    private Boolean smallArms;
    private Boolean furLeather;
    private Boolean gambling;
    private Boolean gmo;
    private Boolean militaryContract;
    private Boolean nuclear;
    private Boolean pesticides;
    private Boolean palmOil;
    private Boolean coal;
    private Boolean tobacco;
}
