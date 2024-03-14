package exceptions;

public class NullObjectException extends Exception {
    private static final String  DEFAULT_MESSAGE = "Обнаружена ошибка в объекте, проверьте значения полей объекта на null";
    public NullObjectException(){
        super(DEFAULT_MESSAGE);
    }
}
