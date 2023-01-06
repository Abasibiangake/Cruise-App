
package com.microservice.two.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.microservice.two.Model.Cruise;
import com.microservice.two.Repository.CruiseRepository;

import lombok.AllArgsConstructor;

@Service

@Transactional

@AllArgsConstructor
public class CruiseService {
	
	
	@Autowired
	CruiseRepository cruiseRepo;
	

	
	public List<Cruise> getAllCruises(){
		List<Cruise> allCruises = new ArrayList<>();
		allCruises.addAll((Collection<Cruise>) cruiseRepo.findAll());
		return allCruises;
	}
	
	public Cruise addCruise(Cruise cruise) {
		return cruiseRepo.save(cruise);
	}
	
	public void deleteCruise(Cruise cruise) {
		cruiseRepo.delete(cruise);
		
	}
	
	public Cruise updateCruise(Cruise cruise) {
		return cruiseRepo.save(cruise);
	}
	
	public Cruise findCruiseById(int id) {
		List<Cruise> cruises = (List<Cruise>) cruiseRepo.findAll();
		Cruise toReturn = new Cruise();
		for (Cruise cruise:cruises) {
			if (cruise.getCruiseId()==id) { toReturn = cruise;}
		}
		return toReturn;
	}

	// deleteByDateTimeLessThan(LocalDateTime dateTime);


}
