package org.example.pathvariablevalid;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
class IndexController {
	private final PersonRepository repository;
	private static final Logger LOGGER = LoggerFactory.getLogger(IndexController.class);

	IndexController(PersonRepository repository) {
		this.repository = repository;
	}

	@GetMapping
	ModelAndView joe() {
		return new ModelAndView("index").addObject(repository.findById(1L).get());
	}

	@PostMapping("{person}")
	String joe(/*@PathVariable*/ @Valid Person person, BindingResult bindingResult) {
		LOGGER.info(person.getLastname());
		return "redirect:/";
	}

}
