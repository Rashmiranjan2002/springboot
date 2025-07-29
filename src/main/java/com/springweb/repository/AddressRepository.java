package com.springweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springweb.entity.AddressEntity;

public interface AddressRepository extends JpaRepository<AddressEntity, Long> {

}
