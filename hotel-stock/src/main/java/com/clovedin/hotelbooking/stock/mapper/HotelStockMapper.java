package com.clovedin.hotelbooking.stock.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.clovedin.hotelbooking.stock.entity.HotelStockEntity;

@Mapper
public interface HotelStockMapper {

	void deleteByPrimaryKey(Long id);
	
	void insert(HotelStockEntity hotelStockEntity);
	
	void updateByPrimaryKey(HotelStockEntity hotelStockEntity);
	
	HotelStockEntity selectByPrimaryKey(Long id);
}
