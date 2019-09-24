package ru.job4j.pojo;

public class Library {
    public static void main(String[] args) {
        Book book1 = new Book("book1", 50);
        Book book2 = new Book("book2", 53);
        Book book3 = new Book("Clean code", 42);
        Book book4 = new Book("book4", 89);

        Book[] books = {book1, book2, book3, book4};
        for (int index = 0; index < books.length; index++) {
            System.out.println(books[index].getName() + " " + books[index].getCount() + "стр.");
        }

        System.out.println();

        Book tmp = books[0];
        books[0] = books[3];
        books[3] = tmp;

        for (int index = 0; index < books.length; index++) {
            System.out.println(books[index].getName() + " " + books[index].getCount() + "стр.");
        }

        System.out.println();

        for (int index = 0; index < books.length; index++) {
            if (books[index].getName().equals("Clean code")) {
                System.out.println(books[index].getName() + " " + books[index].getCount() + "стр.");
            }
        }

    }
}
