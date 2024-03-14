import payload.MonthlyReport;
import payload.YearlyReport;
import service.Converter;
import service.FileReader;
import service.ProfitProduct;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Main {
    public static void main(String[] args) throws ParseException {
        Scanner scanner = new Scanner(System.in);
        FileReader fileReader = new FileReader();
        Scanner filenameScanner = new Scanner(System.in);
        Converter converter = new Converter();
        Map<String, ArrayList<MonthlyReport>> mapOfMonthlyReports = new HashMap<>();
        Map<Integer, ArrayList<YearlyReport>> mapOfYearlyReports = new HashMap<>();
        boolean ifFinished = true;
        String filename;
        SimpleDateFormat monthFormat = new SimpleDateFormat("MMMM", Locale.ENGLISH);
        System.out.println("Выберите действие:");
        System.out.println("1. Считать месячный отчет");
        System.out.println("2. Считывать годовой отчет");
        System.out.println("3. Сверить отчеты");
        System.out.println("4. Вывести информацию обо всех месячных отчетах ");
        System.out.println("5. Вывести информацию о годовом отчете");
        System.out.println("exit. Выход");
        while (ifFinished) {
            switch (scanner.nextLine()) {
                case "1":
                    System.out.println("Введите название файла месячного отчета");
                    filename = filenameScanner.nextLine();
                    ArrayList<MonthlyReport> monthlyReports = new ArrayList<>();
                    int monthNumber = Integer.parseInt(filename.substring(6, 8));
                    for (int i = 1; i < fileReader.readFileContents(filename).size(); i++) {
                        monthlyReports.add(converter.converterToMonthlyObj(fileReader.readFileContents(filename).get(i)));
                    }
                    Date date = new SimpleDateFormat("MM").parse(String.format("%01d", monthNumber));
                    mapOfMonthlyReports.put(monthFormat.format(date), monthlyReports);
                    break;
                case "2":
                    System.out.println("Введите название файла годового отчета");
                    filename = filenameScanner.nextLine();
                    ArrayList<YearlyReport> yearlyReports = new ArrayList<>();
                    int year = Integer.parseInt(filename.substring(2, 6));
                    for (int i = 1; i < fileReader.readFileContents(filename).size(); i++) {
                        yearlyReports.add(converter.converterToYearlyObj(fileReader.readFileContents(filename).get(i)));
                    }
                    mapOfYearlyReports.put(year, yearlyReports);
                    break;
                case "3":
                    System.out.println("Тут пока пусто");
                    break;
                case "4":
                    if (mapOfMonthlyReports.isEmpty()) {
                        System.out.println("Чтобы вывести информацию, нужно считать данные");
                    } else {
                        MonthlyReport mostProfitItem;
                        MonthlyReport mostSpendingItem;
                        ProfitProduct product = new ProfitProduct();
                        for (String reports : mapOfMonthlyReports.keySet()) {
                            mostProfitItem = product.checkProfitProduct(mapOfMonthlyReports.get(reports));
                            mostSpendingItem = product.checkSpendingProduct(mapOfMonthlyReports.get(reports));
                            System.out.println(reports + '\n' + mostProfitItem + '\n' + mostSpendingItem);
                        }
                    }
                    break;
                case "5":
                    int averageProfitProduct;
                    int averageSpendingProduct;
                    ProfitProduct product = new ProfitProduct();
                    if (mapOfYearlyReports.isEmpty()) {
                        System.out.println("Чтобы вывести информацию, нужно считать данные");
                    } else {
                        for (Integer reports : mapOfYearlyReports.keySet()) {
                            averageProfitProduct = product.averageProfitSum(mapOfYearlyReports.get(reports));
                            averageSpendingProduct = product.averageSpendingSum(mapOfYearlyReports.get(reports));
                            System.out.printf("%d\n%d\n%d", reports, averageProfitProduct, averageSpendingProduct);
                        }
                    }
                    break;
                case "exit":
                    System.out.println("Выход...");
                    ifFinished = false;
                    break;
                default:
                    System.out.println("Некорректный ввод. Пожалуйста, выберите существующую опцию.");
            }
        }
        scanner.close();
        filenameScanner.close();
    }
}

