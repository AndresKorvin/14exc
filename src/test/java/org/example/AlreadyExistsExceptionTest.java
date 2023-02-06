package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class AlreadyExistsExceptionTest {
    Product book1 = new Book(2, "Азазель", 999, "Борис Акунин");
    Product book2 = new Book(3, "Капитанская дочка", 999, "Пушкин Александр");
    Product smartphone1 = new Smartphone(1, "Iphone X", 999, "Apple");

    Product[] products = new Product[] {book1,book2,smartphone1};
    Repository repository = new Repository(products);

    @Test
    void shouldNotSaveProduct () {

        Assertions.assertThrows(AlreadyExistsException.class, () -> {
            repository.saveProduct(smartphone1);
        });
    }

}