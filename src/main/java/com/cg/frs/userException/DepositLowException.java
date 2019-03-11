package com.cg.frs.userException;

public class DepositLowException extends Exception {
public DepositLowException()
{
	System.err.println("Deposit amount must greater than rent");
}
	
	
}
