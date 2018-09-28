package com.clovedin.booking.vary.entity;

import java.time.Instant;

import org.influxdb.annotation.Column;
import org.influxdb.annotation.Measurement;

import com.clovedin.hotelbooking.common.SysConstant;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Measurement(name=SysConstant.TB_VaryLog)
public class VaryLogEntity {
	@Column(name = "time")
	private Long time;
	@Column(name = "hotelId", tag=true)
	private Long hotelId;
	@Column(name = "suppId", tag=true)
	private Long suppId;
	@Column(name = "roomId", tag=true)
	private Long roomId;
	@Column(name = "priceId", tag=true)
	private Long priceId;
	@Column(name = "productKey")
	private String productKey;
	@Column(name = "opType")
	private Integer opType;
	@Column(name = "opUser")
	private Long opUser;
	@Column(name = "attr")
	private String attr;
	
}
