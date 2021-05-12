package com.springrest.springrest;

import com.springrest.springrest.entities.Product;
import com.springrest.springrest.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class ProductServiceController {
    @Autowired
    private ProductService productService;

  /*  private static List<Product> productRepo = new ArrayList<>();

    @RequestMapping(value = "/products/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> delete(@PathVariable("id") String id) {
        productRepo.remove(id);
        return new ResponseEntity<>("Product is deleted successsfully", HttpStatus.OK);
    }

    @RequestMapping(value = "/products/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Object> updateProduct(@PathVariable("id") String id, @RequestBody Product product) {
        productRepo.remove(id);
        product.setId(id);
        productRepo.add(product);
        return new ResponseEntity<>("Product is updated successsfully", HttpStatus.OK);
    }

    *//*@RequestMapping(value = "/products", method = RequestMethod.POST)
    public ResponseEntity<Object> createProduct(@RequestBody Product product) {
        productRepo.put(product.getId(), product);
        return new ResponseEntity<>("Product is created successfully", HttpStatus.CREATED);
    }*/



    @RequestMapping(value = "/products", method = RequestMethod.GET)
    public ResponseEntity<Object> getProducts() {
        return new ResponseEntity<>(this.productService.getProducts(), HttpStatus.OK);
    }

    @RequestMapping(value = "/products/{productId}", method = RequestMethod.GET)
    public ResponseEntity<Object> getProduct(@PathVariable String productId){
        return new ResponseEntity<>(this.productService.getProduct(productId), HttpStatus.OK);
    }

    @RequestMapping(value = "/products", method = RequestMethod.POST)
    public ResponseEntity<Object> addProduct(@RequestBody Product product){
        return new ResponseEntity<>(this.productService.addProduct(product), HttpStatus.OK);
    }

    @RequestMapping(value = "/products", method = RequestMethod.PUT)
    public ResponseEntity<Object> updateProduct(@RequestBody Product product){
        return new ResponseEntity<>(this.productService.updateProduct(product), HttpStatus.OK);
    }

    @RequestMapping(value = "/products/{productId}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> deleteProduct(@PathVariable String productId){

        try {
            return new ResponseEntity<>(this.productService.deleteProduct(productId), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }


    }
}
