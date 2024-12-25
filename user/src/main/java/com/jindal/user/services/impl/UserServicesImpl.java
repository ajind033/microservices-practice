package com.jindal.user.services.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.web.client.RestTemplate;

import com.jindal.user.entities.Hotel;
import com.jindal.user.entities.Rating;
import com.jindal.user.entities.User;
import com.jindal.user.exceptions.ResourceNotFoundException;
import com.jindal.user.repository.UserRepository;
import com.jindal.user.services.UserServices;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@AllArgsConstructor
public class UserServicesImpl implements UserServices {

	private static final String HTTP_LOCALHOST_8083_RATING = "http://localhost:8083/ratings";
	private static final String HTTP_LOCALHOST_8082_HOTELS = "http://localhost:8082/hotels";
	private static final String RATING_SERVICE_DISCOVERY_URL = "http://RATING-SERVICE/ratings";
	private static final String HOTEL_SERVICE_DISCOVERY_URL = "http://HOTEL-SERVICE/hotels";
	private UserRepository userRepository;
	private RestTemplate restTemplate;

	@Override
	public User saveUser(User user) {
		// generate unique id
		String randomId = UUID.randomUUID().toString();
		user.setUserId(randomId);
		return userRepository.save(user);
	}

	@Override
	public List<User> getAllUser() {

		var userList = userRepository.findAll();
		if (!CollectionUtils.isEmpty(userList)) {
			ResponseEntity<List<Rating>> ratings = restTemplate.exchange(RATING_SERVICE_DISCOVERY_URL, HttpMethod.GET,
					null, new ParameterizedTypeReference<List<Rating>>() {
					});
			if (!CollectionUtils.isEmpty(ratings.getBody())) {

				Map<String, List<Rating>> userRatingMap = ratings.getBody().parallelStream()
						.collect(Collectors.groupingBy(Rating::getUserId, Collectors.toList()));
				for (User user : userList) {
					user.setRating(userRatingMap.getOrDefault(user.getUserId(), new ArrayList<>()));
				}
			}
		}
		return userList;
	}

	@Override
	public User getUser(String userId) {
		// TODO Auto-generated method stub
		var user = userRepository.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User with userId :" + userId + " not found"));

		ResponseEntity<List<Rating>> ratings = restTemplate.exchange(RATING_SERVICE_DISCOVERY_URL+"/user/" + userId,
				HttpMethod.GET, null, new ParameterizedTypeReference<List<Rating>>() {
				});

		log.info("ratings :: {}", ratings);
		if(!CollectionUtils.isEmpty(ratings.getBody())) {			
			ResponseEntity<List<Hotel>> hotels = restTemplate.exchange(HOTEL_SERVICE_DISCOVERY_URL, HttpMethod.GET, null,
					new ParameterizedTypeReference<List<Hotel>>() {
			});
			log.info("hotels :: {}", hotels);
			Map<String, Hotel> hotelMap = hotels.getBody().parallelStream()
					.collect(Collectors.toMap(Hotel::getId, Function.identity()));
			ratings.getBody().forEach(r -> {
				r.setHotel(hotelMap.get(r.getHotelId()));
			});
		}
		user.setRating(ratings.getBody());

		return user;
	}

}
