package controller;

import java.util.Hashtable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import model.Person;

import service.PersonService;

@Controller
@RequestMapping("/persons")
public class PersonController {

	@Autowired
	PersonService ps;

	@RequestMapping("/all")
	@ResponseBody
	public Hashtable<String, Person> getAll() {
		return ps.getAll();
	}

	@RequestMapping("{id}")
	public String getPerson(Model model,@PathVariable("id") String id) {
		Person p =  ps.getPerson(id);
		model.addAttribute("person", p);
		return "personview";
	}
	


	@RequestMapping("addformsave")
	public String getPerson(Model model,Person p) {
		System.out.println("Updated first name is "+p.getFirstName());

		System.out.println("Updated last name is "+p.getLastName());

		System.out.println("Updated age is "+p.getAge());
		return "personview";
	}
}

