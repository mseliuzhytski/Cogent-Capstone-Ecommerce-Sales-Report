package com.cogent.ecommercesalesreport.service;

import com.cogent.ecommerce.model.SalesItem;
import com.cogent.ecommerce.repository.SalesItemJpaRepository;
import com.cogent.ecommercesalesreport.controller.UserSalesReportDTO;
import com.cogent.ecommercesalesreport.repository.SalesItemJpaRepository2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SalesReportService {

    @Autowired
    private SalesItemJpaRepository2 jpaRepository;

    public List<SalesItem> getSalesItems() {
        return jpaRepository.findAll();
    }

    public Collection<UserSalesReportDTO> getSalesReportsByUser() {
        Map<Integer, UserSalesReportDTO> map = new HashMap<>();
        List<SalesItem> salesItems = jpaRepository.findAll();
        for (SalesItem salesItem : salesItems) {
            int accId = salesItem.getAccount().getId();
            UserSalesReportDTO dto = map.get(accId);
            if (dto == null) {
                dto = new UserSalesReportDTO();
                dto.setAccount(salesItem.getAccount());
                map.put(accId, dto);
            }
            dto.setTotalPrice(dto.getTotalPrice() + salesItem.getTotalPrice());
            dto.setTotalPurchases(dto.getTotalPurchases() + salesItem.getQuantitySold());
        }
        return map.values();
    }

    public Collection<UserSalesReportDTO> getSalesReportsByUser(
            long startTime, long endTime
    ) {
        Map<Integer, UserSalesReportDTO> map = new HashMap<>();
        List<SalesItem> salesItems = jpaRepository.findAll();
        for (SalesItem salesItem : salesItems) {
            int accId = salesItem.getAccount().getId();
            UserSalesReportDTO dto = map.get(accId);
            if (dto == null) {
                dto = new UserSalesReportDTO();
                dto.setAccount(salesItem.getAccount());
                map.put(accId, dto);
            }
            if (salesItem.getTimeRecorded() >= startTime && salesItem.getTimeRecorded() <= endTime) {
                dto.setTotalPrice(dto.getTotalPrice() + salesItem.getTotalPrice());
                dto.setTotalPurchases(dto.getTotalPurchases() + salesItem.getQuantitySold());
            }
        }
        return map.values();
    }

}
