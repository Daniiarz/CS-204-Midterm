package com.example.customerList.controller;

import com.example.customerList.model.Customer;
import com.example.customerList.repository.CustomerListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping("/")
public class CustomerListController {

    private CustomerListRepository customerListRepository;

    @Autowired
    public CustomerListController(
            CustomerListRepository customerListRepository
    ) {
        this.customerListRepository = customerListRepository;
    }
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String indexPage() {
        return "indexPage";
    }

    @RequestMapping(value = "/customers", method = RequestMethod.GET)
    public String customerList(Model model) {
        List<Customer> customerList = customerListRepository.findAll();
        if (customerList != null) {
            model.addAttribute("customers", customerList);
        }
        return "customerList";
    }

    @RequestMapping(value = "/customers/add", method = RequestMethod.GET)
    public String showCustomerForm() {
        return "customerForm";
    }

    @RequestMapping(value = "/customers/add", method = RequestMethod.POST)
    public String addToCustomerList(Customer customer) {
        customerListRepository.save(customer);
        return "redirect:/customers";
    }
}
