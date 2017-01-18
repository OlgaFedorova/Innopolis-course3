package ru.innopolis.uni.course3.ofedorova.spring.mvc.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ru.innopolis.uni.course3.ofedorova.constants.MVCControllersCommonFunctions;
import ru.innopolis.uni.course3.ofedorova.models.Decision;
import ru.innopolis.uni.course3.ofedorova.models.Task;
import ru.innopolis.uni.course3.ofedorova.models.User;
import ru.innopolis.uni.course3.ofedorova.services.tasks.MainServiceForTasks;

/**
 * Spring-контроллер для работы с задачами пользователя.
 *
 * @author Olga Fedorova
 * @version 1.0
 * @since 09.01.2017
 */
@Controller
public class MVCControllerForTasks {
    /**
     * Объект-сервис для работы с данными заданий.
     */
    private final MainServiceForTasks mainService;

    /**
     * Создает новый объект.
     *
     * @param mainService значение поля "mainService".
     */
    @Autowired
    public MVCControllerForTasks(MainServiceForTasks mainService) {
        this.mainService = mainService;
    }

    /**
     * Метод возвращает представление для отображения списка заданий.
     *
     * @param model объект модели, связанный с формой.
     * @return view для отображения.
     */
    @RequestMapping(value = "/main/tasks/view")
    public String viewTasks(Model model) {
        String view = "";
        User user = MVCControllersCommonFunctions.getUserFromSession();
        model.addAttribute("tasks", this.mainService.values(user.getId()));
        view = "main/tasks/TasksView";
        return view;
    }

    /**
     * Метод отображает представление для выбранного задания.
     *
     * @param model объект модели, связанный с формой.
     * @param id    идентификатор задания.
     * @return view для отображения.
     */
    @RequestMapping(value = "/main/tasks/select", method = RequestMethod.GET)
    public String selectTask(Model model, @RequestParam("id") Integer id) {
        String view = "";
        /*User user = MVCControllersCommonFunctions.getUserFromSession();
        Task task = this.mainService.getById(id, user.getId());
        model.addAttribute("task", task);
        if (task.getDecision() == null) {
            model.addAttribute("decision", new Decision());
            view = "main/tasks/SelectTask";
        } else {
            view = "main/tasks/NotEditableTask";
        }*/
        return view;
    }
}
