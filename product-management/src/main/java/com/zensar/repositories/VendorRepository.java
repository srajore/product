package com.zensar.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zensar.entity.Vendor;

public interface VendorRepository extends JpaRepository<Vendor, Integer> {

}
