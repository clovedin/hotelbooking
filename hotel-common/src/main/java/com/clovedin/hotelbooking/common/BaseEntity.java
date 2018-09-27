package com.clovedin.hotelbooking.common;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class BaseEntity {
	private Long id;
	private Integer isEffect;
	private Long createBy;
	private LocalDateTime createTime; 
	private Long updateBy;
	private LocalDateTime updateTime;
	
}
