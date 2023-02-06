package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ManagerTest {
    Product book1 = new Book(2, "Азазель", 600, "Борис Акунин");
    Product book2 = new Book(3, "Капитанская дочка", 800, "Александр Пушкин");
    Product book3 = new Book(4, "Капитанский орден", 500, "Неизвестный");

    Product smartphone = new Smartphone(1, "Iphone X", 999, "Apple");

    Product[] products = new Product[]{book1, book2};
    Repository repository = new Repository(products);
    Manager manager = new Manager(repository);

    @Test
    void add() {
        manager.add(smartphone);

        Product[] expected = {book1, book2, smartphone};
        Product[] actual = repository.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    void searchBy1() {
        Product[] actual = manager.searchBy("апитан");
        Product[] expected = {book2};

        Assertions.assertArrayEquals(expected, actual);
    }
    @Test
    void searchBy2() {
        manager.add(book3);

        Product[] actual = manager.searchBy("апитан");
        Product[] expected = {book2, book3};

        Assertions.assertArrayEquals(expected, actual);
    }
    @Test
    void searchByNone() {
        Product[] actual = manager.searchBy("фаренгейт");
        Product[] expected = {};

        Assertions.assertArrayEquals(expected, actual);
    }

/*    @Test
    void matches() {
    }*/
}