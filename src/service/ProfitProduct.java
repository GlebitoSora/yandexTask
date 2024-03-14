package service;

import exceptions.NullObjectException;
import payload.MonthlyReport;
import payload.YearlyReport;
import java.util.List;

public final class ProfitProduct {
    public static  MonthlyReport checkProfitProduct(List<MonthlyReport> monthlyReports) {
        MonthlyReport mostProfitItem = null;
        int maxProfit = Integer.MIN_VALUE;
        for (MonthlyReport monthlyReport : monthlyReports) {
            try {
                if (monthlyReport == null) {
                    throw new NullObjectException();
                } else {
                    if (!monthlyReport.isExpense()) {
                        int profit = monthlyReport.getQuantity() * monthlyReport.getUnitPrice();
                        if (profit > maxProfit) {
                            maxProfit = profit;
                            mostProfitItem = monthlyReport;
                        }
                    }
                }
            } catch (NullObjectException e) {
                System.out.println(e.getMessage());
            }
        }
        return mostProfitItem;
    }

    public static MonthlyReport checkSpendingProduct(List<MonthlyReport> monthlyReports) {
        MonthlyReport mostSpendingItem = null;
        int biggestWaste = Integer.MIN_VALUE;
        for (MonthlyReport monthlyReport : monthlyReports) {
            try {
                if (monthlyReport == null) {
                    throw new NullObjectException();
                } else {
                    if (monthlyReport.isExpense()) {
                        int waste = monthlyReport.getQuantity() * monthlyReport.getUnitPrice();
                        if (waste > biggestWaste) {
                            biggestWaste = waste;
                            mostSpendingItem = monthlyReport;
                        }
                    }
                }
            } catch (NullObjectException e) {
                System.out.println(e.getMessage());
            }

        }
        return mostSpendingItem;
    }

    public static int averageProfitSum(List<YearlyReport> yearlyReports) {
        for (YearlyReport yearlyReport : yearlyReports) {
            try {
                if (yearlyReport == null) {
                    throw new NullObjectException();
                } else {
                    if (yearlyReport.isExpense()) {
                        yearlyReport.checkAverageProfitSum();
                    }
                }
            } catch (NullObjectException e) {
                System.out.println(e.getMessage());
            }

        }
        return YearlyReport.averageProfitSumCounter / yearlyReports.size();
    }

    public static int averageSpendingSum(List<YearlyReport> yearlyReports) {

        for (YearlyReport yearlyReport : yearlyReports) {
            try {
                if (yearlyReport == null) {
                    throw new NullObjectException();
                } else {
                    if (!yearlyReport.isExpense()) {
                        yearlyReport.checkAverageSpendingSum();
                    }
                }
            } catch (NullObjectException e) {
                System.out.println(e.getMessage());
            }
        }
        return YearlyReport.averageSpendingSumCounter / yearlyReports.size();
    }
}
