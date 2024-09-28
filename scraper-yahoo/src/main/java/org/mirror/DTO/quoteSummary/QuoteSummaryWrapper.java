package org.mirror.DTO.quoteSummary;

import lombok.Data;
import org.mirror.basicDTO.ResponseWrapper;

@Data
public class QuoteSummaryWrapper extends ResponseWrapper<QuoteSummary> {
    private QuoteSummary quoteSummary;

}
