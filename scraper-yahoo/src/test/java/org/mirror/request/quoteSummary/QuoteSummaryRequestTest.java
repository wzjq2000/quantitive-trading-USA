package org.mirror.request.quoteSummary;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.hc.core5.http.io.EofSensorInputStream;
import org.junit.jupiter.api.Test;
import org.mirror.DTO.quoteSummary.QuoteSummary;
import org.mirror.DTO.quoteSummary.QuoteSummaryWrapper;
import org.mirror.DTO.quoteSummary.moduleInfo.finanacialData.FinancialData;
import org.mirror.gernerator.ModuleWrapperGenerator;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.stream.Stream;

@Slf4j
public class QuoteSummaryRequestTest {


    @Test
    void testGetResponseBodyStringWithInit() {
        QuoteSummaryRequest qr = new QuoteSummaryRequest();
        qr.init("MSFT", "financialData");
        log.info(qr.getResponseBodyString());
    }

    @Test
    void testGetResponseEntityWithInit() {
        QuoteSummaryRequest qr = new QuoteSummaryRequest();
        qr.init("MSFT", "assetProfile","price");
        System.out.println(qr.getResponseBodyAsObject(QuoteSummaryWrapper.class).getQuoteSummary());
        log.info("finished");
    }

    @Test
    void testJsonToPojo() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        QuoteSummaryWrapper financialData = mapper.readValue(financialDataInputStream, QuoteSummaryWrapper.class);
        System.out.println(financialData);
    }

    @Test
    void testAllModulesFromJsonToPojo() throws IOException {
        Stream<String> modules = ModuleWrapperGenerator.readFromResourceAndExtract("src/main/resources/generateFrom/Modules");

        modules.parallel().map((module) -> {
            QuoteSummaryRequest qr = new QuoteSummaryRequest();
            qr.init("MSFT", module);
            return qr;
        }).forEach(qr -> {
//            try {
                QuoteSummary quoteSummary = qr.getResponseBodyAsObject(QuoteSummaryWrapper.class).getQuoteSummary();
                log.info(quoteSummary.toString());
//            } catch (NullPointerException e) {
//                log.info("-----------"+qr.getModules().toString()+"------------");
//            } catch (Exception e) {
//                log.error("",e);
//
//            }
        });
    }


    String financialDataJson = "{\n" +
            "    \"quoteSummary\": {\n" +
            "        \"result\": [\n" +
            "            {\n" +
            "                \"financialData\": {\n" +
            "                    \"currentPrice\": 254.946,\n" +
            "                    \"targetHighPrice\": 310.0,\n" +
            "                    \"targetLowPrice\": 24.86,\n" +
            "                    \"targetMeanPrice\": 210.71,\n" +
            "                    \"targetMedianPrice\": 221.0,\n" +
            "                    \"recommendationMean\": 2.7,\n" +
            "                    \"recommendationKey\": \"hold\",\n" +
            "                    \"numberOfAnalystOpinions\": 43,\n" +
            "                    \"totalCash\": 30720000000,\n" +
            "                    \"totalCashPerShare\": 9.616,\n" +
            "                    \"ebitda\": 12177999872,\n" +
            "                    \"totalDebt\": 12515000320,\n" +
            "                    \"quickRatio\": 1.249,\n" +
            "                    \"currentRatio\": 1.911,\n" +
            "                    \"totalRevenue\": 95317999616,\n" +
            "                    \"debtToEquity\": 18.606,\n" +
            "                    \"revenuePerShare\": 29.932,\n" +
            "                    \"returnOnAssets\": 0.044159997,\n" +
            "                    \"returnOnEquity\": 0.20861,\n" +
            "                    \"freeCashflow\": -907249984,\n" +
            "                    \"operatingCashflow\": 11532000256,\n" +
            "                    \"earningsGrowth\": -0.462,\n" +
            "                    \"revenueGrowth\": 0.023,\n" +
            "                    \"grossMargins\": 0.17719999,\n" +
            "                    \"ebitdaMargins\": 0.12776,\n" +
            "                    \"operatingMargins\": 0.0858,\n" +
            "                    \"profitMargins\": 0.12996,\n" +
            "                    \"financialCurrency\": \"USD\"\n" +
            "                }\n" +
            "            }\n" +
            "        ],\n" +
            "        \"error\": null\n" +
            "    }\n" +
            "}";

    InputStream financialDataInputStream = new EofSensorInputStream(new ByteArrayInputStream(financialDataJson.getBytes()), null);
}
