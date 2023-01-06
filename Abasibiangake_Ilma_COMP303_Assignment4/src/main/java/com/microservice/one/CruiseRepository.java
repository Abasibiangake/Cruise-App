package com.microservice.one;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CruiseRepository extends JpaRepository<Cruise, Integer>{
//	Cruise findByCruiseName(String CruiseName);

}
