package com.shipn.shipn.dto;

import java.util.Date;

import lombok.Data;

@Data
public class ApiResponseDto {
//	private int display; 
	private int page;
	private int records;
    private int total;
	private Item[] items; 
	
	@Data 
	static class Item 
	{ 
		public String title;
		public String link;
		public String image;
		public String subtitle;
		public Date pubDate;
		public String director; 
		public String actor; 
		public float userRating; 
	}
    public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getRecords() {
		return records;
	}

	public void setRecords(int records) {
		this.records = records;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}
//	public int getDisplay() {
//		return display;
//	}
//
//	public void setDisplay(int display) {
//		this.display = display;
//	}

	public Item[] getItems() {
		return items;
	}

	public void setItems(Item[] items) {
		this.items = items;
	}

}

//
//@Data
//public class ApiResponseDto {
////	private int display; 
//	private Item[] items; 
//	
//	@Data 
//	static class Item 
//	{ 
//		public String title;
//		public String link;
//		public String image;
//		public String subtitle;
//		public Date pubDate;
//		public String director; 
//		public String actor; 
//		public float userRating; 
//	}
//
////	public int getDisplay() {
////		return display;
////	}
////
////	public void setDisplay(int display) {
////		this.display = display;
////	}
//
//	public Item[] getItems() {
//		return items;
//	}
//
//	public void setItems(Item[] items) {
//		this.items = items;
//	}
//
//}