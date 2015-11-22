package br.com.jdbc.example;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

	@Autowired
	private IfStoryDAO storyDAO;
	
	@RequestMapping("retrieveDataExample")
	public String retrieveStories(Model model) {
		List<String> components = new ArrayList<>();
		components.add("RAS");
		components.add("EDI");
		List<Story> stories = storyDAO.findStories(components);
		model.addAttribute("stories", stories);
		
		return "list";
	}
	
}
