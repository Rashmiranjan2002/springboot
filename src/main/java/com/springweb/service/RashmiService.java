package com.springweb.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.springweb.dto.RashmiDto;
import com.springweb.entity.AddressEntity;
import com.springweb.entity.RashmiEntity;
import com.springweb.repository.AddressRepository;
import com.springweb.repository.RashmiRepository;


@Service
public class RashmiService {
	@Autowired
	private RashmiRepository rashmiRepository;
	@Autowired
private AddressRepository addressRepository;
//	
//	public void saveDetails(RashmiEntity rashmiEntity) {
//		rashmiRepository.save(rashmiEntity);
//	}

	public void saveEmployeeDetails(RashmiDto rashmiDto) {
		RashmiEntity emp = new RashmiEntity();
		BeanUtils.copyProperties(rashmiDto,emp);//-->Copy Data From Dto to Entity
		rashmiRepository.save(emp);
		
		AddressEntity address = new AddressEntity();
		BeanUtils.copyProperties(rashmiDto,address);//-->Copy Data From Dto to Entity
		addressRepository.save(address);
	}
	
}
