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
       Optional<User> rsl = Optional.empty();
       for (User user : users.keySet()) {
           if (user.getPassport().equals(passport)) {
               rsl = Optional.of(user);
               break;
           }
       }
       return rsl;
    }

    public Account findByRequisite(String passport, String requisite) {
        if (findByPassport(passport).isEmpty()) {
            return null;
        }
        User user = findByPassport(passport).get();
                    List<Account> accounts = users.get(user);
        return accounts.stream()
            .filter(acc -> requisite.equals(acc.getRequisite()))
            .findFirst().orElse(null);
    }

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

    public static void main(String[] args) {
        BankService bank = new BankService();
        bank.addUser(new User("321", "Petr Arsentev"));
        Optional<User> opt = bank.findByPassport("3211");
        if (opt.isPresent()) {
            System.out.println(opt.get().getUsername());
        }
    }

}