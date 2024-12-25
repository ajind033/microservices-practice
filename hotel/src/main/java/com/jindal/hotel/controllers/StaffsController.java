package com.jindal.hotel.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/staffs")
public class StaffsController {
	

	@GetMapping
	public ResponseEntity<List<String>> getAllStaffs() {
	
		return ResponseEntity.ok(List.of("Ravi","Kavi","Pooja","Sonam"));
	}
}
