package com.jindal.rating.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jindal.rating.entities.Rating;
import com.jindal.rating.services.RatingService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/ratings")
@AllArgsConstructor
public class RatingController {

	private RatingService ratingService;

	@PostMapping
	public ResponseEntity<Rating> createRating(@RequestBody Rating rating) {

		return ResponseEntity.status(HttpStatus.CREATED).body(ratingService.createRating(rating));
	}

	@GetMapping
	public ResponseEntity<List<Rating>> getAllRating() {

		return ResponseEntity.ok(ratingService.getAllRating());
	}

	@GetMapping("/hotel/{hotelId}")
	public ResponseEntity<List<Rating>> getRatingbyHotelId(@PathVariable String hotelId) {

		return ResponseEntity.ok(ratingService.getRatingbyHotelId(hotelId));
	}

	@GetMapping("/user/{userId}")
	public ResponseEntity<List<Rating>> getRatingbyUserId(@PathVariable String userId) {

		return ResponseEntity.ok(ratingService.getRatingbyUserId(userId));
	}

}
