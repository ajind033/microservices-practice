package com.jindal.hotel.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jindal.hotel.entities.Hotel;
import com.jindal.hotel.services.HotelService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/hotels")
@AllArgsConstructor
public class HotelController {

	private HotelService hotelService;

	@PostMapping
	public ResponseEntity<Hotel> createHotel(@RequestBody Hotel hotel) {
		var response = hotelService.createHotel(hotel);

		return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}

	@GetMapping("/{hotelId}")
	public ResponseEntity<Hotel> getHotelbyId(@PathVariable String hotelId) {

		return ResponseEntity.ok(hotelService.getHotelbyId(hotelId));
	}

	@GetMapping()
	public ResponseEntity<List<Hotel>> getHotelbyId() {

		return ResponseEntity.ok(hotelService.getAll());
	}
}
