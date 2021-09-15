package com.codegym.kiemtramodule4.controller;

import com.codegym.kiemtramodule4.model.City;
import com.codegym.kiemtramodule4.model.Water;
import com.codegym.kiemtramodule4.service.ICityService;
import com.codegym.kiemtramodule4.service.IWaterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
public class CityController {
    @Autowired
    ICityService cityService;
    @Autowired
    IWaterService waterService;

    @GetMapping("/home")
    public ModelAndView show(){
        ModelAndView modelAndView = new ModelAndView("home");
        modelAndView.addObject("city",cityService.findAll());
        return modelAndView;
    }
    @ModelAttribute("listWater")
    public Iterable<Water> showWater(){
        return waterService.findAll();
    }
    @GetMapping("/create")
    public ModelAndView showFormCreate(){
        ModelAndView modelAndView = new ModelAndView("/create");
        modelAndView.addObject("city",new City());
        return modelAndView;
    }
    @GetMapping("/edit/{id}")
    public ModelAndView ShowFormEdit(@PathVariable long id){
        ModelAndView modelAndView = new ModelAndView("/edit");
        modelAndView.addObject("city",cityService.findById(id));
        return modelAndView;
    }

    @GetMapping("/delete/{id}")
    public ModelAndView showFormDelete(@PathVariable long id){
        ModelAndView modelAndView = new ModelAndView("delete");
        modelAndView.addObject("city",cityService.findById(id).get());
        return modelAndView;
    }
    @GetMapping("/findByName")
    public ModelAndView findByName(@RequestParam("findName") String name) {
        ModelAndView modelAndView = new ModelAndView("home");
        modelAndView.addObject("city", cityService.findByName(name));
        return modelAndView;
    }
    @GetMapping("/view/{id}")
    public ModelAndView showFormView(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView("view");
        modelAndView.addObject("city", cityService.findById(id).get());
        return modelAndView;

    }
    @PostMapping("/create")
    public ModelAndView create( @Valid @ModelAttribute City city,BindingResult bindingResult) {
        if (bindingResult.hasFieldErrors()) {
            ModelAndView modelAndView = new ModelAndView("create");
            modelAndView.addObject("city",city);
            return modelAndView;
        }
        cityService.save(city);
        ModelAndView modelAndView = new ModelAndView("redirect:/home");
        return modelAndView;
    }

    @PostMapping("/edit/{id}")
    public ModelAndView edit(@Valid @ModelAttribute City city,BindingResult bindingResult) {
        if (bindingResult.hasFieldErrors()) {
            ModelAndView modelAndView = new ModelAndView("edit");
            modelAndView.addObject("city",city);
            return modelAndView;
        }
        cityService.save(city);
        return new ModelAndView( "redirect:/home");
    }

    @PostMapping("/delete/{id}")
    public String delete(@PathVariable long id) {
        cityService.delete(cityService.findById(id).get());
        return "redirect:/home";
    }










}
