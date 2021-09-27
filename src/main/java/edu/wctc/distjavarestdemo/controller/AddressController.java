package edu.wctc.distjavarestdemo.controller;

import edu.wctc.distjavarestdemo.entity.Address;
import edu.wctc.distjavarestdemo.repo.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/addresses")
public class AddressController {
    private AddressRepository addressRepo;

    @Autowired
    public AddressController(AddressRepository ar) {
        this.addressRepo = ar;
    }

    @GetMapping
    public List<Address> getAddresses() {
        List<Address> list = new ArrayList<>();
        addressRepo.findAll().forEach(list::add);
        return list;
    }
}
