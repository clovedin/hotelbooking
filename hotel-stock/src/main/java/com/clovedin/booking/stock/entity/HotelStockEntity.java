package com.clovedin.booking.stock.entity;

import java.time.LocalDate;

import com.clovedin.hotelbooking.common.BaseEntity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HotelStockEntity extends BaseEntity {
	private Long hotelId;
	private Long suppId;
	private Long roomId;
	private Long priceId;
	private LocalDate date;
	private Integer basePrice;
	private Integer salePrice;
	private Integer baseCount;
	private Integer nowCount;
	private Integer saleCount;
	private Integer status;
	
}
