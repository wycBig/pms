package com.ujiuye.anal.bean;
/*
 *	`gid` INT(10) PRIMARY KEY AUTO_INCREMENT,
	`cid` INT(10),
	`gname` VARCHAR(50) NOT NULL,
	`color` VARCHAR(50),
	`size` VARCHAR(50),
	`price` DOUBLE NOT NULL,
	`description` VARCHAR(500),
	`full_description` VARCHAR(1000),
	`pic` VARCHAR(200),
	`state` INT(5) DEFAULT 0,
	`version` VARCHAR(50),
	`product_date` DATETIME,
	CONSTRAINT fk_goods_cate FOREIGN KEY(cid) REFERENCES category(cid)
 */

import java.util.Date;

public class Goods {
	private Integer gid;
	private String gname;
	private String color;
	private String size;
	private Double price;

	@Override
	public String toString() {
		return "Goods{" +
				"gid=" + gid +
				", gname='" + gname + '\'' +
				", color='" + color + '\'' +
				", size='" + size + '\'' +
				", price=" + price +
				'}';
	}

	public Goods(Integer gid, String gname, String color, String size, Double price) {
		this.gid = gid;
		this.gname = gname;
		this.color = color;
		this.size = size;
		this.price = price;
	}

	public Integer getGid() {
		return gid;
	}

	public void setGid(Integer gid) {
		this.gid = gid;
	}


	public String getGname() {
		return gname;
	}

	public void setGname(String gname) {
		this.gname = gname;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Goods(){
		super();
	}
}
