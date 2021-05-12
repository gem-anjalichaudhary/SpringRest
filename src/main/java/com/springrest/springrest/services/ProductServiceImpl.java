package com.springrest.springrest.services;


import com.springrest.springrest.entities.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ProductServiceImpl implements ProductService{
    //private ProductsDao productsDao;
    private static List<Product> productRepo;

    public ProductServiceImpl() {
        productRepo = new ArrayList<>();
        Product honey = new Product();
        honey.setId("1");
        honey.setName("Oats");
        productRepo.add(honey);

        Product almond = new Product();
        almond.setId("2");
        almond.setName("Almond");
        productRepo.add(almond);
    }

    // get all products :: GET
    @Override
    public List<Product> getProducts() {

       return productRepo;
        //hibernate
       //return productsDao.findAll();
    }

    // get Product on the basis of productId provided in path variable:: GET
    @Override
    public Product getProduct(String productId) {

        Product product = new Product();
        productRepo.forEach(e->{
            if(e.getId().equals(productId)){
                 product.setId(e.getId());
                 product.setName(e.getName());
                }
             }
        );
       return product;
       //hibernate
        // return productsDao.getOne(productId);
    }

    //add product provided in request body :: POST
    @Override
    public List<Product> addProduct(Product product) {
        productRepo.add(product);
        return productRepo;

        //hibernate
       /* productsDao.save(product);
        return productsDao.findAll();*/
    }

    @Override
    public List<Product> updateProduct(Product product) {

       /* productRepo.forEach(e->{
            if(e.getId().equals(product.getId())){
                e.setName(product.getName());
            }
        });*/


        //streams method
       productRepo.stream()
                .forEach(e->{
                    if(e.getId().equals(product.getId())){
                        e.setName(product.getName());
                    }
                });
        return productRepo;
       /* productsDao.save(product);
        return productsDao.findAll();*/
    }

    @Override
    public List<Product> deleteProduct(String productId) {

        productRepo.removeIf(product -> product.getId().equals(productId));
        return productRepo;

       /* Product product = productsDao.getOne(productId);
        productsDao.delete(product);
        return productsDao.findAll();*/
    }
}
