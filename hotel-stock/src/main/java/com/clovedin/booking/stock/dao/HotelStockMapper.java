package com.clovedin.booking.stock.dao;

import org.apache.ibatis.annotations.Mapper;

import com.clovedin.booking.stock.entity.HotelStockEntity;

@Mapper
public interface HotelStockMapper {

	void deleteByPrimaryKey(Long id);
	
	void insert(HotelStockEntity hotelStockEntity);
	
	void updateByPrimaryKey(HotelStockEntity hotelStockEntity);
	
	HotelStockEntity selectByPrimaryKey(Long id);
}
