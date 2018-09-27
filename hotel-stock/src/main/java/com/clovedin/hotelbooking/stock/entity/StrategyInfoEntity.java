package com.clovedin.hotelbooking.stock.entity;

import com.clovedin.hotelbooking.common.BaseEntity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StrategyInfoEntity extends BaseEntity {
	private Long channcelId;
	private Long userId;
	private Integer rangeType;
	private Integer rangeVal;
}
