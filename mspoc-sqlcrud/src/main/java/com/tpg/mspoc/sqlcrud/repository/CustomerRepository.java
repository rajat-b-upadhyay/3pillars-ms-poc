package com.tpg.mspoc.sqlcrud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tpg.mspoc.sqlcrud.model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,String>{

}
