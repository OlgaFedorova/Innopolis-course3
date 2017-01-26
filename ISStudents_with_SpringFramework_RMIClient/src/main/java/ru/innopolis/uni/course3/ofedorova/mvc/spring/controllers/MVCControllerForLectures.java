package ru.innopolis.uni.course3.ofedorova.mvc.spring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ru.innopolis.uni.course3.ofedorova.common.controllers.AbstractLectureController;
import ru.innopolis.uni.course3.ofedorova.common.models.Lecture;

/**
 * Created by Olga on 07.01.2017.
 */
@Controller
public class MVCControllerForLectures {
    private final AbstractLectureController lectureController;

    @Autowired
    public MVCControllerForLectures(AbstractLectureController lectureController) {
        this.lectureController = lectureController;
    }

    @RequestMapping("/lecture/view")
    public String showLecturesView(Model model) {
        model.addAttribute("lectures", this.lectureController.valuesLectures());
        return "lecture/LectureView";
    }

    @RequestMapping(value = "/lecture/delete", method = RequestMethod.GET)
    public String deleteLecture(@RequestParam("id") Integer id, Model model) {
        this.lectureController.delete(id);
        return this.showLecturesView(model);
    }

    @RequestMapping(value = "/lecture/edit", method = RequestMethod.GET)
    public String editLecture(@RequestParam("id") Integer id, Model model) {
        model.addAttribute("lecture", this.lectureController.getLectureById(id));
        return "lecture/EditLecture";
    }

    @RequestMapping(value = "/lecture/edit", method = RequestMethod.POST)
    public String editLectureFromForm(Lecture lecture) {
        this.lectureController.edit(lecture);
        return "redirect:/lecture/view";
    }

    @RequestMapping(value = "/lecture/create", method = RequestMethod.GET)
    public String createLecture(Model model) {
        model.addAttribute("lecture", new Lecture());
        return "lecture/CreateLecture";
    }

    @RequestMapping(value = "/lecture/create", method = RequestMethod.POST)
    public String createLectureFromForm(Lecture lecture) {
        this.lectureController.add(lecture);
        return "redirect:/lecture/view";
    }
}
