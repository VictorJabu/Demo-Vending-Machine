package com.bondo.demo.Services;

import com.bondo.demo.Model.Sales;
import com.bondo.demo.Repository.SalesRepository;
import org.springframework.stereotype.Service;

@Service
public class SalesService {

    private final SalesRepository salesRepository;

    public SalesService(SalesRepository salesRepository)
    {
        this.salesRepository = salesRepository;
    }
}
