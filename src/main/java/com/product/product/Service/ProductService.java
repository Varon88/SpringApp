package com.product.product.Service;

import com.product.product.DataAccess.ProductDataAccess;
import com.product.product.Model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    public final ProductDataAccess productDataAccess;

    @Autowired
    public ProductService(@Qualifier("Main") ProductDataAccess productDataAccess) {
        this.productDataAccess = productDataAccess;
    }

    public boolean productAddition(Product product){
        return productDataAccess.insertProductDetails(product);
    }

    public List<Product> printProducts(){
        return productDataAccess.getAllProducts();
    }

    public List<Product> printByCategory(String category){
        return productDataAccess.printByCategory(category);
    }

    public Optional<Product> sourceProduct(int id){
        return productDataAccess.findProduct(id);
    }

    public int editProduct(int id, Product product){
        return productDataAccess.editRecords(id,product);
    }
}
