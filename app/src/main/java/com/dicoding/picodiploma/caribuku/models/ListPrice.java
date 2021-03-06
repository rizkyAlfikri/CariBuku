package com.dicoding.picodiploma.caribuku.models;

import com.google.gson.annotations.SerializedName;

public class ListPrice{

	@SerializedName("amount")
	private double amount;

	@SerializedName("currencyCode")
	private String currencyCode;

	@SerializedName("amountInMicros")
	private double amountInMicros;

	public void setAmount(double amount){
		this.amount = amount;
	}

	public double getAmount(){
		return amount;
	}

	public void setCurrencyCode(String currencyCode){
		this.currencyCode = currencyCode;
	}

	public String getCurrencyCode(){
		return currencyCode;
	}

	public void setAmountInMicros(double amountInMicros){
		this.amountInMicros = amountInMicros;
	}

	public double getAmountInMicros(){
		return amountInMicros;
	}

	@Override
 	public String toString(){
		return 
			"ListPrice{" + 
			"amount = '" + amount + '\'' + 
			",currencyCode = '" + currencyCode + '\'' + 
			",amountInMicros = '" + amountInMicros + '\'' + 
			"}";
		}
}