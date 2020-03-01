package com.cts.ordering.repository;


import com.cts.ordering.model.Receipt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/*
 @author Myvin Barboza
 01/03/20 1:48 AM 
 */
@Repository
public interface OrderRepository extends JpaRepository<Receipt,Integer> {

}
