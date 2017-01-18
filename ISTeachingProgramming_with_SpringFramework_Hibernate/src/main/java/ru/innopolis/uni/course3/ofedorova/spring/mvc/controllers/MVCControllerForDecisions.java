package ru.innopolis.uni.course3.ofedorova.spring.mvc.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ru.innopolis.uni.course3.ofedorova.constants.MVCControllersCommonFunctions;
import ru.innopolis.uni.course3.ofedorova.models.Decision;
import ru.innopolis.uni.course3.ofedorova.models.Task;
import ru.innopolis.uni.course3.ofedorova.models.User;
import ru.innopolis.uni.course3.ofedorova.services.handlerdecisions.MainServiceForHandlerDecisions;

/**
 * Spring-контроллер для обработки решений задач.
 *
 * @author Olga Fedorova
 * @version 1.0
 * @since 09.01.2017
 */
@Controller
public class MVCControllerForDecisions {
    /**
     * Объект-сервис для работы с решениями.
     */
    private final MainServiceForHandlerDecisions mainService;

    /**
     * Создает новый объект.
     *
     * @param mainServiceForHandlerDecisions значение поля "mainService".
     */
    @Autowired
    public MVCControllerForDecisions(MainServiceForHandlerDecisions mainServiceForHandlerDecisions) {
        this.mainService = mainServiceForHandlerDecisions;
    }

    /**
     * Метод обрабатывает решение для выбранного задания.
     *
     * @param decision объект решения, связанный с формой.
     * @param task      заданиe.
     * @return view для отображения.
     */
    @RequestMapping(value = "/main/tasks/select", method = RequestMethod.POST)
    public String sendDecision(Decision decision, @RequestParam("task") Task task) {
        String view = "";
        User user = MVCControllersCommonFunctions.getUserFromSession();
        if (decision.getDecision() != null && !decision.getDecision().isEmpty()) {
            decision.setUser(user);
            decision.setTask(task);
            this.mainService.add(decision);
        }
        view = String.format("redirect:/main/tasks/select?id=%s", task.getId());
        return view;
    }
}
