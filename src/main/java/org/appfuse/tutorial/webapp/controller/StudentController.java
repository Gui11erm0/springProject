package org.appfuse.tutorial.webapp.controller;

import org.appfuse.service.GenericManager;
import org.appfuse.tutorial.model.Person;
import org.appfuse.tutorial.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/students*")
public class StudentController {
	private GenericManager<Student, Long> studentManager;

	@Autowired
	public void setPersonManager(@Qualifier("studentManager") GenericManager<Student, Long> studentManager) {
		this.studentManager = studentManager;
	}

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView handleRequest() throws Exception {
		return new ModelAndView().addObject(studentManager.getAll());
	}
}
