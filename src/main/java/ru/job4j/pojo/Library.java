package ru.job4j.pojo;
public class Library {
    public static void main(String[] args) {
        Book book1 = new Book("Maugli", 25);
        Book book2 = new Book("Skazki", 60);
        Book book3 = new Book("Clean code", 14);
        Book book4 = new Book("Rezepti", 90);
        Book[] books = new Book[4];
        books[0] = book1;
        books[1] = book2;
        books[2] = book3;
        books[3] = book4;

        for (int i = 0; i < books.length; i++) {
            System.out.println(books[i].getName() + " - " + books[i].getPages());
        }
        Book temp = books[0];
        books[0] = books[3];
        books[3] = temp;
        for (int i = 0; i < books.length; i++) {
            System.out.println(books[i].getName() + " - " + books[i].getPages());
        }
        for (int i = 0; i < books.length; i++) {
            temp = books[i];
            if ("Clean code".equals(temp.getName())) {
                System.out.println(temp.getName() + " - " + temp.getPages());
            }
        }

    }
}
