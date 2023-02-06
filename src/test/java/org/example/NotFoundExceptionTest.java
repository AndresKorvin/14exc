package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class NotFoundExceptionTest {
    Product book1 = new Book(2, "Азазель", 999, "Борис Акунин");
    Product book2 = new Book(3, "Капитанская дочка", 999, "Пушкин Александр");
    Product smartphone = new Smartphone(1, "Iphone X", 999, "Apple");
    Product[] products = new Product[] {book1,book2,smartphone};
    Repository repository = new Repository(products);

    @ParameterizedTest
    @CsvSource({
            "-999999", "-1", "50"
    })
    void shouldRemoveByIdIncorrectId(int id) {

        Assertions.assertThrows(NotFoundException.class, () -> {
            repository.removeById(id);
        } );
    }
}