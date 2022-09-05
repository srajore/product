package com.zensar.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zensar.entity.Vendor;
import com.zensar.repositories.VendorRepository;

@Service
public class VendorServiceImpl implements VendorService {

	@Autowired
	private VendorRepository vendorRepository;

	@Override
	public Vendor getVendor(int vendorId) {
		return vendorRepository.findById(vendorId).get();
	}

	@Override
	public List<Vendor> getAllVendors() {

		return vendorRepository.findAll();
	}

	@Override
	public void deleteVendor(int vendorId) {
		vendorRepository.deleteById(vendorId);

	}

	@Override
	public Vendor insertVendor(Vendor vendor) {

		return vendorRepository.save(vendor);
	}

	@Override
	public Vendor updateVendor(int vendorId, Vendor vendor) {

		Vendor availableVendor = getVendor(vendorId);

		if (availableVendor != null) {

			availableVendor.setVendorName(vendor.getVendorName());

		}

		// TODO Auto-generated method stub
		return vendorRepository.save(vendor);
	}

}
