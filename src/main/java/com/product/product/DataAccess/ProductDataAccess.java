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
        Optional<Product> items = DB.stream().filter(x -> x.getId() == id).findFirst();
        return items;
    }


    @Override
    public int editRecords(int id,Product product) {
        Optional<Product> existentProduct = DB.stream().filter(x -> x.getId() == id).findFirst();
        if(existentProduct.isPresent()) {
            //int dbIndex = DB.indexOf(existentProduct);
            int dbIndex = -1;
            for(int i = 0; i <= DB.size(); i++){
                if(existentProduct.equals(Optional.ofNullable(DB.get(i)))){
                    dbIndex = i;
                    break;
                }
            }
            if(dbIndex >= 0){
                DB.set(dbIndex,new Product(product.getName(), product.getPrice(), id, product.getCategory()));
                return 1;
            }else{
                return 0;
            }
        }else{
            return 99;
        }
    }

}
//  Optional<Product> product1 = DB.stream().filter(x -> x.getId() == id).findAny();
//        if (product1.isPresent()) {
//            product1
//                .map(p -> {
//                    int index = DB.indexOf(p);
//                    if (index >= 0) {
//                        //DB.set(index, new Product(product.getName(), product.getPrice(), id, product.getCategory()));
//                        return 1;
//                    } else {
//                        return 0;
//                    }
//                });}
//        return 0;
//        }

//    @Override
//    public int editRecords(int id,Product product) {
//        return findProduct(id)
//                .map(p -> {
//                    int index = DB.indexOf(p);
//                    if(index >= 0){
//                        DB.set(index, new Product(product.getName(), product.getPrice(), id, product.getCategory()));
//                        return 1;
//                    }else{
//                        return 0;
//                    }
//                })
//                .orElse(0);
//
//    }

//            Optional<Product> record = findProduct(id);
//            if(record.isPresent()){
//            Product existingProduct = record.get();
//            int index = DB.indexOf(existingProduct);
//
//            if(index >= 0){
//                DB.set(index, new Product(product.getName(), product.getPrice(), id, product.getCategory()));
//                return 1;
//            }
//        }
//        return 0;


//  return record.map(p -> {
//          int index = DB.indexOf(p);
//          if (record.isPresent()) {
//          DB.set(index, new Product(product.getName(), product.getPrice(), id, product.getCategory()));
//          return 1;
//          } else {
//          return 0;
//          }
//          }).orElse(0);
//
//          }


//        int index = DB.indexOf(record);
//        if(record.isEmpty()){
//            return false;
//        } else{
//            DB.set(index, new Product(product.getName(), product.getPrice(), id, product.getCategory()));
//            return true;
//        }