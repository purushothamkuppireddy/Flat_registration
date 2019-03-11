package com.cg.frs.ui;

import java.util.ArrayList;
import java.util.Scanner;

import com.cg.frs.dto.FlatRegistrationDTO;
import com.cg.frs.service.*;
import com.cg.frs.userException.DepositLowException;
import com.cg.frs.userException.OwnerIdException;

public class Client {
	static FlatRegistrationDTO dto = new FlatRegistrationDTO();

	public static void main(String[] args) {
		IFlatRegistrationService flatService = new FlatRegistrationServiceImpl();
		ArrayList<Integer> al = new ArrayList<Integer>();
		al = flatService.getAllOwnersIds();
		System.out.println("enter the choice 1:Registration,  2:Exit");
		Scanner sc = new Scanner(System.in);
		int ch = sc.nextInt();
		switch (ch) {
		case 1: // Register Flat
			System.out.println("Existing owner IDs:" + al);
			System.out.print("Please enter your Owner Id from above list: ");
			int ownerId = sc.nextInt();

			if (al.contains(ownerId)) {
				dto.setOwnerId(ownerId);
				System.out.print("select flat type 1-1BHK,2-2BHK: ");
				dto.setFlatType(sc.nextInt());
				System.out.print("Enter flat Area in sq.ft:");
				dto.setFlatArea(sc.nextInt());
				System.out.print("Enter desired rent amount Rs: ");
				int rent = sc.nextInt();
				dto.setRentAmount(rent);
				System.out.print("Enter desired deposit amount Rs: ");
				int deposit = sc.nextInt();
				if (deposit > rent) {
					dto.setDepositAmount(deposit);
					flatService.registerFlat(dto);
					System.out.println("Flat successfully registered.Registration Id: " + "<" + dto.getFlatRegNo() + ">");
				} else {
					try {
						throw new DepositLowException();
					} catch (DepositLowException e) {

					}
				}

			} else {
				try {
					throw new OwnerIdException();
				} catch (OwnerIdException e) {

				}

				}
			
		case 2:  System.out.println("Thank you..");
					System.exit(1);
		sc.close();	
		}
	}
}
