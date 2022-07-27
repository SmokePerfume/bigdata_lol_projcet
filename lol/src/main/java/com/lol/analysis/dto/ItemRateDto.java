package com.lol.analysis.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "item_rate")
public class ItemRateDto {
	@Id
	private int code;
	private String name;
	@Column(name = "start_item")
	private String startItem;
	@Column(name = "start_item_rate")
	private String startItemRate;
	@Column(name = "start_item2")
	private String startItem2;
	@Column(name = "start_item_rate2")
	private String startItemRate2;
	@Column(name = "boots_item")
	private String bootsItem;
	@Column(name = "boots_item_rate")
	private String bootsItemRate;
	@Column(name = "boots_item2")
	private String bootsItem2;
	@Column(name = "boots_item_rate2")
	private String bootsItemRate2;
	@Column(name = "main_item1")
	private String mainItem1;
	@Column(name = "main_item_rate1")
	private String mainItemRate1;
	@Column(name = "main_item2")
	private String mainItem2;
	@Column(name = "main_item_rate2")
	private String mainItemRate2;
	@Column(name = "main_item3")
	private String mainItem3;
	@Column(name = "main_item_rate3")
	private String mainItemRate3;
	
}
