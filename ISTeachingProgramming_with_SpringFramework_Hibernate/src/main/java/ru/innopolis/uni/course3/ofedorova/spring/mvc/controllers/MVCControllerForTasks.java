package ru.innopolis.uni.course3.ofedorova.spring.mvc.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ru.innopolis.uni.course3.ofedorova.constants.MVCControllersCommonFunctions;
import ru.innopolis.uni.course3.ofedorova.common.models.Decision;
import ru.innopolis.uni.course3.ofedorova.common.models.Mark;
import ru.innopolis.uni.course3.ofedorova.common.models.Task;
import ru.innopolis.uni.course3.ofedorova.common.models.User;
import ru.innopolis.uni.course3.ofedorova.services.handlerdecisions.MainServiceForHandlerDecisions;
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
    private final MainServiceForTasks mainServiceTask;
    /**
     * Объект-сервис для работы с решениями.
     */
    private final MainServiceForHandlerDecisions mainServiceDecisions;

    /**
     * Создает новый объект.
     *
     * @param mainService значение поля "mainServiceTask".
     * @param mainServiceForHandlerDecisions значение поля "mainServiceDecisions".
     */
    @Autowired
    public MVCControllerForTasks(MainServiceForTasks mainService, MainServiceForHandlerDecisions mainServiceForHandlerDecisions) {
        this.mainServiceTask = mainService;
        this.mainServiceDecisions = mainServiceForHandlerDecisions;
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
        model.addAttribute("tasks", this.mainServiceTask.values(user.getId()));
        view = "main/tasks/TasksView";
        return view;
    }

    /**
     * Метод отображает представление для выбранного задания.
     *
     * @param model объект модели, связанный с формой.
     * @param idTask    идентификатор задания.
     * @return view для отображения.
     */
    @RequestMapping(value = "/main/tasks/select", method = RequestMethod.GET)
    public String selectTask(Model model, @RequestParam("id") Integer idTask) {
        String view = "";
        User user = MVCControllersCommonFunctions.getUserFromSession();
        Task task = this.mainServiceTask.getById(idTask);
        model.addAttribute("task", task);
        Decision decision = this.mainServiceDecisions.getDecision(user.getId(), idTask);
        Mark mark = this.mainServiceDecisions.getMark(user.getId(), idTask);
        if (decision == null) {
            model.addAttribute("decision", new Decision());
            view = "main/tasks/SelectTask";
        } else {
            model.addAttribute("decision", decision);
            model.addAttribute("mark", mark);
            view = "main/tasks/NotEditableTask";
        }
        return view;
    }
}
