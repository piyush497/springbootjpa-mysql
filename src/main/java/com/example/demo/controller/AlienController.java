package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.model.Alien;
import com.example.demo.repo.AlienRepository;

@Controller
public class AlienController {
	
	@Autowired
	AlienRepository repo;
	
	@RequestMapping("aliens")	
	@ResponseBody
	public List<Alien> getAllAliens() {	
		
		System.out.println("I am in controller :: getAllAliens");		
		List<Alien> aliens = repo.findAll();
		return aliens;
		
	}
	
	@RequestMapping(value="aliens/{aid}")	
	@ResponseBody
	public Optional<Alien> getAlien(@PathVariable("aid") int aid) {	
		
		System.out.println("I am in controller :getAlien ");		
		Optional<Alien> alien = repo.findById(aid);
		return alien;
		
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value="aliens/{aid}")	
	@ResponseBody
	public String deleteAlien(@PathVariable("aid") int aid) {	
		
		System.out.println("I am in controller :getAlien ");		
		repo.deleteById(aid);
		return "success";
		
	}
	
	
	@RequestMapping(method = RequestMethod.POST, value="aliens",consumes="application/json")	
	@ResponseBody
	public Alien addAlien(@RequestBody Alien alien) {	
		
		System.out.println("I am in controller : addAlien");		
		Alien alienEntity = repo.save(alien);
		return alienEntity;
		
	}	
	
	@PutMapping("aliens")	
	@ResponseBody
	public Alien updateAlien(@RequestBody Alien alien) {	
		
		System.out.println("I am in controller :getAlien ");		
		Alien alienEntity = repo.save(alien);
		return alienEntity;
		
	}
	
	
	
	
	
	/*
	 * @PostMapping("aliens")
	 * 
	 * @ResponseBody public String addAlien(@RequestBody Alien alien) {
	 * 
	 * System.out.println("I am in controller : addAlien"); repo.save(alien); return
	 * alien.toString();
	 * 
	 * }
	 */
	
	/*
	 * @DeleteMapping("alien/{aid}")
	 * 
	 * @ResponseBody public String deleteAlien(@PathVariable("aid") int aid) {
	 * 
	 * System.out.println("I am in controller :getAlien "); Optional<Alien> alien =
	 * repo.findById(aid); return alien.toString();
	 * 
	 * }
	 */
	
	
	
	

}
