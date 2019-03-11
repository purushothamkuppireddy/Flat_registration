package com.cg.frs.dto;

public class FlatRegistrationDTO {

	private int ownerId;
	private int flatRegNo;
	private int flatType;
	private int flatArea;
	private int rentAmount;
	private int depositAmount;

	public int getOwnerId() {
		return ownerId;
	}
	public void setOwnerId(int ownerId) {
		this.ownerId = ownerId;
	}
	public int getFlatRegNo() {
		return flatRegNo;
	}
	public void setFlatRegNo(int flatRegNo) {
		this.flatRegNo = flatRegNo;
	}
	public int getFlatType() {
		return flatType;
	}
	public void setFlatType(int flatType) {
		this.flatType = flatType;
	}
	public int getFlatArea() {
		return flatArea;
	}
	public void setFlatArea(int flatArea) {
		this.flatArea = flatArea;
	}
	public int getRentAmount() {
		return rentAmount;
	}
	public void setRentAmount(int rentAmount) {
		this.rentAmount = rentAmount;
	}
	public int getDepositAmount() {
		return depositAmount;
	}
	public void setDepositAmount(int depositAmount) {
		this.depositAmount = depositAmount;
	}
	
}
