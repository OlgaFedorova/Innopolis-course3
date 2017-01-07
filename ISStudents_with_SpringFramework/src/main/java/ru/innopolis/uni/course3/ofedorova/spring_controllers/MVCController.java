package ru.innopolis.uni.course3.ofedorova.spring_controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ru.innopolis.uni.course3.ofedorova.controllers.JournalController;
import ru.innopolis.uni.course3.ofedorova.controllers.LectureController;
import ru.innopolis.uni.course3.ofedorova.controllers.StudentController;

/**
 * Created by Olga on 07.01.2017.
 */
@Controller
public class MVCController {

    private final JournalController journalController;
    private final LectureController lectureController;
    private final StudentController studentController;

    @Autowired
    public MVCController(JournalController journalController, LectureController lectureController, StudentController studentController) {
        this.journalController = journalController;
        this.lectureController = lectureController;
        this.studentController = studentController;
    }

    @RequestMapping({"/"})
    public String showHomePage() {
        return "index";
    }

    @RequestMapping("/journal/view")
    public String showJournalView(Model model){
        model.addAttribute("records", this.journalController.values());
        return "journal/JournalView";
    }

    @RequestMapping("/lecture/view")
    public String showLecturesView(Model model){
        model.addAttribute("lectures", this.lectureController.valuesLectures());
        return "lecture/LectureView";
    }

    @RequestMapping("/student/view")
    public String showStudentsView(Model model){
        model.addAttribute("students", this.studentController.getStudents());
        return "student/StudentView";
    }

    @RequestMapping(value = "/student/delete", method = RequestMethod.GET)
    public String deleteStudent(@RequestParam("id")Integer id, Model model){
        this.studentController.delete(id);
        return this.showStudentsView(model);
    }

    @RequestMapping(value = "/lecture/delete", method = RequestMethod.GET)
    public String deleteLecture(@RequestParam("id")Integer id, Model model){
        this.lectureController.delete(id);
        return this.showLecturesView(model);
    }

    @RequestMapping(value = "/journal/delete", method = RequestMethod.GET)
    public String deleteRecordInJournal(@RequestParam("id")Integer id, Model model){
        this.journalController.delete(id);
        return this.showJournalView(model);
    }


}
