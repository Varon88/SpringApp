package com.product.product.DataAccess;

import com.product.product.Model.Product;

import java.util.List;
import java.util.Optional;
import java.util.Random;

public interface ProductRepository {

    //Add products with and without ids.
    boolean insertProductDetails(int id, Product product);

    default boolean insertProductDetails(Product product){
        Random idCreate = new Random(50000);
        return insertProductDetails(idCreate.nextInt(),product);
    }

    //Retrieval of all products present withing the database
    List<Product> getAllProducts();

    //print product by category
    Optional<Product> printByCategory(String category);

    //find a product
    Optional<Product> findProduct(int id);

    boolean editRecords(int id,Product product);
}
