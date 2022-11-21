package com.devsuperior.dsmeta.services;

import com.devsuperior.dsmeta.entities.Sale;
import com.devsuperior.dsmeta.repositories.SaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;

@Service
public class SaleService {

    @Autowired
    private SaleRepository repository;

    public Page<Sale> findSales(String startDate, String endDate, Pageable pageable) {
        LocalDate currentDay = LocalDate.ofInstant(Instant.now(), ZoneId.systemDefault());
        LocalDate start = "".equals(startDate) ? currentDay.minusDays(365) : LocalDate.parse(startDate);
        LocalDate end = "".equals(startDate) ? currentDay : LocalDate.parse(endDate);

        return repository.findSales(start, end, pageable);
    }
}
