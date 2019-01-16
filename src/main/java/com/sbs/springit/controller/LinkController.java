package com.sbs.springit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.sbs.springit.repository.LinkRepository;

//@RestController
//@RequestMapping("/links")
@Controller
public class LinkController {
	
	private LinkRepository linkRepository;

    public LinkController(LinkRepository linkRepository) {
		this.linkRepository = linkRepository;
	}
    
    @GetMapping("/foo")
    public String foo(Model model) {
    	model.addAttribute("pageTitle","This page is FOO!");
    	return "foo";
    }

	/*// list
	@GetMapping("/")
    public List<Link> list() {
        return linkRepository.findAll();
    }

    // CRUD
	@PostMapping("/create")
    public Link create(@ModelAttribute Link link) {
        return linkRepository.save(link);
    }
	
	@GetMapping("/{id}")
    public Optional<Link> read(@PathVariable Long id) {
        return linkRepository.findById(id);
    }
	
	@PutMapping("/{id}")
    public Link update(@PathVariable Long id, @ModelAttribute Link link) {
        return linkRepository.save(link);
    }
    
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
    	linkRepository.deleteById(id);
    }*/
}