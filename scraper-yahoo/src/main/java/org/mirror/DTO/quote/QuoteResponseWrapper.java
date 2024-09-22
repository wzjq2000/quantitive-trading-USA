package org.mirror.DTO.quote;

import lombok.Data;
import org.mirror.basicDTO.ResponseWrapper;

/**
 * https://query2.finance.yahoo.com/v7/finance/quote?symbols=xxxx,yyyy,...
 */
@Data
public class QuoteResponseWrapper extends ResponseWrapper<QuoteResponse> {
    private QuoteResponse quoteResponse;
}
