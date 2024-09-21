package org.mirror.DTO.quote;

import lombok.Data;

import java.util.List;


@Data
public class QuoteResponse {
    private List<Quote> result;
    private String error;
}
