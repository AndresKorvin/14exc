package org.example;

public class Repository {
    private Product[] products = new Product[0];
    protected Repository(Product[] products) {
        this.products = products;
    }

    protected Product[] findAll() {
        return products;
    }

    protected void saveProduct(Product product) {
        Product[]  tmp = new Product[products.length + 1];
        int cnt = 0;
        for (Product prod: products
             ) {
            tmp[cnt] = prod;
            cnt++;
        }
        tmp[tmp.length - 1] = product;
        products = tmp;
    }

    protected void removeById(int idProduct){
        Product prod = findById(idProduct);
        if (prod == null) {
            throw new NotFoundException (
                    "Element with id: " + idProduct + " not found"
            );
        }
        Product[] tmp = new Product[products.length - 1];
        int cnt = 0;
        for (Product product: products
             ) {
            if (product.getId() != idProduct) {
                tmp[cnt] = product;
                cnt++;
            }
        }
        products = tmp;
    }

    protected Product findById(int id) {
        for (Product prod :
                products) {
            if (id == prod.getId()) return prod;
        } return null;
    }
}
