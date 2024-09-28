package org.mirror.consts;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.HashSet;
import java.util.Set;


/**
 * https://query2.finance.yahoo.com/v10/finance/quoteSummary/${symbol}?modules=xxx,yyy,zzz&corsDomain=finance.yahoo.com&formatted=false
 */
public class QuoteSummaryModuleConsts {
    public static final Set<String> MODULE_SET = new HashSet<String>();


    // contains general information about the company
    public static final String SUMMARY_PROFILE = "summaryProfile";

    // prices + volume + market cap + etc
    public static final String SUMMARY_DETAIL = "summaryDetail"; 
    public static final String ASSET_PROFILE = "assetProfile";
    public static final String FUND_PROFILE = "fundProfile";

    // current prices
    public static final String PRICE = "price";

    // quoteType
    public static final String QUOTE_TYPE = "quoteType";

    // Environmental, social, and governance (ESG) scores, sustainability and ethical performance of companies
    public static final String ESG_SCORES = "esgScores";
    public static final String INCOME_STATEMENT_HISTORY = "incomeStatementHistory";
    public static final String INCOME_STATEMENT_HISTORY_QUARTERLY = "incomeStatementHistoryQuarterly"; 
    public static final String BALANCE_SHEET_HISTORY = "balanceSheetHistory";
    public static final String BALANCE_SHEET_HISTORY_QUARTERLY = "balanceSheetHistoryQuarterly";
    public static final String CASH_FLOW_STATEMENT_HISTORY = "cashFlowStatementHistory";
    public static final String CASH_FLOW_STATEMENT_HISTORY_QUARTERLY = "cashFlowStatementHistoryQuarterly";

    // KPIs (PE, enterprise value, EPS, EBITA, and more)
    public static final String DEFAULT_KEY_STATISTICS = "defaultKeyStatistics";

    // Financial KPIs (revenue, gross margins, operating cash flow, free cash flow, and more)
    public static final String FINANCIAL_DATA = "financialData";

    // future earnings date
    public static final String CALENDAR_EVENTS = "calendarEvents";

    // SEC filings, such as 10K and 10Q reports
    public static final String SEC_FILINGS = "secFilings";

    // upgrades and downgrades that analysts have given a company's stock
    public static final String UPGRADE_DOWNGRADE_HISTORY = "upgradeDowngradeHistory";

    // institutional ownership, holders and shares outstanding
    public static final String INSTITUTION_OWNERSHIP = "institutionOwnership";

    // mutual fund ownership, holders and shares outstanding
    public static final String FUND_OWNERSHIP = "fundOwnership";
    public static final String MAJOR_DIRECT_HOLDERS = "majorDirectHolders";  // I have tested several symbols, and none of them showing valid answers
    public static final String MAJOR_HOLDERS_BREAKDOWN = "majorHoldersBreakdown";

    // insider transactions, such as the number of shares bought and sold by company executives
    public static final String INSIDER_TRANSACTIONS = "insiderTransactions";

    // insider holders, such as the number of shares held by company executives
    public static final String INSIDER_HOLDERS = "insiderHolders";

    // net share purchase activity, such as the number of shares bought and sold by company executives
    public static final String NET_SHARE_PURCHASE_ACTIVITY = "netSharePurchaseActivity";

    // earnings history
    public static final String EARNINGS = "earnings";
    public static final String EARNINGS_HISTORY = "earningsHistory";

    // earnings trend
    public static final String EARNINGS_TREND = "earningsTrend";

    public static final String INDUSTRY_TREND = "industryTrend";// did not find any valid data using this module
    public static final String INDEX_TREND = "indexTrend";
    public static final String SECTOR_TREND = "sectorTrend";// did not find any valid data using this module
    public static final String RECOMMENDATION_TREND = "recommendationTrend";
    public static final String FUTURES_CHAIN = "futuresChain";// did not find any valid data using this module 


    static {
        Field[] declaredFields = QuoteSummaryModuleConsts.class.getDeclaredFields();
        for (Field field : declaredFields) {
            if (Modifier.isStatic(field.getModifiers()) && field.getType().equals(String.class)) {
                try {
                    MODULE_SET.add((String) field.get(null));
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}