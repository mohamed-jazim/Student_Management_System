package com.student.controller;

import com.student.entity.StudentEntity;
import com.student.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@Controller
public class StudentController {

    StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }



    //To show all the student info in the database
	
	  /*@GetMapping("/student")
	  public List<StudentEntity> getAllStudents()
	  {
		  return  studentService.getAllStudents(); }*/

        @GetMapping("/student")
    public String getAllStudents(Model model) {
        List<StudentEntity> students = studentService.getAllStudents();
        model.addAttribute("students", students); // Add the list of students to the model
        return "students";
    }






        //create student object to hold data
    @GetMapping("/student/add")
    public String saveStudent(Model model){
            StudentEntity entity = new StudentEntity();
            model.addAttribute("entity",entity);
            return "insert";
    }

    //to save
    @PostMapping("/student")
    public String saveStudent(@ModelAttribute("entity") StudentEntity entity){

            studentService.setdata(entity);
            return "redirect:/student";
    }

    @GetMapping("/student/edit/{id}")
    public String editStudent(@PathVariable("id") long id, Model model){
            model.addAttribute("student",studentService.findViewById(id));
            return "edit";
    }

    @PostMapping("/student/{id}")
    public String updateStudent(@PathVariable("id") long id, @ModelAttribute("student") StudentEntity student) {
        student.setId(id); // Ensure the ID is set correctly
        studentService.editStudent(student,id);
        return "redirect:/student";
    }
    @GetMapping("/student/delete/{id}")
    public String deleteStudent(@PathVariable("id") long id){
            studentService.deleteUser(id);
            return "redirect:/student";
    }






}
