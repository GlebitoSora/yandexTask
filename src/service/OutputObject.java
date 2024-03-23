package service;

import payload.MonthlyReport;
import payload.YearlyReport;
import java.util.List;
import java.util.Map;

public class OutputObject {
    public static void outputMonths(Map<String, List<MonthlyReport>> mapOfMonthlyReports){
        if (mapOfMonthlyReports.isEmpty()) {
            System.out.println("Чтобы вывести информацию, нужно считать данные");
        } else {
            for (String reports : mapOfMonthlyReports.keySet()) {
                MonthlyReport mostProfitItem = ProfitProduct.checkProfitProduct(mapOfMonthlyReports.get(reports));
                MonthlyReport mostSpendingItem = ProfitProduct.checkSpendingProduct(mapOfMonthlyReports.get(reports));
                System.out.printf("""
                                ---------------
                                Месяц: %s
                                Самый прибыльный товар: %s
                                Количество продаж: %d
                                Сумма(за единицу товара): %d
                                Самый затратный товар: %s
                                Количество продаж: %d
                                Сумма(за единицу товара): %d
                                """,
                        reports, mostProfitItem.getItemName(),mostProfitItem.getQuantity(),
                        mostProfitItem.getUnitPrice(),mostSpendingItem.getItemName(),
                        mostSpendingItem.getQuantity(), mostSpendingItem.getUnitPrice() );

            }
        }
    }
    public static void outputYears(Map<Integer, List<YearlyReport>> mapOfYearlyReports){
        if (mapOfYearlyReports.isEmpty()) {
            System.out.println("Чтобы вывести информацию, нужно считать данные");
        } else {
            for (Integer reports : mapOfYearlyReports.keySet()) {
                int averageProfitProduct = ProfitProduct.averageProfitSum(mapOfYearlyReports.get(reports));
                int averageSpendingProduct = ProfitProduct.averageSpendingSum(mapOfYearlyReports.get(reports));
                System.out.printf("""
                                ---------------
                                Год: %s
                                Средняя прибыль за год: %d
                                Средние траты за год: %d
                                """,
                        reports, averageProfitProduct, averageSpendingProduct);
            }
        }
    }
}
