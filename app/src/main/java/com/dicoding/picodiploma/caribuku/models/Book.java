package com.dicoding.picodiploma.caribuku.models;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class Book {

	@SerializedName("totalItems")
	private int totalItems;

	@SerializedName("kind")
	private String kind;

	@SerializedName("items")
	private List<ItemsItem> items;

	public void setTotalItems(int totalItems){
		this.totalItems = totalItems;
	}

	public int getTotalItems(){
		return totalItems;
	}

	public void setKind(String kind){
		this.kind = kind;
	}

	public String getKind(){
		return kind;
	}

	public void setItems(List<ItemsItem> items){
		this.items = items;
	}

	public List<ItemsItem> getItems(){
		return items;
	}

	@Override
 	public String toString(){
		return 
			"Book{" +
			"totalItems = '" + totalItems + '\'' + 
			",kind = '" + kind + '\'' + 
			",items = '" + items + '\'' + 
			"}";
		}
}