package com.example.ndjdbcdemo.Controller;

import com.example.ndjdbcdemo.Dao.ProductDao;
import com.example.ndjdbcdemo.Model.Product;
import com.example.ndjdbcdemo.Model.generic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;
import sun.net.www.content.text.Generic;

import java.util.List;

@RestController
@Component
public class ProductController {
    @Autowired
    ProductDao pd;

    @PostMapping("/getpro")
    public String SaveProduct(@RequestBody Product p1) {
        return pd.SaveProduct(p1);
    }

    @GetMapping("/displaypro")

    public List<Product> DisplayProduct() {
        return pd.DisplayProduct();
    }

    @GetMapping("/delpro/{id}")
    public String deleteProduct(@PathVariable Integer id) {
        return pd.deleteProduct(id);
    }

    @GetMapping("/uppro/{id}/{name}/{rate}")
    public String updateProduct(@PathVariable int id,
                                @PathVariable String name,
                                @PathVariable Double rate) {
        return pd.updateProduct(id, name, rate);
    }

    @GetMapping("/dispByName/{name}")
    public List<Product> findProductByName(@PathVariable String name) {

        return pd.findProductByName(name);
    }

    @GetMapping("/dispByNamePrice/{name}/{price1}")
    public List<Product> findProductByNamePrice(@PathVariable String name,@PathVariable Double price1) {

        return pd.findProductByNamePrice(name,price1);
    }
    @GetMapping("/dispById/{id}")
    public List<Product> findProductById(@PathVariable int id) {

        return pd.findProductById(id);
    }
    @GetMapping("/dispByLetter/{l}")
    public List<Product> findProductByLetter(@PathVariable String l) {

        return pd.findProductByLetter(l);
    }
    @GetMapping("/genericSearch/{cfirstname}/{clastname}/{city}")
    public List<generic> genericsearch(@PathVariable String cfirstname, @PathVariable String clastname, @PathVariable String city) {

        return pd.genericsearch(cfirstname,clastname,city);
    }

}
