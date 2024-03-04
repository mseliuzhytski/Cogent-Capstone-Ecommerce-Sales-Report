package com.cogent.ecommercesalesreport.controller;

import com.cogent.ecommerce.model.SalesItem;
import com.cogent.ecommercesalesreport.service.SalesReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/salesreport")
public class SalesReportController {

    @Autowired
    private SalesReportService salesReportService;

    @GetMapping("/getAll")
    public List<SalesItem> getSalesItems() {
        return salesReportService.getSalesItems();
    }

    @GetMapping("/aggregateByUser")
    public Collection<UserSalesReportDTO> getSalesReportsByUser() {
        return salesReportService.getSalesReportsByUser();
    }

    @PostMapping("/aggregateByUserTimeFilter")
    public Collection<UserSalesReportDTO> getSalesReportsByUser(@RequestBody TimeInterval interval) {
        return salesReportService.getSalesReportsByUser(interval.getStartTime(), interval.getEndTime());
    }


}
