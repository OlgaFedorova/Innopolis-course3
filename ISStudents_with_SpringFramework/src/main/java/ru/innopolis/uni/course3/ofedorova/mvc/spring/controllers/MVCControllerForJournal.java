package ru.innopolis.uni.course3.ofedorova.mvc.spring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ru.innopolis.uni.course3.ofedorova.controllers.JournalController;
import ru.innopolis.uni.course3.ofedorova.models.Journal;

/**
 * Created by Olga on 07.01.2017.
 */
@Controller
public class MVCControllerForJournal {

    private final JournalController journalController;

    @Autowired
    public MVCControllerForJournal(JournalController journalController) {
        this.journalController = journalController;
    }

    @RequestMapping("/journal/view")
    public String showJournalView(Model model) {
        model.addAttribute("records", this.journalController.values());
        return "journal/JournalView";
    }

    @RequestMapping(value = "/journal/delete", method = RequestMethod.GET)
    public String deleteRecordInJournal(@RequestParam("id") Integer id, Model model) {
        this.journalController.delete(id);
        return this.showJournalView(model);
    }


    @RequestMapping(value = "/journal/create", method = RequestMethod.GET)
    public String createRecordInJournal(Model model) {
        model.addAttribute("journal", new Journal());
        model.addAttribute("lectures", this.journalController.valuesLectures());
        model.addAttribute("students", this.journalController.getStudents());
        return "journal/CreateJournal";
    }

    @RequestMapping(value = "/journal/create", method = RequestMethod.POST)
    public String createRecordInJournalFromForm(Journal journal) {
        this.journalController.add(journal);
        return "redirect:/journal/view";
    }

}
