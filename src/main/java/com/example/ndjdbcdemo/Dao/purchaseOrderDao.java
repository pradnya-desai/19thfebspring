package com.example.ndjdbcdemo.Dao;

import com.example.ndjdbcdemo.Model.Product;
import com.example.ndjdbcdemo.Model.items;
import com.example.ndjdbcdemo.Model.purchaseOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.*;

@Repository
@Component
public class purchaseOrderDao {
    @Autowired
    JdbcTemplate jdbcTemplate;


    public String AddPurchaseOrderDetails(purchaseOrder po) {

        String sql = "insert into purchaseOrder(cname,address) values(?,?)";
        //'jdbcTemplate.update(sql, new Object[]{po.getCname(), po.getAddress()}, Statement.RETURN_GENERATED_KEYS);

            KeyHolder holder = new GeneratedKeyHolder();
            jdbcTemplate.update(new PreparedStatementCreator() {
                @Override
                public PreparedStatement createPreparedStatement(Connection connection) throws SQLException, SQLException {
                    PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                    ps.setString(1, po.getCname());
                    ps.setString(2, po.getAddress());

                    return ps;
                }
            }, holder);

            int newUserId = holder.getKey().intValue();
            //po.setPo_id(newUserId);

        System.out.println(""+newUserId);
        List<items> list=po.getItemList();
        list.forEach(item->{
        String sql1 = "insert into items(item_name,item_price,po_id)values(?,?,?)";
        jdbcTemplate.update(sql1,new Object[]{item.getItem_name(),
                item.getItem_price(),newUserId});

    });
        return "success";
    }
}


