package com.example.ndjdbcdemo.Repository;

import com.example.ndjdbcdemo.Model.vendor;

import java.util.List;
import java.util.Map;

public interface suppliervendorrepository {
    String updateProduct(vendor v);
    List<Map<String,Object>> DisplayProduct();


}
