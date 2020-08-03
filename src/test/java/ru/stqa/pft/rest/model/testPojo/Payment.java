package ru.stqa.pft.rest.model.testPojo;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("com.robohorse.robopojogenerator")
public class Payment{

	@SerializedName("transaction_id")
	private String transactionId;

	@SerializedName("amount")
	private String amount;

	@SerializedName("date_time")
	private String dateTime;

	@SerializedName("type")
	private String type;

	public void setTransactionId(String transactionId){
		this.transactionId = transactionId;
	}

	public String getTransactionId(){
		return transactionId;
	}

	public void setAmount(String amount){
		this.amount = amount;
	}

	public String getAmount(){
		return amount;
	}

	public void setDateTime(String dateTime){
		this.dateTime = dateTime;
	}

	public String getDateTime(){
		return dateTime;
	}

	public void setType(String type){
		this.type = type;
	}

	public String getType(){
		return type;
	}

	@Override
 	public String toString(){
		return 
			"Payment{" + 
			"transaction_id = '" + transactionId + '\'' + 
			",amount = '" + amount + '\'' + 
			",date_time = '" + dateTime + '\'' + 
			",type = '" + type + '\'' + 
			"}";
		}
}