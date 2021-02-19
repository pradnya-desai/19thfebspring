package com.example.ndjdbcdemo.Dao;

import com.example.ndjdbcdemo.Model.vendor;
import com.example.ndjdbcdemo.Repository.suppliervendorrepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class suppliervendordao implements suppliervendorrepository {
@Autowired
    JdbcTemplate jdbcTemplate;
    @Override
    public String updateProduct(vendor v) {
        String sql="insert into vendor values(?,?,?)";
        jdbcTemplate.update(sql,new Object[]{v.getVid(),v.getShopname(),v.getSc().getSid()});
        return "vendor added successfully";
    }

    @Override
    public List<Map<String,Object>> DisplayProduct() {
        String sql="select a.vid,a.shopname,b.sid,b.productname,b.city from vendor a,supplier b where a.vid=b.sid";
        List<Map<String,Object>> list =jdbcTemplate.queryForList(sql);
        return list;
    }



}
