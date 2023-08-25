package com.product.product.Service;

import com.product.product.Model.Product;

import java.util.List;
import java.util.Optional;
import java.util.Random;

public interface ServiceImplementation {

    //Addition of elements into the database
    boolean addObjects(int id, Product product);

    //Adding in case no id is specified
    default boolean addObjects(Product product){
        Random rnd = new Random();
        return addObjects(rnd.nextInt(7800),product);
    }

    //get all records
    List<Product> getProducts();

    //get products by category
    List<Product> getByCategory(String category);

    //source product using id
    Optional<Product> sourceProduct(int id);

    //edit products
    void editProducts(int id, Product product);

}
