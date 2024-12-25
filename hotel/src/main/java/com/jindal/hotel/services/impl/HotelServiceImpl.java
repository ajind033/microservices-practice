package com.jindal.hotel.services.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.jindal.hotel.entities.Hotel;
import com.jindal.hotel.exceptions.ResourceNotFoundException;
import com.jindal.hotel.repositories.HotelRepository;
import com.jindal.hotel.services.HotelService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class HotelServiceImpl implements HotelService {

	private HotelRepository hotelRepository;

	@Override
	public Hotel createHotel(Hotel hotel) {
		String id = UUID.randomUUID().toString();
		hotel.setId(id);
		return hotelRepository.save(hotel);
	}

	@Override
	public List<Hotel> getAll() {
		// TODO Auto-generated method stub
		return hotelRepository.findAll();
	}

	@Override
	public Hotel getHotelbyId(String hotelId) {
		// TODO Auto-generated method stub
		return hotelRepository.findById(hotelId)
				.orElseThrow(() -> new ResourceNotFoundException("Hotel with hotelId :" + hotelId + " not found"));
	}

}
