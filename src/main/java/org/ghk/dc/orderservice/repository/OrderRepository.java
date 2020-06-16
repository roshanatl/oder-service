package org.ghk.dc.orderservice.repository;

import java.util.List;

import org.ghk.dc.orderservice.domain.Order;
import org.javers.spring.annotation.JaversSpringDataAuditable;
import org.springframework.data.mongodb.repository.MongoRepository;

@JaversSpringDataAuditable
public interface OrderRepository extends MongoRepository<Order, String> {

    public Order findByItemName(String itemName);
    public List<Order> findByStatus(String status);    
    
	

}
