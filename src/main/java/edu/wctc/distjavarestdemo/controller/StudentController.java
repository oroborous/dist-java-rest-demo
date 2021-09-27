package edu.wctc.distjavarestdemo.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.github.fge.jsonpatch.JsonPatch;
import com.github.fge.jsonpatch.JsonPatchException;
import edu.wctc.distjavarestdemo.entity.Student;
import edu.wctc.distjavarestdemo.exception.ResourceNotFoundException;
import edu.wctc.distjavarestdemo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    private StudentService studentService;

    @Autowired
    public StudentController(StudentService ss) {
        this.studentService = ss;
    }

    @GetMapping
    public List<Student> getStudents() {
        return studentService.getAllStudents();
    }

    @PostMapping
    public Student createStudent(@RequestBody Student newStudent) {
        newStudent.setId(0);
        return studentService.save(newStudent);
    }

    @DeleteMapping("/{studentId}")
    public String deleteStudent(@PathVariable String studentId) {
        try {
            int id = Integer.parseInt(studentId);
            studentService.delete(id);
            return "Student deleted: ID " + studentId;
        } catch (NumberFormatException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                    "Student ID must be a number", e);
        } catch (ResourceNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                    e.getMessage(), e);
        }
    }

    @PatchMapping("/{studentId}")
    public Student patchStudent(@PathVariable String studentId,
                                @RequestBody JsonPatch patch) {
        try {
            int id = Integer.parseInt(studentId);
            return studentService.patch(id, patch);
        } catch (NumberFormatException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                    "Student ID must be a number", e);
        } catch (ResourceNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                    e.getMessage(), e);
        } catch (JsonPatchException | JsonProcessingException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                    "Invalid patch format: " + e.getMessage(), e);
        }
    }

    @PutMapping
    public Student updateStudent(@RequestBody Student student) {
        try {
            return studentService.update(student);
        } catch (ResourceNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                    e.getMessage(), e);
        }
    }

    @GetMapping("/{studentId}")
    public Student getStudent(@PathVariable String studentId) {
        try {
            int id = Integer.parseInt(studentId);
            return studentService.getStudent(id);
        } catch (NumberFormatException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                    "Student ID must be a number", e);
        } catch (ResourceNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                    e.getMessage(), e);
        }
    }
}
