package com.example.ndjdbcdemo.Repository;

import com.example.ndjdbcdemo.Model.Product;
import com.example.ndjdbcdemo.Model.generic;

import java.util.List;

public interface ProductRepository {

    String SaveProduct(Product p1);

     List<Product> DisplayProduct();

    String updateProduct(int id, String name,Double rate);

    String deleteProduct(Integer id);

    List<Product> findProductByName(String name);

    List<Product> findProductByNamePrice(String name,Double price1);

    List<Product> findProductById(int id);

    List<Product> findProductByLetter(String l);
    List<generic> genericsearch(String cfirstname, String clastname, String city );
//
}
