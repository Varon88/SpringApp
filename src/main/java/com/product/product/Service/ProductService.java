package com.product.product.Service;

import com.product.product.DataAccess.ProductDataAccess;
import com.product.product.Model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductService implements ServiceImplementation {

    public final ProductDataAccess productDataAccess;


    @Autowired
    public ProductService(@Qualifier("Main") ProductDataAccess productDataAccess) {
        this.productDataAccess = productDataAccess;
    }

//    public boolean productAddition(Product product){
//        return productDataAccess.insertProductDetails(product);
//    }
    @Override
    public boolean addObjects(int id, Product product) {
        return productDataAccess.insertProductDetails(new Product(product.getName(),product.getPrice(),id,product.getCategory()));
    }

    @Override
    public List<Product> getProducts(){
        return productDataAccess.getAllProducts();
    }

    @Override
    public List<Product> getByCategory(String category) {
        List<Product> db = productDataAccess.getAllProducts();
        return db.stream()
                .filter(x -> x.getCategory().equals(category))
                .collect(Collectors.toList());
    }


//    public List<Product> printByCategory(String category){
//        return productDataAccess.printByCategory(category);
//  }

    @Override
    public Optional<Product> sourceProduct(int id){
       return productDataAccess.getAllProducts().stream().filter(x->x.getId() == id).findFirst();
    }

    @Override
    public void editProducts(int id, Product product) {
        Optional<Product> product1 = sourceProduct(id);
        if(product1.isPresent()) {
            //int dbIndex = DB.indexOf(existentProduct);
            int dbIndex = -1;
            for(int i = 0; i <= productDataAccess.getAllProducts().size(); i++){
                if(product1.equals(Optional.ofNullable(productDataAccess.getAllProducts().get(i)))){
                    dbIndex = i;
                    break;
                }
            }
            if(dbIndex >= 0) {
                productDataAccess.getAllProducts().set(dbIndex, new Product(product.getName(), product.getPrice(), id, product.getCategory()));
            }
        }
    }




}
