package com.addressBook.dao;

import com.addressBook.domain.Address;
import com.addressBook.repository.AddressRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.faces.bean.ManagedBean;
import javax.inject.Inject;
import java.util.List;

@ManagedBean(name = "addressBean", eager = true)
public class AddressBean {
    Logger log = LoggerFactory.getLogger(AddressBean.class);

    @Inject
    private AddressRepository addressRepository;
    private Address address = new Address();

    public void addAddress(Address address) {
        log.info("addAddress");
        addressRepository.addAddress(address);
        log.info(address.getCity());
    }

    public List<Address> getAddressData() {
        log.info("getAddresses");
        return addressRepository.getAddress();
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
