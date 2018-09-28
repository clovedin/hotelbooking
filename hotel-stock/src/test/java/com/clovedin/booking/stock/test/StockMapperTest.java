package com.clovedin.booking.stock.test;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;

import com.clovedin.booking.stock.dao.HotelStockMapper;
import com.clovedin.booking.stock.entity.HotelStockEntity;
import com.clovedin.hotelbooking.common.IsEffectEnum;

public class StockMapperTest {
	
	@Autowired
	private HotelStockMapper hotelStockMapper;

	public void test() {
		HotelStockEntity hotelStockEntity = new HotelStockEntity();
		hotelStockEntity.setId(10000L+System.currentTimeMillis()%10000);
		hotelStockEntity.setHotelId(10001L);
		hotelStockEntity.setSuppId(10001L);
		hotelStockEntity.setRoomId(10001L);
		hotelStockEntity.setPriceId(10001L);
		hotelStockEntity.setDate(LocalDate.now());
		hotelStockEntity.setBasePrice(10000);
		hotelStockEntity.setSalePrice(12000);
		hotelStockEntity.setBaseCount(10);
		hotelStockEntity.setNowCount(9);
		hotelStockEntity.setSaleCount(1);
		hotelStockEntity.setStatus(0);
		hotelStockEntity.setIsEffect(IsEffectEnum.TAKE_EFFECT.ordinal());
		hotelStockEntity.setCreateBy(1L);
		hotelStockEntity.setCreateTime(LocalDateTime.now());
		hotelStockEntity.setUpdateBy(1L);
		hotelStockEntity.setUpdateTime(LocalDateTime.now());
		hotelStockMapper.insert(hotelStockEntity);
	}
}
