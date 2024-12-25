package com.jindal.rating.services;

import java.util.List;

import com.jindal.rating.entities.Rating;

public interface RatingService {

	Rating createRating(Rating rating);
	
	List<Rating> getAllRating();
	
	List<Rating> getRatingbyUserId(String userId);
	
	List<Rating> getRatingbyHotelId(String hotelId);
	
	
}
