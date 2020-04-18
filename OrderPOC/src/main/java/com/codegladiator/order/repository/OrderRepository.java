package com.codegladiator.order.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.codegladiator.order.entity.ISOrder;


@Repository
public interface OrderRepository  extends JpaRepository<ISOrder, Long> {

//	@Query("Select io From ISOrder io where uuid = 'WPLAqJ4RmBgAAAFwmZ5gGFfA'")
	public ISOrder findByuuid(String id);
	
}
