package com.jindal.hotel.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jindal.hotel.entities.Hotel;

public interface HotelRepository extends JpaRepository<Hotel, String> {

}
