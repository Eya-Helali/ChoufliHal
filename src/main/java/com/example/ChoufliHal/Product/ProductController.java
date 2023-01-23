package com.example.ChoufliHal.Product;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;



@RestController
@RequestMapping("/api/v1/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    //TODO : filters inspire toi des e-commerces + système de pagination

    @GetMapping("/allProducts")
    public List<Product>  getAllProducts()
    { return productService.getAllProducts();}

    @GetMapping("{productId}")
    public Optional<Product> getProductById(@PathVariable Long productId)
    {return productService.getProductById(productId);}

    @GetMapping("/byName/{name}")
    public List<Product> getProductByName(@PathVariable String name)
    {return productService.getProductByName(name);}

    @PostMapping("/addProduct")
    public Product addProduct(@RequestBody Product product)
    {return productService.addProduct(product);}


    @PutMapping("/update/{productId}")
    public Product updateProductById(@RequestBody Product productUpdated ,@PathVariable Long productId )
    { return productService.updateProductById(productUpdated,productId);  }


    @DeleteMapping("/delete/{productId}")
    public void deleteProductById(@PathVariable Long productId){
        productService.deleteProductById (productId);
    }
    }








