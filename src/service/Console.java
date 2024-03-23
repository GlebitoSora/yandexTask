package service;

import payload.MonthlyReport;
import payload.YearlyReport;

import java.text.ParseException;
import java.time.LocalDate;
import java.util.*;

public class Console {
    private static final Map<String, List<MonthlyReport>> mapOfMonthlyReports = new HashMap<>();
    private static final Map<Integer, List<YearlyReport>> mapOfYearlyReports = new HashMap<>();

    public static void consoleView() throws ParseException {
        Scanner scanner = new Scanner(System.in);
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
                    List<String> read = FileReader.readFileContents(filename);
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
                    filename = "y." +filenameScanner.nextLine() + ".csv";
                    List<YearlyReport> yearlyReports = new ArrayList<>();
                    List<String> read =  FileReader.readFileContents(filename);
                    for (int i = 1; i < read.size(); i++) {
                        try{
                            yearlyReports.add(Converter.converterToYearlyObj(read.get(i)));
                        }catch (Exception e){
                            System.out.println("В файле существует невалидная строка №" + i);
                        }
                    }
                    int year = Integer.parseInt(filename.substring(2,6));
                    mapOfYearlyReports.put(year, yearlyReports);
                    printMenu();
                }
                case 3 -> {
                    OutputObject.outputMonths(mapOfMonthlyReports);
                    printMenu();
                }
                case 4 -> {
                    OutputObject.outputYears(mapOfYearlyReports);
                    printMenu();
                }
                case 5 -> {
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
        System.out.println("3. Вывести информацию обо всех месячных отчетах ");
        System.out.println("4. Вывести информацию о годовом отчете");
        System.out.println("5. Выход");
    }
}
