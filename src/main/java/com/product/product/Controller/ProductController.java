package com.product.product.Controller;

import com.product.product.Model.Product;
import com.product.product.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping("Controller/vx/product")
@RestController

public class ProductController {

    public final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    public boolean productAddition(@RequestBody Product product){
        return productService.productAddition(product);
    }

    @GetMapping("/all")
    public List<Product> printAllProducts(){
        return productService.printProducts();
    }


    @GetMapping(path = "{category}")
    public List<Product> printAllByCategory(@PathVariable("category")  String category){
        return productService.printByCategory(category);
    }

    @PutMapping(path = "{id}")
    public  boolean editRecords(@PathVariable("id") int id, @RequestBody Product product){
        return productService.editProduct(id,product);
    }
}

