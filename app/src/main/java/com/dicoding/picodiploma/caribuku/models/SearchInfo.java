package com.dicoding.picodiploma.caribuku.models;

import com.google.gson.annotations.SerializedName;

public class SearchInfo{

	@SerializedName("textSnippet")
	private String textSnippet;

	public void setTextSnippet(String textSnippet){
		this.textSnippet = textSnippet;
	}

	public String getTextSnippet(){
		return textSnippet;
	}

	@Override
 	public String toString(){
		return 
			"SearchInfo{" + 
			"textSnippet = '" + textSnippet + '\'' + 
			"}";
		}
}