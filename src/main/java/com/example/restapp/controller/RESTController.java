package com.example.restapp.controller;

import com.example.restapp.DTO.ElementDTO;
import com.example.restapp.entity.*;
import com.example.restapp.service.ElementService;
import com.example.restapp.service.UserElementService;
import com.example.restapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
public class RESTController {
    @Autowired
    UserService userService;
    @Autowired
    ElementService elementService;
    @Autowired
    UserElementService userElementService;

    @GetMapping("/")
    @ResponseBody
    public String welcome() {
        return "Hello";
    }

    @GetMapping(value = "/addUser", produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public int addUser() {
        User user = new User();
        userService.save(user);
        return user.getID();
    }

    @GetMapping(value = "/users", produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public String allUsers() {
        String userList = userService.findAll().toString();
        return userList;
    }

    @GetMapping(value = "/elements/{elementType}", produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public List<Element> allElements(@PathVariable("elementType") String elementType) {
        List<Element> elements=elementService.findAll();
        if (elementType.equals("circle")){
            elements = elementService.allCircles();
            return elements;
        }else if (elementType.equals("square")){
            elements = elementService.allSquares();
            return elements;
        }else
            return elements;
    }


    @RequestMapping(value = "/addElement", //
            method = RequestMethod.POST, //
            produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public int addElement(@RequestBody ElementDTO elementDTO) {

        if (userService.findById(elementDTO.getId()) != null && (elementDTO.getRadius() != 0) || (elementDTO.getBorderSize() != 0)) {

            if (elementDTO.getBorderSize() == 0) {

                Circle circle = new Circle();
                circle.setRadius(elementDTO.getRadius());
                circle.setName(elementDTO.getName());
                circle.setSquare(Math.PI*Math.pow(circle.getRadius(),2));
                elementService.save(circle);

                UserElement userElement = new UserElement();
                userElement.setElement(circle);
                userElement.setUser(userService.findById(elementDTO.getId()));
                userElementService.save(userElement);

                return circle.getId();
            } else {

                Square square = new Square();
                square.setBorderSize(elementDTO.getBorderSize());
                square.setName(elementDTO.getName());
                square.setSquare(Math.pow(square.getBorderSize(),2));
                elementService.save(square);

                UserElement userElement = new UserElement();
                userElement.setElement(square);
                userElement.setUser(userService.findById(elementDTO.getId()));
                userElementService.save(userElement);

                return square.getId();
            }

        } else {
            return 0;
        }


    }
}


    


