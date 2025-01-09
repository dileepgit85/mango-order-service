package com.mango.order.service;

import com.mango.order.helper.HSSFExcelHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.HashMap;

@Service
public class ExcelService {
    @Autowired
    private HSSFExcelHelper excelHelper;
    public ByteArrayInputStream generateExcel() {
        ArrayList<String> headers = new ArrayList<>();
        ArrayList<HashMap<String, String>> data = new ArrayList<HashMap<String, String>>();
        headers.add("first line approver");
        headers.add("second line approver");
        headers.add("third line approver");
        return excelHelper.generateExcel(headers, data);
    }
}
