package ru.job4j.bank;

import java.util.Objects;

/**
 * Класс описывает модель данных типа Account
 */
public class Account {
    /**
     * содержит реквизиты данного аккаунта
     */
    private String requisite;
    /**
     * содержит баланс данного аккаунта
     */
    private double balance;

    public Account(String requisite, double balance) {
        this.requisite = requisite;
        this.balance = balance;
    }

    /**
     * Метод позволяет получить реквизиты данного аккаунта
     * @return Возвращает значение поля requisite
     */
    public String getRequisite() {
        return requisite;
    }

    /**
     * Метод присваивает полю класса requisite значение из параметра
     * @param requisite реквизиты, которые мы хотим установить
     */
    public void setRequisite(String requisite) {
        this.requisite = requisite;
    }

    /**
     * Метод позволяет получить поля balance
     * @return Возвращает значение поля balance
     */
    public double getBalance() {
        return balance;
    }

    /**
     * Метод позволяет установить баланс для данного Аккаунта
     * @param balance  значение из параметра balance, которое мы хотим установить
     */
    public void setBalance(double balance) {
        this.balance = balance;
    }

    /**
     * Метод позволяет проверить равенство двух объектов
     * @param o ссылка на объект, который мы хотим сравнить с текущим объектом
     * @return Возвращает булево значение о равенстве объекта из параметра текущему объекту
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Account account = (Account) o;
        return Objects.equals(requisite, account.requisite);
    }

    /**
     * Метод позволяет вернуть хэшкод данного объекта
     * @return Возвращает хэшкод
     */
    @Override
    public int hashCode() {
        return Objects.hash(requisite);
    }
}
