package edu.wctc.distjavarestdemo.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.fge.jsonpatch.JsonPatch;
import com.github.fge.jsonpatch.JsonPatchException;
import edu.wctc.distjavarestdemo.entity.Student;
import edu.wctc.distjavarestdemo.exception.ResourceNotFoundException;
import edu.wctc.distjavarestdemo.repo.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {
    private StudentRepository studentRepo;
    private ObjectMapper objectMapper;

    @Autowired
    public StudentService(StudentRepository sr,
                          ObjectMapper om) {
        this.studentRepo = sr;
        this.objectMapper = om;
    }

    public Student patch(int id, JsonPatch patch) throws ResourceNotFoundException,
            JsonPatchException, JsonProcessingException {
        Student existingStudent = getStudent(id);
        JsonNode patched = patch.apply(objectMapper
                .convertValue(existingStudent, JsonNode.class));
        Student patchedStudent = objectMapper.treeToValue(patched, Student.class);
        studentRepo.save(patchedStudent);
        return patchedStudent;
    }

    public void delete(int id) throws ResourceNotFoundException {
        if (studentRepo.existsById(id)) {
            studentRepo.deleteById(id);
        } else {
            throw new ResourceNotFoundException("Student", "id", id);
        }
    }

    public Student update(Student student)
            throws ResourceNotFoundException {
        if (studentRepo.existsById(student.getId())) {
            return studentRepo.save(student);
        } else {
            throw new ResourceNotFoundException("Student", "id", student.getId());
        }
    }

    public Student save(Student student) {
        return studentRepo.save(student);
    }

    public List<Student> getAllStudents() {
        List<Student> list = new ArrayList<>();
        studentRepo.findAll().forEach(list::add);
        return list;
    }

    public Student getStudent(int id) throws ResourceNotFoundException {
        return studentRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Student", "id", id));
    }
}
