
package com.microservice.two.Controller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.microservice.two.Model.Cruise;
import com.microservice.two.Service.CruiseService;
import com.microservice.two.Service.SequenceGeneratorService;

@Controller
public class CruiseController {

	@Autowired
	 CruiseService cruiseService;
	
	@Autowired
	SequenceGeneratorService sequenceGeneratorService;
	
	// get add cruise page
	@GetMapping("/add")
	public String addPage(@ModelAttribute("cruise") Cruise cruise, BindingResult result, Model model) 
	{
		model.addAttribute("cruiseList",new Cruise() );
		return "add-cruise-page";
		
	}
	// add  a new cruise info
	@PostMapping("/add-cruise") 
	public String addCruise(@ModelAttribute("cruise") Cruise cruise, BindingResult result, Model model) {
		if (result.hasErrors()) {
            return "add-cruise-page";
        }
		cruise.setCruiseId(sequenceGeneratorService.generateSequence(Cruise.SEQUENCE_NAME));
		cruiseService.addCruise(cruise);
		model.addAttribute("cruiseList", cruiseService.getAllCruises());
		return "home";
	}
	// get all cruise info
	@RequestMapping("/all-cruise")
	public String getAllCruises(Model model){
		model.addAttribute("cruiseList", cruiseService.getAllCruises());
		return "home";
	}
	
	// get edit cruise page
	@GetMapping("/edit-cruise/{cruiseId}")
	public String editCruise(@PathVariable("cruiseId") int cruiseId , @ModelAttribute Cruise cruise, Model model) {

		model.addAttribute("cruise",cruiseService.findCruiseById(cruiseId));
		return "edit-cruise-page";
	}

	// update cruise details
	@PostMapping("/update-cruise/{cruiseId}")
	public String updateCruise(@PathVariable("cruiseId") int cruiseId , @ModelAttribute Cruise cruise, Model model){
		Cruise currentCruise = cruiseService.findCruiseById(cruiseId);
		currentCruise.setCruiseDestination(cruise.getCruiseDestination());
		currentCruise.setCruiseLine(cruise.getCruiseLine());
		currentCruise.setDepartureDate(cruise.getDepartureDate());
		currentCruise.setVisitingPlaces(cruise.getVisitingPlaces());
		currentCruise.setDuration(cruise.getDuration());
		currentCruise.setPrice(cruise.getPrice());
		
		cruiseService.updateCruise(currentCruise);
		return "redirect:/all-cruise";
	}
	// delete cruise details if depart date is past already
	@PostMapping("/delete/{cruiseId}")
	public String deleteCruise(@PathVariable("cruiseId") int cruiseId, Model model, LocalDate departureDate) {
		Cruise cruise = cruiseService.findCruiseById(cruiseId);
		LocalDate today = LocalDate.now();
		if(cruise.getDepartureDate().isBefore(today)) {
			cruiseService.deleteCruise(cruise);
		}
	
		model.addAttribute("cruiseList", cruiseService.getAllCruises());
		return "redirect:/all-cruise";
	}
	
}
