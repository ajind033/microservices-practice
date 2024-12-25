package com.jindal.rating.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.jindal.rating.entities.Rating;
import com.jindal.rating.repositiories.RatingRepository;
import com.jindal.rating.services.RatingService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class RatingServiceImpl implements RatingService {

	private RatingRepository ratingRepository;

	@Override
	public Rating createRating(Rating rating) {
		// TODO Auto-generated method stub
		return ratingRepository.insert(rating);
	}

	@Override
	public List<Rating> getAllRating() {
		// TODO Auto-generated method stub
		return ratingRepository.findAll();
	}

	@Override
	public List<Rating> getRatingbyUserId(String userId) {
		// TODO Auto-generated method stub
		return ratingRepository.findByUserId(userId);
	}

	@Override
	public List<Rating> getRatingbyHotelId(String hotelId) {
		// TODO Auto-generated method stub
		return ratingRepository.findByHotelId(hotelId);
	}

}
