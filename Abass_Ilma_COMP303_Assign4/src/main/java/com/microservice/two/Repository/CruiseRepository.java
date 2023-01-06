package com.microservice.two.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.microservice.two.Model.Cruise;

@Repository
public interface CruiseRepository extends CrudRepository<Cruise, Long>{

}
