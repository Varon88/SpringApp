package com.product.product.Controller;

import com.product.product.Model.Product;
import com.product.product.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("Controller/vx/product")
public class ProductController {

    public final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    public boolean productAddition(Product product){
        return productService.productAddition(product);
    }

    @GetMapping
    public List<Product> printAllProducts(){
        return productService.printProducts();
    }


    @GetMapping
    public Optional<Product> printAllByCategory(@RequestParam String category){
        return productService.printByCategory(category);
    }

    @PutMapping(path = "{id}")
    public  boolean editRecords(@PathVariable("id") int id, Product product){
        return productService.editProduct(id,product);
    }
}

