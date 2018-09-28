package com.clovedin.booking.stock.entity;

import com.clovedin.hotelbooking.common.BaseEntity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClauseInfoEntity extends BaseEntity {
	private Integer clauseType;
	private Integer clauseStr;
	private Integer cancelFine;
}
