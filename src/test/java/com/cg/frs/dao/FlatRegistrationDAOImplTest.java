package com.cg.frs.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.cg.frs.dto.FlatRegistrationDTO;

class FlatRegistrationDAOImplTest {

	static FlatRegistrationDAOImpl dao;
	 static FlatRegistrationDTO dto,dto1;
	@BeforeAll
	public static void init()
	{
	 dao=new  FlatRegistrationDAOImpl();
	 dto=new FlatRegistrationDTO();
	 dto1=new FlatRegistrationDTO();
	 
	}
	
	
	@Test
	void testRegisterflat() {
		dto.setFlatArea(300);
		dto.setFlatType(2);
		dto.setRentAmount(3000);
		dto.setDepositAmount(10000);
		dto.setOwnerId(3);
		dto1 = dao.registerFlat(dto);
		assertEquals(1019, dto1.getFlatRegNo());
	}

	
	@Test
	public void testGetAllOwnersIds() {
		
	ArrayList<Integer> al=new ArrayList<Integer>();
	al.add(1);
	al.add(2);
	al.add(3);
	assertEquals(al, dao.getAllOwnersIds());
	}

}


