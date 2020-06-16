package org.ghk.dc.orderservice.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.ghk.dc.orderservice.domain.Order;
import org.ghk.dc.orderservice.repository.OrderRepository;
import org.javers.core.Javers;
import org.javers.core.metamodel.object.CdoSnapshot;
import org.javers.core.metamodel.object.CdoSnapshotState;
import org.javers.repository.jql.QueryBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private Javers javers;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(OrderController.class);

	@PostMapping("/order")
	public Order create(@RequestBody Order order) throws Exception {
		LOGGER.info("Starting Order create ");
		Order myorder=null;
		
		try {
			myorder=orderRepository.save(order)	;
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		LOGGER.info("Finished Folder clean");
		return myorder;
	}
	
	
	@PutMapping("/order/{order-id}")
	public Order update(@PathVariable(value= "order-id") String id ,@RequestBody Order order) throws Exception {
		LOGGER.info("Starting Order create ");
		Order myOrder=null;
		
		try {
			Optional<Order>  myOrderCurrent=orderRepository.findById(id);
			myOrder = myOrderCurrent.get();
			myOrder.setStatus(order.getStatus());
			myOrder.setStaffDeatils(order.getStaffDeatils());
			myOrder=orderRepository.save(myOrder)	;
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		LOGGER.info("Finished Folder clean");
		return myOrder;
	}
	
	 @GetMapping(value= "/order")
	    public Collection<Order> getAll() {
		    LOGGER.debug("Getting all Orders.");
	        return orderRepository.findAll();
	    }
	 
	 @GetMapping(value= "/order/{order-id}")
	    public Optional<Order> getOrder(@PathVariable(value= "order-id") String id) {
		    LOGGER.debug("Getting all Orders.");
	        return orderRepository.findById(id);
	    }
	
	@GetMapping(value= "/orderHistory/{order-id}")
	public List<Order> getHistory(@PathVariable(value= "order-id") String id) {
		 QueryBuilder jqlQuery = QueryBuilder.byInstanceId(id, Order.class)
	                .withNewObjectChanges();

	        //Changes changes = javers.findChanges(jqlQuery.build());
	        List<CdoSnapshot> snapshots= javers.findSnapshots(jqlQuery.build());
	        List<Order> orders=mapOrder(snapshots);
	        
	        return orders;

	        //return "<pre>" + changes.prettyPrint() + "</pre>";
	}
	
	private List<Order> mapOrder(List<CdoSnapshot> snapshots){
		
		List<Order> orderList= new ArrayList<>();
		for(CdoSnapshot person : snapshots) {
			Order order= new Order();
        	CdoSnapshotState orderState=person.getState();
        	if(null!=orderState.getPropertyValue("itemName")) {
        		order.setItemName((String) orderState.getPropertyValue("itemName"));
        	}
        	        	
        	if(null!=orderState.getPropertyValue("status")) {
        		order.setStatus((String) orderState.getPropertyValue("status"));
        	}
        	
        	if(null!=orderState.getPropertyValue("staffDeatils")) {
        		order.setStaffDeatils((String) orderState.getPropertyValue("staffDeatils"));
        	}
        	
        	if(null!=orderState.getPropertyValue("updateDttm")) {
        		order.setUpdateDttm((Date) orderState.getPropertyValue("updateDttm"));
        	}
        	orderList.add(order);
        }
		return orderList;
	}

	
}
