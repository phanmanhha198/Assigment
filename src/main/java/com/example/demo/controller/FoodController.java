package com.example.demo.controller;

import com.example.demo.entity.Food;
import com.example.demo.model.FoodModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Optional;

@Controller
public class FoodController {
    @Autowired
    private FoodModel foodModel;

    @RequestMapping(path = "/food/create", method = RequestMethod.GET)
    public String createFood(Model model) {
        Food p = new Food();
        model.addAttribute("food", p);
        return "food-form";
    }

    @RequestMapping(path = "/food/create", method = RequestMethod.POST)
    public String saveFood(@Valid Food food, BindingResult result) {
        if (result.hasErrors()) {
            return "food-form";
        }

        String date = Calendar.getInstance().getTime().toString();
        food.setTimeCreatedAt(date);
        foodModel.save(food);
        return "redirect:/food/list";
    }

    @RequestMapping(path = "/food/edit/{id}", method = RequestMethod.GET)
    public String editFood(@PathVariable int id, Model model) {
        Optional<Food> optionalProduct = foodModel.findById(id);
        if (optionalProduct.isPresent()) {
            String date = Calendar.getInstance().getTime().toString();
            Food food = new Food();
            food.setTimeEditAt(date);
            model.addAttribute("food", optionalProduct.get());
            return "food-form";
        } else {
            return "not-found";
        }
    }

    @RequestMapping(path = "/food/delete/{id}", method = RequestMethod.POST)
    public String deleteFood(@PathVariable int id) {
        Optional<Food> optionalProduct = foodModel.findById(id);
        if (optionalProduct.isPresent()) {
            optionalProduct.get().setStatus(0);
            foodModel.delete(optionalProduct.get());
            return "redirect:/food/list";
        } else {
            return "not-found";
        }
    }

    @RequestMapping(path = "/food/list", method = RequestMethod.GET)
    public String getListProduct(Model model, @RequestParam(defaultValue = "1") int page, @RequestParam (defaultValue = "5") int limit) {
        model.addAttribute("pagination", foodModel.findAll(PageRequest.of(page - 1, limit)));
        model.addAttribute("page", page);
        model.addAttribute("limit", limit);
        return "food-list";
    }
}