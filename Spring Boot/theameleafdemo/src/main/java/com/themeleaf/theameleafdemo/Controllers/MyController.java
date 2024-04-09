package com.themeleaf.theameleafdemo.Controllers;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.fasterxml.jackson.annotation.JsonCreator.Mode;

@Controller
public class MyController {

    @GetMapping("/home")
    public String show(Model model)
    {
        System.out.println("First thymeleaf program..");
        model.addAttribute("name","Sudarshan Pansare");
        model.addAttribute("currentDate", new Date().toString());
        return "home";
    }

    @GetMapping("/loop")
    public String itrator(Model model)
    {
        List<String> names = List.of("ram","shyam","geeta","sita","kiran");
        model.addAttribute("names",names);
        return "iterator";
    }

    //condition Handler
    @GetMapping("/condition")
    public String Condition(Model model)
    {
        model.addAttribute("isActive", false);
        model.addAttribute("gender", "M");

        List<Integer> list = List.of(1,2,3);
        model.addAttribute("mylist", list);
        System.out.println("condition handler called....");
        return "condition";
    }

    @GetMapping("/fragements")
    public String Services(Model m)
    {
        
        return "services";
    }



    
}
