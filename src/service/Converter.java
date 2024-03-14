package service;

import payload.MonthlyReport;
import payload.YearlyReport;

public class Converter {
    public static MonthlyReport converterToMonthlyObj(String line) throws Exception {
        if (!line.isEmpty()) {
            String[] splitLines = line.split(",");
            return new MonthlyReport(splitLines[0], Boolean.parseBoolean(splitLines[1]), Integer.parseInt(splitLines[2]), Integer.parseInt(splitLines[3]));

        } else {
            throw new Exception("В файле обнаружена пустая строка");
        }
    }

    public static YearlyReport converterToYearlyObj(String line) {
        try {
            String[] splitLines = new String[]{};
            if (line.isEmpty()) {
                System.out.println("В файле обнаружена пустая строка");
            } else {
                splitLines = line.split(",");
            }
            return new YearlyReport(splitLines[0], Integer.parseInt(splitLines[1]), Boolean.parseBoolean(splitLines[2]));
        } catch (Exception e) {
            System.out.println("Ошибка при считывании данных");
            return null;
        }
    }
}
