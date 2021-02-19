package com.example.ndjdbcdemo.Controller;

import com.example.ndjdbcdemo.Dao.purchaseOrderDao;
import com.example.ndjdbcdemo.Model.purchaseOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Component
public class purchaseOrderController {
    @Autowired
    private purchaseOrderDao pd;


    @PostMapping("/addPurchaseOrder")
    public String AddPurchaseOrder(@RequestBody purchaseOrder po) {
        return pd.AddPurchaseOrderDetails(po);

    }
}
