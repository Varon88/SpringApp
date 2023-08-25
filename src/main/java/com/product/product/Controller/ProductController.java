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
        return productService.addObjects(product);
    }

    @GetMapping("/all")
    public List<Product> printAllProducts(){
        return productService.getProducts();
    }


    @GetMapping(path = "/category={category}")
    public List<Product> printAllByCategory(@PathVariable("category")  String category){
        return productService.getByCategory(category);
    }

    @GetMapping(path = "/id={id}")
    public Optional<Product> sourceProduct(@PathVariable("id") int id){
        return productService.sourceProduct(id);
    }


    @PutMapping(path = "{id}")
    public void editRecords(@PathVariable("id") int id, @RequestBody Product product){
         productService.editProducts(id,product);
    }
}

