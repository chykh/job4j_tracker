package ru.job4j.bank;

import java.util.Objects;

/**
 * Класс содержит модель данных типа User
 */
public class User {
    /**
     * Поле содержит информацию об паспорте пользователя
     */
    private String passport;
    /**
     * Поле содержит информацию об ФИО пользователя
     */
    private String username;

    public User(String passport, String username) {
        this.passport = passport;
        this.username = username;
    }

    /**
     * Позволяет получить информацию о паспорте данного пользователя
     * @return Возвращает значение поля passport
     */
    public String getPassport() {
        return passport;
    }

    /**
     * Метод позволяет присвоить данному пользователю информацию об его паспорте
     * @param passport Принимает значение параметра passport
     */
    public void setPassport(String passport) {
        this.passport = passport;
    }

    /**
     * Метод позволяет получить информацию о ФИО пользователя
     * @return Возвращает значение параметра username
     */
    public String getUsername() {
        return username;
    }

    /**
     * Метод позволяет присвоить информацию о ФИО данному пользователю
     * @param username Принимает значение параметра username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Метод позволяет проверить идентичность двух объектов типа User
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
        User user = (User) o;
        return Objects.equals(passport, user.passport);
    }

    /**
     * Метод позволяет вернуть хэшкод данного объекта
     * @return Возвращает хэшкод
     */
    @Override
    public int hashCode() {
        return Objects.hash(passport, username);
    }
}
