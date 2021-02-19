package com.example.ndjdbcdemo.Controller;

import com.example.ndjdbcdemo.Dao.suppliervendordao;
import com.example.ndjdbcdemo.Model.vendor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@Component
public class suppliervendorcontroller {
    @Autowired
  private suppliervendordao svd;
    @PostMapping("/addvendor")
    public String addVendor(@RequestBody vendor v){
        return svd.updateProduct(v);
    }
    @GetMapping("/display")
    public List<Map<String,Object>> DisplayProduct(){
       return svd.DisplayProduct();
    }
}
