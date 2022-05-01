package ru.job4j.bank;

import java.util.*;

public class BankService {
    private final Map<User, List<Account>> users = new HashMap<>();

    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<Account>());
    }

     public void addAccount(String passport, Account account) {
         if (findByPassport(passport).isEmpty()) {
             return;
         }
        User user = findByPassport(passport).get();
            List<Account> accounts = users.get(user);
            if (!accounts.contains(account)) {
                accounts.add(account);
            }
     }

    public Optional<User> findByPassport(String passport) {
        return users.keySet().stream()
                .filter(user -> user.getPassport().equals(passport))
                .findFirst();
    }

    public Optional<Account> findByRequisite(String passport, String requisite) {
        if (findByPassport(passport).isEmpty()) {
            return Optional.empty();
        }
        User user = findByPassport(passport).get();
        List<Account> accounts = users.get(user);
        return accounts.stream()
            .filter(acc -> requisite.equals(acc.getRequisite()))
            .findFirst();
    }

    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite,
                                 double amount) {
        boolean done = false;
        if (findByRequisite(srcPassport, srcRequisite).isEmpty()
                || findByRequisite(destPassport, destRequisite).isEmpty()) {
            return false;
        }
        Account scrAccount = findByRequisite(srcPassport, srcRequisite).get();
        Account destAccount = findByRequisite(destPassport, destRequisite).get();

        if (scrAccount.getBalance() >= amount) {
            scrAccount.setBalance(scrAccount.getBalance() - amount);
            destAccount.setBalance(destAccount.getBalance() + amount);
            done = true;
        }
        return done;
    }

}