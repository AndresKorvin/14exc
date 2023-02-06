package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RepositoryTest {

    Product book1 = new Book(2, "Азазель", 999, "Борис Акунин");
    Product book2 = new Book(3, "Капитанская дочка", 999, "Пушкин Александр");
    Product smartphone = new Smartphone(1, "Iphone X", 999, "Apple");
    Product[] products = new Product[] {book1,book2};
    Repository repository = new Repository(products);

    @Test
    void findAll() {
        Product[] expected = repository.findAll();
        Product[] actual = {book1,book2};

        assertArrayEquals(expected, actual);
    }

    @Test
    void saveProduct() {
        repository.saveProduct(smartphone);

        Product[] expected = {book1,book2,smartphone};
        Product[] actual = repository.findAll();

        assertArrayEquals(expected, actual);
    }

    @Test
    void delProduct() {
        repository.removeById(2);

        Product[] expected = {book2};
        Product[] actual = repository.findAll();

        assertArrayEquals(expected, actual);
    }
}