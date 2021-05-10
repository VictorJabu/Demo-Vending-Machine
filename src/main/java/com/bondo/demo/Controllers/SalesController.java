package com.bondo.demo.Controllers;

import com.bondo.demo.Model.Product;
import com.bondo.demo.Model.Sales;
import com.bondo.demo.Repository.SalesRepository;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SalesController {

    private final SalesRepository salesRepository;

    public SalesController(SalesRepository salesRepository)
    {
        this.salesRepository = salesRepository;
    }

    @RequestMapping(value = "/purchaseProduct", method = RequestMethod.POST, headers = "Accept=application/json")
    public Sales addCustomer(@RequestBody Sales sale) {
        salesRepository.save(sale);
      return sale;
    }

    @RequestMapping(value = "/sales", method = RequestMethod.GET, headers = "Accept=application/json")
    public List getSales() {
        List<Sales> salesList = (List<Sales>) salesRepository.findAll();
        return salesList;
    }
}
