package org.mirror.DTO.quote;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * https://query2.finance.yahoo.com/v7/finance/quote?symbols=xxxx,yyyy,...
 */
@Data
public class QuoteResponseWrapper {
    QuoteResponse quoteResponse;
}
