package com.khapatniukovskyi.blog.model;

import java.util.List;
// Each Item is an Article with all attributes. 
public class Items<T> extends AbstractModel{
	private List<T> items;
	private int count;
	public List<T> getItems() {
		return items;
	}
	public void setItems(List<T> items) {
		this.items = items;
	}
	
	// Total amount of Articles
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
}
