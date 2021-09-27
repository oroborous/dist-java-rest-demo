package edu.wctc.distjavarestdemo.repo;

import edu.wctc.distjavarestdemo.entity.Student;
import org.springframework.data.repository.CrudRepository;

public interface StudentRepository extends CrudRepository<Student, Integer> {
}
