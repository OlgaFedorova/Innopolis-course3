package ru.innopolis.uni.course3.ofedorova.mvc.spring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ru.innopolis.uni.course3.ofedorova.common.controllers.AbstractStudentController;
import ru.innopolis.uni.course3.ofedorova.common.models.Student;

/**
 * Created by Olga on 07.01.2017.
 */
@Controller
public class MVCControllerForStudents {
    private final AbstractStudentController studentController;

    @Autowired
    public MVCControllerForStudents(AbstractStudentController studentController) {
        this.studentController = studentController;
    }

    @RequestMapping("/student/view")
    public String showStudentsView(Model model) {
        model.addAttribute("students", this.studentController.getStudents());
        return "student/StudentView";
    }

    @RequestMapping(value = "/student/delete", method = RequestMethod.GET)
    public String deleteStudent(@RequestParam("id") Integer id, Model model) {
        this.studentController.delete(id);
        return this.showStudentsView(model);
    }

    @RequestMapping(value = "/student/edit", method = RequestMethod.GET)
    public String editStudent(@RequestParam("id") Integer id, Model model) {
        model.addAttribute("student", this.studentController.getStudent(id));
        return "student/EditStudent";
    }

    @RequestMapping(value = "/student/edit", method = RequestMethod.POST)
    public String editStudentFromForm(Student student) {
        this.studentController.edit(student);
        return "redirect:/student/view";
    }

    @RequestMapping(value = "/student/create", method = RequestMethod.GET)
    public String createStudent(Model model) {
        model.addAttribute("student", new Student());
        return "student/CreateStudent";
    }

    @RequestMapping(value = "/student/create", method = RequestMethod.POST)
    public String createStudentFromForm(Student student) {
        this.studentController.add(student);
        return "redirect:/student/view";
    }
}
