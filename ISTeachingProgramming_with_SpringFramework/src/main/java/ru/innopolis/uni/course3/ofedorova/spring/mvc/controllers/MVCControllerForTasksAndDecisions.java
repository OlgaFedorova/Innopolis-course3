package ru.innopolis.uni.course3.ofedorova.spring.mvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ru.innopolis.uni.course3.ofedorova.dao.exceptions.DAOtoDecisionsException;
import ru.innopolis.uni.course3.ofedorova.dao.exceptions.DAOtoMarksException;
import ru.innopolis.uni.course3.ofedorova.dao.exceptions.DAOtoTasksException;
import ru.innopolis.uni.course3.ofedorova.models.Decision;
import ru.innopolis.uni.course3.ofedorova.models.Task;
import ru.innopolis.uni.course3.ofedorova.models.User;
import ru.innopolis.uni.course3.ofedorova.services.main.MainServiceForDecisionsAndMarks;
import ru.innopolis.uni.course3.ofedorova.services.main.MainServiceForTasks;

import javax.servlet.http.HttpSession;

/**
 * Spring-контроллер для работы с задачами и обработкой решений.
 *
 * @author Olga Fedorova
 * @version 1.0
 * @since 09.01.2017
 */
@Controller
public class MVCControllerForTasksAndDecisions {
    /**
     * Объект-сервис для работы с данными заданий.
     */
    private final MainServiceForTasks mainService;
    /**
     * Объект-работы для работы с данными решений.
     */
    private final MainServiceForDecisionsAndMarks mainServiceForDecisionsAndMarks;

    /**
     * Создает новый объект.
     *
     * @param mainService значение поля "mainService".
     * @param mainServiceForDecisionsAndMarks  значение поля "mainServiceForDecisionsAndMarks".
     */
    public MVCControllerForTasksAndDecisions(MainServiceForTasks mainService, MainServiceForDecisionsAndMarks mainServiceForDecisionsAndMarks) {
        this.mainService = mainService;
        this.mainServiceForDecisionsAndMarks = mainServiceForDecisionsAndMarks;
    }

    /**
     * Метод возвращает представление для отображения списка заданий.
     *
     * @param session http-сессия.
     * @param model   объект модели, связанный с формой.
     * @return view для отображения.
     */
    @RequestMapping(value = "/main/tasks/view")
    public String viewTasks(HttpSession session, Model model) {
        String view = "";
        try {
            User user = MVCControllersCommon.getUserFromSession(session);
            model.addAttribute("tasks", this.mainService.values(user.getId()));
            view = "main/tasks/TasksView";
        } catch (DAOtoTasksException e) {
            view = MVCControllersCommon.redirectErrorPage();
        }
        return view;
    }

    /**
     * Метод отображает представление для выбранного задания.
     *
     * @param session http-сессия.
     * @param model   объект модели, связанный с формой.
     * @param id      идентификатор задания.
     * @return view для отображения.
     */
    @RequestMapping(value = "/main/tasks/select", method = RequestMethod.GET)
    public String selectTask(HttpSession session, Model model, @RequestParam("id") Integer id) {
        String view = "";
        try {
            User user = MVCControllersCommon.getUserFromSession(session);
            Task task = this.mainService.getById(id, user.getId());
            if (task == null) {
                view = MVCControllersCommon.redirectErrorPage();
            } else {
                model.addAttribute("task", task);
                if (task.getDecision() == null) {
                    model.addAttribute("decision", new Decision());
                    view = "main/tasks/SelectTask";
                } else {
                    view = "main/tasks/NotEditableTask";
                }
            }
        } catch (DAOtoTasksException e) {
            view = MVCControllersCommon.redirectErrorPage();
        }
        return view;
    }

    /**
     * Метод обрабатывает решение для выбранного задания.
     *
     * @param session http-сессия.
     * @param decision   объект решения, связанный с формой.
     * @param id      идентификатор задания.
     * @return view для отображения.
     */
    @RequestMapping(value = "/main/tasks/select", method = RequestMethod.POST)
    public String sendDecision(HttpSession session, Decision decision, @RequestParam("id") Integer id) {
        String view = "";
        try {
            User user = MVCControllersCommon.getUserFromSession(session);
               if (decision.getDecision() != null && !decision.getDecision().isEmpty()) {
                    this.mainServiceForDecisionsAndMarks.add(id, user.getId(), decision.getDecision());
                }
                view = String.format("main/tasks/select?id=%s", id);
        } catch (DAOtoDecisionsException | DAOtoMarksException e) {
            view = MVCControllersCommon.redirectErrorPage();
        }
        return view;
    }
}
