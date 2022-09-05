package com.zensar.services;

import java.util.List;

import com.zensar.entity.Vendor;

public interface VendorService {

	public Vendor getVendor(int vendorId);

	public List<Vendor> getAllVendors();

	public void deleteVendor(int vendorId);

	public Vendor insertVendor(Vendor vendor);

	public Vendor updateVendor(int vendorId, Vendor vendor);

}
