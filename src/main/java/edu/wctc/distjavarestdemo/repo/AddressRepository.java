package edu.wctc.distjavarestdemo.repo;

import edu.wctc.distjavarestdemo.entity.Address;
import org.springframework.data.repository.CrudRepository;

public interface AddressRepository extends CrudRepository<Address, Integer> {
}
