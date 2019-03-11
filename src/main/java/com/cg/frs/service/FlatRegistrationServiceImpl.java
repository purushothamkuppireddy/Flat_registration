package com.cg.frs.service;

import java.util.ArrayList;

import com.cg.frs.dao.*;
import com.cg.frs.dto.FlatRegistrationDTO;

public class FlatRegistrationServiceImpl implements IFlatRegistrationService {
 FlatRegistrationDTO dto= new FlatRegistrationDTO();
 IFlatRegistrationDAO flatdao= new FlatRegistrationDAOImpl() ;
	
	public FlatRegistrationDTO registerFlat(FlatRegistrationDTO dto) {
		dto=flatdao.registerFlat(dto);
		return dto;
	}

	public ArrayList<Integer> getAllOwnersIds() {
		ArrayList<Integer> al=new ArrayList<Integer>();
 		al=flatdao.getAllOwnersIds();
		return al;
	}

}
