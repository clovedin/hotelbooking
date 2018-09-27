package com.clovedin.hotelbooking.stock;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.clovedin.hotelbooking.common.IsEffectEnum;
import com.clovedin.hotelbooking.stock.entity.HotelStockEntity;
import com.clovedin.hotelbooking.stock.mapper.HotelStockMapper;

import io.vertx.core.AbstractVerticle;

@Service
public class StockVerticle extends AbstractVerticle {
	private static final Logger LOG = LoggerFactory.getLogger(StockVerticle.class);
	
	@Autowired
	private Environment environment;
	@Autowired
	private HotelStockMapper hotelStockMapper;
	
	@Override
	public void start() throws Exception {
		String httpPort = environment.getProperty("http.port");
		LOG.info("http.port={}", httpPort);
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
