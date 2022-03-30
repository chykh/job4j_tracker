package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Класс описывает банковский сервис, который может быть оказан клиенту
 */
public class BankService {
    private final Map<User, List<Account>> users = new HashMap<>();

    /**
     * Метод позволяет добавить нового пользователя в систему и создать для него
     * список будущих аккаунтов
     * @param user принимает в качестве параметра ссылку на объект типа User
     */
    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<Account>());
    }

    /**
     * Метод позволяет добавить к данному пользователю новый аккаунт
     * @param passport данные о паспорте пользователя
     * @param account данные о паспорте пользователя
     */
    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        if (user != null) {
            List<Account> accounts = users.get(user);
            if (!accounts.contains(account)) {
                accounts.add(account);
            }
        }
    }

    /**
     * Метод позволяет определить пользователя по паспорту
     * @param passport данные о паспорте пользователя
     * @return Возвращает ссылку на объект User искомого пользователя
     */
    public User findByPassport(String passport) {
        for (User user : users.keySet()) {
            if (passport.equals(user.getPassport())) {
                return user;
            }
        }
        return null;
    }

    /**
     * Метод позволяет определить аккаунт пользователя по его паспорту и реквизитам
     * @param passport данные о паспорте пользователя
     * @param requisite данные о реквизитах пользователя
     * @return Возвращает аккаунт пользователя, соответствующим его реквизитам
     */
    public Account findByRequisite(String passport, String requisite) {
        User user = findByPassport(passport);
        if (user != null) {
            List<Account> accounts = users.get(user);
            for (Account account : accounts) {
                if (requisite.equals(account.getRequisite())) {
                    return account;
                }
            }
        }
        return null;
    }

    /**
     * Метод позволяет выполнить перевод денег между двумя пользователями,
     * убедившись, что денежных средств на счету плательщика достаточно
     * @param srcPassport данные о паспорте плательщика перевода
     * @param srcRequisite данные о реквизитах плательщика перевода
     * @param destPassport данные о паспорте получателя перевода
     * @param destRequisite данные о реквизитах получателя перевода
     * @param amount данные о сумме перевода
     * @return Возвращает булево значение о результате перевода (true - положительный исход)
     */
    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite,
                                 double amount) {
        boolean done = false;
        Account scrAccount = findByRequisite(srcPassport, srcRequisite);
        Account destAccount = findByRequisite(destPassport, destRequisite);

        if (scrAccount != null && destAccount != null && scrAccount.getBalance() >= amount) {
            scrAccount.setBalance(scrAccount.getBalance() - amount);
            destAccount.setBalance(destAccount.getBalance() + amount);
            done = true;
        }
        return done;
    }
}