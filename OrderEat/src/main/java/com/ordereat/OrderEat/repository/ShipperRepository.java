package com.ordereat.OrderEat.repository;

import com.ordereat.OrderEat.entity.Shipper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShipperRepository extends JpaRepository<Shipper, Long> {

    boolean existsByName(String name);
}
