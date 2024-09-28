package org.mirror.DTO.quoteSummary.moduleInfo.incomeStatementHistory;


import lombok.Data;
import org.mirror.DTO.quoteSummary.moduleInfo._common.FormattedData;

@Data
// TODO: All variables of type Object must be reviewed.
public class IncomeStatementHistoryInner {
    private Integer maxAge;
    private FormattedData endDate;
    private FormattedData totalRevenue;
    private FormattedData costOfRevenue;
    private FormattedData grossProfit;
    private Object researchDevelopment;
    private Object sellingGeneralAdministrative;
    private Object nonRecurring;
    private Object otherOperatingExpenses;
    private FormattedData  totalOperatingExpenses;
    private Object operatingIncome;
    private Object totalOtherIncomeExpenseNet;
    private FormattedData ebit;
    private Object interestExpense;
    private Object incomeBeforeTax;
    private FormattedData incomeTaxExpense;
    private Object minorityInterest;
    private Object netIncomeFromContinuingOps;
    private Object discontinuedOperations;
    private Object extraordinaryItems;
    private Object effectOfAccountingCharges;
    private Object otherItems;
    private FormattedData netIncome;
    private Object netIncomeApplicableToCommonShares;
}
