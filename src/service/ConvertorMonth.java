package service;

public class ConvertorMonth {
    public static String convert(int month) {
        switch (month) {
            case 1 -> {
                return "Январь";
            }
            case 2 -> {
                return "Февраль";
            }
            case 3 -> {
                return "Март";
            }
            default -> {
                return "Жопа";
            }
        }
    }
}
