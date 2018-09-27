package com.clovedin.hotelbooking.stock.entity;

import java.time.LocalDate;

import com.clovedin.hotelbooking.common.BaseEntity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StockAttrEnity extends BaseEntity {
	private Long hotelId;
	private Long suppId;
	private Long roomId;
	private Long priceId;
	private LocalDate bookingBegin;
	private LocalDate bookingEnd;
	private LocalDate checkinDate;
	private LocalDate checkoutDate;
	private Integer attrType;
	private Long attrId;
	
}
