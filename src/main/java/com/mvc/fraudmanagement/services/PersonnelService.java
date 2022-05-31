package com.mvc.fraudmanagement.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mvc.fraudmanagement.entities.Personnel;

import com.mvc.fraudmanagement.repos.PersonnelRepository;


@Service
public class PersonnelService {

	private List<Personnel> personnelList=new ArrayList<>();
	@Autowired
	public PersonnelRepository personnelRepository;
	
	public void getAllUser() {
		personnelList=personnelRepository.findAll();
	}
	public boolean isValidLogin(String userId,String password)
	{
		for(Personnel u:personnelList) {
		if(u.getUserId().equals(userId) && u.getPassword().equals(password)) {
		return true;
		}
	}
		return false;
	}
	public Personnel getUserById(String userId) {
		getAllUser();
		for(Personnel personnel:personnelList)
		{
			if(personnel.getUserId().equals(userId))
			return personnel;
		}
		return null;
	}
	

}
