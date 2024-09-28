package org.mirror.DTO.quoteSummary.moduleInfo.netSharePurchaseActivity;

import lombok.Data;
import org.mirror.DTO.quoteSummary.moduleInfo.ModuleInfo;

import java.math.BigDecimal;

@Data
public class NetSharePurchaseActivity extends ModuleInfo {
    private Integer maxAge;
    private String period;
    private Integer buyInfoCount;
    private Integer buyInfoShares;
    private BigDecimal buyPercentInsiderShares;
    private Integer sellInfoCount;
    private Integer sellInfoShares;
    private BigDecimal sellPercentInsiderShares;
    private Integer netInfoCount;
    private Integer netInfoShares;
    private BigDecimal netPercentInsiderShares;
    private Long totalInsiderShares;
}
