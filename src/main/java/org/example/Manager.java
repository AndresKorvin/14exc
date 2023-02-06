package org.example;
public class Manager {
    Repository repository;
    protected Manager(Repository repository) {
        this.repository = repository;
    }
    public void add(Product product) {
        repository.saveProduct(product);
    }

    public Product[] searchBy(String text) {
        Product[] result = new Product[0]; // тут будем хранить подошедшие запросу продукты
        for (Product product : repository.findAll()) {
            if (matches(product, text)) {

                if (result.length == 0) {
                    result = new Product[1];
                    result[0] = product;

                } else {
                    Product[] tmp = new Product[result.length + 1];
                    for (int i = 0; i < result.length; i++) {
                        tmp[i] = result[i];
                    }
                    tmp[tmp.length - 1] = product;
                    result = tmp;
                }
            }
        }
        return result;
    }

    // метод определения соответствия товара product запросу search
    public boolean matches(Product product, String search) {
        if (product.getName().contains(search)) {
            return true;
        } else {
            return false;
        }
    }
}