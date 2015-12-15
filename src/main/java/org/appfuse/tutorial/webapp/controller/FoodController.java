package org.appfuse.tutorial.webapp.controller;

import org.appfuse.service.GenericManager;
import org.appfuse.tutorial.model.Food;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/foods*")
public class FoodController {
    private GenericManager<Food, Long> foodManager;

    @Autowired
    public void setFoodManager(@Qualifier("foodManager") GenericManager<Food, Long> foodManager) {
        this.foodManager = foodManager;
    }
    //Este MVC esta pegado al servicio
    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView handleRequest()
    throws Exception {
        return new ModelAndView().addObject(foodManager.getAll());
    }
    //ese metodo de arriba lista todo con el getAll
}