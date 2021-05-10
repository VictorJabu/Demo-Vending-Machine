package com.bondo.demo.Repository;

import com.bondo.demo.Model.Sales;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SalesRepository extends CrudRepository<Sales, Long> {
}
