package org.mirror.request.quoteSummary;

import lombok.extern.slf4j.Slf4j;
import org.mirror.DTO.quoteSummary.QuoteSummaryWrapper;
import org.mirror.consts.QuoteSummaryModuleConsts;
import org.mirror.request.JacksonFinancialDataRequest;

import java.util.ArrayList;
import java.util.List;

import static org.mirror.httpConsts.YahooApiUrlConsts.BASE_URL;
import static org.mirror.httpConsts.httpBasic.URLConstants.COMMA;

@Slf4j
public class QuoteSummaryRequest extends JacksonFinancialDataRequest<QuoteSummaryWrapper> {
    private final static String url = BASE_URL + "/v10/finance/quoteSummary/";
    private List<String> modules=new ArrayList<>();

    /**
     * Initialize the {@link org.mirror.client.HttpClientHolder.HttpRequestBuilder}. In a word, we need to build the full URL to request. Thus, the user need to pass symbols of financial products to make request to.
     *
     * @param symbol Symbol of financial product to make request to. eg. MSFT
     */
    public void init(String symbol, String... modules) {
        if (symbol == null || symbol.length() == 0 || modules == null || modules.length == 0) {
            log.error("No symbol or module is specified, init failed");
            return;
        }
        if (!checkModules(modules)) {
            return;
        }
        super.init();
        initRequestBuilder(symbol, modules);

    }

    private boolean checkModules(String... modules) {
        for (String module : modules) {
            if (!QuoteSummaryModuleConsts.MODULE_SET.contains(module)) {
                log.error("Illegal Module: \"" + module + "\"");
                return false;
            }
            this.modules.add(module);
        }
        return true;
    }

    private void initRequestBuilder(String symbol, String... modules) {
        assert requestBuilder != null;
        requestBuilder.url(url + symbol);
        requestBuilder.urlParam("modules", String.join(COMMA, modules));
        requestBuilder.urlParam("formatted", "false");  // important! don't forget this setting when requesting modules.
    }

    public List<String> getModules() {
        return modules;
    }
}
