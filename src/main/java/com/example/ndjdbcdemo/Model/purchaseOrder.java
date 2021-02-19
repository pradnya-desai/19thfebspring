package com.example.ndjdbcdemo.Model;

import lombok.Getter;
import lombok.Setter;
import java.util.*;

@Getter
@Setter
public class purchaseOrder {
 private int po_id;
 private String cname;
private String address;

 private List<items> itemList;
}
