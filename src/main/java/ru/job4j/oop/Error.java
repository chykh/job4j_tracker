package ru.job4j.oop;

public class Error {

    private boolean active;
    private int status;
    private String message;

    public Error() {
    }

    Error(boolean active, int status, String message) {
        this.active = active;
        this.status = status;
        this.message = message;
    }

    public void show() {
        System.out.println("Активная " + active + ". Статус " + status + ". Сообщение " + message);
    }

    public static void main(String[] args) {
        Error pustaya = new Error();
        pustaya.show();
        Error pervaya = new Error(true, 1, "Ошибка воспроизыедения");
        pervaya.show();
        Error vtoraya = new Error(true, 2, "Ошибка записи");
        vtoraya.show();
        Error tretiya = new Error(false, 15, "Логическая ошибка");
        tretiya.show();
    }
}
