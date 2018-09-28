package com.clovedin.booking.vary.dao;

import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;

import org.influxdb.InfluxDB;
import org.influxdb.dto.Point;
import org.influxdb.dto.Query;
import org.influxdb.dto.QueryResult;
import org.influxdb.impl.InfluxDBResultMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.clovedin.booking.vary.entity.VaryLogEntity;
import com.clovedin.hotelbooking.common.SysConstant;

/**
 * 
 * @author cc
 * https://github.com/influxdata/influxdb-java
 */

@Service
public class VaryLogDao implements InitializingBean {
	private static final Logger LOG = LoggerFactory.getLogger(VaryLogDao.class);
	
	@Autowired
	private InfluxDB influxDB;
	
	private static final int ChunkSize = 1000;
	
	public static final InfluxDBResultMapper ResultMapper = new InfluxDBResultMapper();

	public void insert(VaryLogEntity varyLogEntity) {
		influxDB.setDatabase(SysConstant.DB_VaryLog);
		if(varyLogEntity.getTime() == null) {
			LOG.info("VaryLogEntity.time is null : {}", varyLogEntity);
			return ;
		}
		if(varyLogEntity.getOpUser() == null) {
			LOG.info("VaryLogEntity.opUser is null : {}", varyLogEntity);
			return ;
		}
		if(varyLogEntity.getOpType() == null) {
			LOG.info("VaryLogEntity.opType is null : {}", varyLogEntity);
			return ;
		}
		Point.Builder builder = Point.measurement(SysConstant.DB_VaryLog);
		builder.time(varyLogEntity.getTime(), TimeUnit.MILLISECONDS)
			.addField("opUser", varyLogEntity.getOpUser())
			.addField("opType", varyLogEntity.getOpType());
		StringBuilder sb = new StringBuilder();
		if(varyLogEntity.getHotelId() != null) {
			builder.tag("hotelId", varyLogEntity.getHotelId()+"");
			sb.append(varyLogEntity.getHotelId()+SysConstant.STR_SPLIT);
		}else {
			sb.append(SysConstant.STR_SPLIT);
		}
		if(varyLogEntity.getSuppId() != null) {
			builder.tag("suppId", varyLogEntity.getSuppId()+"");
			sb.append(varyLogEntity.getSuppId()+SysConstant.STR_SPLIT);
		}else {
			sb.append(SysConstant.STR_SPLIT);
		}
		if(varyLogEntity.getRoomId() != null) {
			builder.tag("roomId", varyLogEntity.getRoomId()+"");
			sb.append(varyLogEntity.getRoomId()+SysConstant.STR_SPLIT);
		}else {
			sb.append(SysConstant.STR_SPLIT);
		}
		if(varyLogEntity.getPriceId() != null) {
			builder.tag("roomId", varyLogEntity.getPriceId()+"");
			sb.append(varyLogEntity.getPriceId());
		}
		builder.addField("productKey", sb.toString());
		if(StringUtils.hasText(varyLogEntity.getAttr())) {
			builder.addField("attr", varyLogEntity.getAttr());
		}
		Point point = builder.build();
		LOG.info("insert db={},data={}", SysConstant.DB_VaryLog, point);
		influxDB.write(point);
		influxDB.flush();
	}
	
	public void findProductKeyByTime(Long start, Long end, final Consumer<QueryResult> onNext){
		String qStr = "select productKey from "+SysConstant.DB_VaryLog+" where time >="
				+start+" and time < "+end;
		Query query = new Query(qStr, SysConstant.DB_VaryLog);
		influxDB.query(query, ChunkSize, onNext);
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		influxDB.enableBatch();
		influxDB.enableGzip();
	}
	
}
