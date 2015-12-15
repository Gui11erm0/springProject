package org.appfuse.tutorial.webapp.controller;

import org.apache.commons.lang.StringUtils;
import org.appfuse.service.GenericManager;
import org.appfuse.tutorial.model.Food;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

@Controller
@RequestMapping("/foodform*")
public class FoodFormController extends BaseFormController {
    private GenericManager<Food, Long> foodManager = null;

    @Autowired
    public void setFoodManager(@Qualifier("foodManager") GenericManager<Food, Long> foodManager) {
        this.foodManager = foodManager;
    }

    public FoodFormController() {
        setCancelView("redirect:foods");
        setSuccessView("redirect:foods");
    }

    @ModelAttribute
    @RequestMapping(method = RequestMethod.GET)
    protected Food showForm(HttpServletRequest request)
    throws Exception {
        String id = request.getParameter("id");

        if (!StringUtils.isBlank(id)) {
            return foodManager.get(new Long(id));
        }

        return new Food();
    }

    @RequestMapping(method = RequestMethod.POST)
    public String onSubmit(Food food, BindingResult errors, HttpServletRequest request)
    throws Exception {
        if (request.getParameter("cancel") != null) {
            return getCancelView();
        }

        if (validator != null) { // validator is null during testing
            validator.validate(food, errors);

            if (errors.hasErrors() && request.getParameter("delete") == null) { // don't validate when deleting
                return "foodform";
            }
        }

        log.debug("entering 'onSubmit' method...");

        boolean isNew = (food.getId() == null);
        String success = getSuccessView();
        Locale locale = request.getLocale();

        if (request.getParameter("delete") != null) {
            foodManager.remove(food.getId());
            saveMessage(request, getText("food.deleted", locale));
        } else {
        	foodManager.save(food);
            String key = (isNew) ? "food.added" : "food.updated";
            saveMessage(request, getText(key, locale));

            if (!isNew) {
                success = "redirect:foodform?id=" + food.getId();
            }
        }

        return success;
    }
}
