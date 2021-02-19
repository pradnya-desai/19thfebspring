package com.example.ndjdbcdemo.Dao;

import com.example.ndjdbcdemo.Controller.ProductController;
import com.example.ndjdbcdemo.Model.Product;
import com.example.ndjdbcdemo.Model.generic;
import com.example.ndjdbcdemo.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.sql.Types;
import java.util.List;

@Repository
@Component
public class ProductDao implements ProductRepository {
    //@Autowired
    //private ProductController pc;

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public String SaveProduct(Product p1) {

        String sql = "insert into Product values(?,?,?)";
        jdbcTemplate.update(sql, new Object[]{p1.getPid(), p1.getPname(), p1.getPrice()});
        return "data inserted";
    }

    @Override
    public List<Product> DisplayProduct() {
        String query = "SELECT * from product";

        List<Product> list;
        list = jdbcTemplate.query(query, new BeanPropertyRowMapper<>(Product.class));

        return list;
    }

    @Override
    public String updateProduct(int id, String name, Double rate) {
        String query = "UPDATE product SET pname=?, price=? WHERE pid=?";
        jdbcTemplate.update(query, new Object[]{name, rate, id});
        return "updated";
    }

    @Override
    public String deleteProduct(Integer id) {
        String query = "DELETE FROM product WHERE pid=?";
        jdbcTemplate.update(query, new Object[]{id});
        return "deleted";
    }

    @Override
    public List<Product> findProductByName(String name) {
        String query1 = "SELECT * FROM product WHERE pname= ?";
        List<Product> l1 = jdbcTemplate.query(query1, new Object[]{name}, new int[]{Types.VARCHAR}, new BeanPropertyRowMapper<>(Product.class));
        return l1;
    }

    public List<Product> findProductByNamePrice(String name, Double price1) {
        String query1 = "SELECT * FROM product WHERE pname=? or price=?";
        List<Product> l1 = jdbcTemplate.query(query1, new Object[]{name, price1}, new int[]{Types.VARCHAR, Types.DOUBLE}, new BeanPropertyRowMapper<>(Product.class));
        return l1;
    }

    public List<Product> findProductById(int id) {
        String query1 = "SELECT * FROM product WHERE pid=?";
        List<Product> l1 = jdbcTemplate.query(query1, new Object[]{id}, new int[]{Types.INTEGER}, new BeanPropertyRowMapper<>(Product.class));
        return l1;
    }

    public List<Product> findProductByLetter(String l) {
        String query1 = "SELECT * FROM product where pname like ?";
        List<Product> l1 = jdbcTemplate.query(query1, new Object[]{"%" + l + "%"}, new int[]{Types.VARCHAR}, new BeanPropertyRowMapper<>(Product.class));
        return l1;
    }


    public List<generic> genericsearch(String cfirstname, String clastname, String city) {
        String query1 = "SELECT * FROM generic where cfirstname like ?" +
                "or clastname like ?" +
                "or city like ?";
        List<generic> l1 = jdbcTemplate.query(query1, new Object[]{"%" + cfirstname+"%" ,"%"+clastname+"%","%"+city+"%"}, new int[]{Types.VARCHAR,Types.VARCHAR,Types.VARCHAR}, new BeanPropertyRowMapper<>(generic.class));
        return l1;
    }
}