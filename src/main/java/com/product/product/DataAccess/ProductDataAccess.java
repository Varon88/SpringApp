package com.product.product.DataAccess;

import com.product.product.Model.Product;
import com.product.product.dto.DB;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("Main")
public class ProductDataAccess implements ProductRepository{

    //Creation of a mock database using a list
    List<Product> db = new DB().getDB();

    @Override
    public boolean insertProductDetails(Product product) {
        db.add(product);
        return true;
    }

    @Override
    public List<Product> getAllProducts() {
        return db;
    }



}
