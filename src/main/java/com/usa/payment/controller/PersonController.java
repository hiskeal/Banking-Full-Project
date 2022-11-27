package com.usa.payment.controller;

import com.usa.payment.Dto.PersonRequestDto;
import com.usa.payment.Dto.ResponseDto;
import com.usa.payment.model.Person;
import com.usa.payment.service.PersonService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RestController
@RequestMapping("/api")
public class PersonController {

    @Autowired
    private PersonService personService;

    @PostMapping("/savePerson")
    public ResponseDto savePerson(@RequestBody PersonRequestDto personRequestDto) {
        return personService.savePerson(personRequestDto);

    }

    @PutMapping("/updatePerson/{id}")
    public ResponseDto updatePerson(@RequestBody PersonRequestDto personRequestDto, @PathVariable Long id) {
        return personService.updatePerson(personRequestDto, id);

    }

    @DeleteMapping("/deletePerson/{id}")
    public ResponseDto deletePersonById(@PathVariable("id") Long id) {
        return  personService.deletePersonById(id);


    }

    @GetMapping("/listPerson")
    public List<Person> ListAll() {
        return personService.ListAll();
    }

    @GetMapping("/getPerson/{id}")
    public Person getPerson(@PathVariable Long id) {
       return  personService.getPersonById(id);


    }
//
//    @PutMapping("/active/{id}")
//    public ResponseDto active(@PathVariable Long id) {
//        return accountService.active(id);
//    }
}
