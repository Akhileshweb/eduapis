package com.edupeep.eduapis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.edupeep.eduapis.model.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long>{

}
