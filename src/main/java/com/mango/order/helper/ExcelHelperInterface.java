package com.mango.order.helper;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.HashMap;

public interface ExcelHelperInterface {
    ByteArrayInputStream generateExcel(ArrayList<String> headers, ArrayList<HashMap<String, String>> data);
}
