import payload.MonthlyReport;
import payload.YearlyReport;
import service.Converter;
import service.ConvertorMonth;
import service.FileReader;
import service.ProfitProduct;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Main {
    private static final Map<String, List<MonthlyReport>> mapOfMonthlyReports = new HashMap<>();
    private static final Map<Integer, List<YearlyReport>> mapOfYearlyReports = new HashMap<>();

    public static void main(String[] args) throws ParseException {
        Scanner scanner = new Scanner(System.in);
        FileReader fileReader = new FileReader();
        Scanner filenameScanner = new Scanner(System.in);
        printMenu();
        POINT:
        while (true) {
            String filename;
            switch (scanner.nextInt()) {
                case 1 -> {
                    System.out.println("Введите год и месяц желаемого отчета");
                    filename = "m." + filenameScanner.nextLine() + ".csv";
                    List<MonthlyReport> monthlyReports = new ArrayList<>();
                    List<String> read = fileReader.readFileContents(filename);
                    for (int i = 1; i < read.size(); i++) {
                        try {
                            monthlyReports.add(Converter.converterToMonthlyObj(read.get(i)));
                        } catch (Exception e) {
                            System.out.println("В файле существует невалидная строка №" + i);
                        }
                    }
                    int monthNumber = Integer.parseInt(filename.substring(6, 8));
                    mapOfMonthlyReports.put(ConvertorMonth.convert(monthNumber), monthlyReports);
                    printMenu();
                }
                case 2 -> {
                    System.out.println("Введите название файла годового отчета");
                    filename = filenameScanner.nextLine();
                    ArrayList<YearlyReport> yearlyReports = new ArrayList<>();
                    int year = Integer.parseInt(filename.substring(2, 6));
                    for (int i = 1; i < fileReader.readFileContents(filename).size(); i++) {
                        yearlyReports.add(Converter.converterToYearlyObj(fileReader.readFileContents(filename).get(i)));
                    }
                    mapOfYearlyReports.put(year, yearlyReports);
                }
                case 3 -> System.out.println("Тут пока пусто");
                case 4 -> {
                    if (mapOfMonthlyReports.isEmpty()) {
                        System.out.println("Чтобы вывести информацию, нужно считать данные");
                    } else {
                        for (String reports : mapOfMonthlyReports.keySet()) {
                            MonthlyReport mostProfitItem = ProfitProduct.checkProfitProduct(mapOfMonthlyReports.get(reports));
                            MonthlyReport mostSpendingItem = ProfitProduct.checkSpendingProduct(mapOfMonthlyReports.get(reports));
                            System.out.println(reports + '\n' + mostProfitItem + '\n' + mostSpendingItem);
                        }
                    }
                }
                case 5 -> {
                    if (mapOfYearlyReports.isEmpty()) {
                        System.out.println("Чтобы вывести информацию, нужно считать данные");
                    } else {
                        for (Integer reports : mapOfYearlyReports.keySet()) {
                            int averageProfitProduct = ProfitProduct.averageProfitSum(mapOfYearlyReports.get(reports));
                            int averageSpendingProduct = ProfitProduct.averageSpendingSum(mapOfYearlyReports.get(reports));
                            System.out.printf("%d\n%d\n%d", reports, averageProfitProduct, averageSpendingProduct);
                        }
                    }
                }
                case 6 -> {
                    System.out.println("Выход...");
                    break POINT;
                }
                default -> System.out.println("Некорректный ввод. Пожалуйста, выберите существующую опцию.");
            }
        }
        scanner.close();
        filenameScanner.close();
    }

    private static void printMenu() {
        System.out.println("Выберите действие:");
        System.out.println("1. Считать месячный отчет");
        System.out.println("2. Считывать годовой отчет");
        System.out.println("3. Сверить отчеты");
        System.out.println("4. Вывести информацию обо всех месячных отчетах ");
        System.out.println("5. Вывести информацию о годовом отчете");
        System.out.println("6. Выход");
    }
    private static void checkFileName(String fileName){
        if (fileName.length()!=6){

        }
    }
}

