package com.jindal.hotel.services;

import java.util.List;

import com.jindal.hotel.entities.Hotel;

public interface HotelService {

	Hotel createHotel(Hotel hotel);

	List<Hotel> getAll();

	Hotel getHotelbyId(String hotelId);

}