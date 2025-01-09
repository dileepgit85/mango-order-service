package com.mango.order.controller;

import com.mango.order.dto.OrderDTO;
import com.mango.order.dto.OrderDtoFromFE;
import com.mango.order.service.ExcelService;
import jakarta.ws.rs.QueryParam;
import org.springframework.core.io.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.ByteArrayInputStream;

@RestController()
@RequestMapping("/excel")
public class ExcelController {

    @Autowired
    private ExcelService excelService;
    @RequestMapping("/generateExcel")
    public ResponseEntity<Resource> generateExcel(@QueryParam("order") String order) {
       String excelFilename = "orders-data-" + order + ".xls";
        ByteArrayInputStream exceldata = excelService.generateExcel();
        InputStreamResource resource = new InputStreamResource(exceldata);
        ResponseEntity<Resource> body =  ResponseEntity.ok()
                .header("Content-Disposition", "attachment; filename=" + excelFilename)
                .contentType(MediaType.parseMediaType("application/vnd.ms-excel"))
                .body(resource);

        return body;

    }

    @GetMapping("/test")
    public ResponseEntity<String> createOrder(@QueryParam("order") String order) {
        return new ResponseEntity<String>("ORDER PLACED SUCCESSFULLY WITH ORDER NO - "+ order, HttpStatus.OK);
    }
}
