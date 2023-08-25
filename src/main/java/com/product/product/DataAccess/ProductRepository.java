package com.product.product.DataAccess;

import com.product.product.Model.Product;

import java.util.List;
import java.util.Optional;
import java.util.Random;

public interface ProductRepository {

    //Add products with and without ids.
    boolean insertProductDetails(Product product);

    //Retrieval of all products present withing the database
    List<Product> getAllProducts();


}
