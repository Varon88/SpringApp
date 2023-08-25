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



//    @Override
//    public Optional<Product> findProduct(int id) {
//        Optional<Product> items = DB.stream().filter(x -> x.getId() == id).findFirst();
//        return items;
//    }


//    @Override
//    public int editRecords(int id,Product product) {
//        Optional<Product> existentProduct = DB.stream().filter(x -> x.getId() == id).findFirst();
//        if(existentProduct.isPresent()) {
//            //int dbIndex = DB.indexOf(existentProduct);
//            int dbIndex = -1;
//            for(int i = 0; i <= DB.size(); i++){
//                if(existentProduct.equals(Optional.ofNullable(DB.get(i)))){
//                    dbIndex = i;
//                    break;
//                }
//            }
//            if(dbIndex >= 0){
//                DB.set(dbIndex,new Product(product.getName(), product.getPrice(), id, product.getCategory()));
//                return 1;
//            }else{
//                return 0;
//            }
//        }else{
//            return 99;
//        }
//    }

}
