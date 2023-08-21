package com.product.product.DataAccess;

import com.product.product.Model.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository("Main")
public class ProductDataAccess implements ProductRepository{

    //Creation of a mock database using a list
    List<Product> DB = new ArrayList<>();

    @Override
    public boolean insertProductDetails(int id, Product product) {
        DB.add(new Product(product.getName(), product.getPrice(),id, product.getCategory()));
        return true;
    }

    @Override
    public List<Product> getAllProducts() {
        return DB;
    }

    @Override
    public List<Product> printByCategory(String category) {
        List<Product> items = DB.stream().filter(x -> x.getCategory().equals(category)).collect(Collectors.toList());
        return items;
    }

    @Override
    public Optional<Product> findProduct(int id) {
        return DB.stream().filter(x -> x.getCategory().equals(id)).findFirst();
    }

    @Override
    public boolean editRecords(int id,Product product) {
        Optional<Product> record = findProduct(id);
        int index = DB.indexOf(record);
        if(record.isEmpty()){
            return false;
        } else{
            DB.set(index, new Product(product.getName(), product.getPrice(), id, product.getCategory()));
            return true;
        }
    }

}
