package edu.wctc.distjavarestdemo.service;

import edu.wctc.distjavarestdemo.entity.Address;
import edu.wctc.distjavarestdemo.repo.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressService {
    private final AddressRepository addressRepo;

    @Autowired
    public AddressService(AddressRepository addressRepo) {
        this.addressRepo = addressRepo;
    }

    public Address save(Address address) {
        if(address.getStreet() == null)
            return addressRepo.findById(address.getId()).get();

        return addressRepo.save(address);
    }
}
