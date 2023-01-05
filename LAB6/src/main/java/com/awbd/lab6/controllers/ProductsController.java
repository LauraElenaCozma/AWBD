package com.awbd.lab6.controllers;


import com.awbd.lab6.domain.Product;
import com.awbd.lab6.services.CategoryService;
import com.awbd.lab6.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class ProductsController {

    @Autowired
    ProductService productService;

    @Autowired
    CategoryService categoryService;

/*
    @RequestMapping("/product/list")
    public String productsList(  Model model ){
        List<Product> products = productService.findAll();
        model.addAttribute("products", products);
        return "products";
    }
    */


    @RequestMapping("/product/list")
    public ModelAndView productsList() {
        ModelAndView modelAndView = new ModelAndView("products");
        List<Product> products = productService.findAll();
        modelAndView.addObject("products", products);
        return modelAndView;
    }

    @GetMapping("product/info/{id}")
    public String showById(@PathVariable String id, Model model) {
        model.addAttribute("product", productService.findById(Long.valueOf(id)));
        return "info";
    }

    @RequestMapping("product/delete/{id}")
    public String deleteById(@PathVariable String id) {

        productService.deleteById(Long.valueOf(id));
        return "redirect:/product/list";
    }


    @RequestMapping("product/new")
    public String newProduct(Model model) {
        model.addAttribute("product", new Product());
        model.addAttribute("categoriesAll", categoryService.findAll());
        return "productform";
    }

    @PostMapping("/product")
    public String saveOrUpdate(@ModelAttribute Product product) {
        Product savedProduct = productService.save(product);
        //return "redirect:/product/info/" + savedProduct.getId();
        return "redirect:/product/list";
    }


}
