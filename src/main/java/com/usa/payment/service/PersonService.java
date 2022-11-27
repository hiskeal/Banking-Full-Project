package com.usa.payment.service;


import com.usa.payment.Dto.PersonRequestDto;
import com.usa.payment.Dto.PersonResponseDto;
import com.usa.payment.Dto.ResponseDto;

import com.usa.payment.model.Person;
import com.usa.payment.repository.PersonRepository;

import java.util.ArrayList;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    public ResponseDto savePerson(PersonRequestDto personRequestDto) {
        Person person = new Person();
       // person.setAccountStatus("Active");

        person.setAddress(personRequestDto.getAddress());
        person.setAge(personRequestDto.getAge());
        person.setAddress(personRequestDto.getAddress());
        person.setDateOfBirth(personRequestDto.getDateOfBirth());
        person.setEmail(personRequestDto.getEmail());
        person.setFirstName(personRequestDto.getFirstName());
        person.setMiddleName(personRequestDto.getMiddleName());
        person.setLastName(personRequestDto.getLastName());
        person.setPhoneNumber(personRequestDto.getPhoneNumber());
        person.setDepartment(personRequestDto.getDepartment());
        personRepository.save(person);

        return new ResponseDto(true, "Registered Successfully");
    }

    public ResponseDto updatePerson(PersonRequestDto personRequestDto, Long id) {

        Person person = personRepository.findById(id).get();

        person.setAddress(personRequestDto.getAddress());
        person.setAge(personRequestDto.getAge());
        person.setDateOfBirth(personRequestDto.getDateOfBirth());
        person.setDepartment(personRequestDto.getDepartment());
        person.setEmail(personRequestDto.getEmail());
        person.setFirstName(personRequestDto.getFirstName());
        person.setMiddleName(personRequestDto.getMiddleName());
        person.setLastName(personRequestDto.getLastName());
        person.setPhoneNumber(personRequestDto.getPhoneNumber());

        personRepository.save(person);
        return new ResponseDto(true, "Updated Method");

    }

    public ResponseDto deletePersonById(Long id) {
        personRepository.deleteById(id);

        return new ResponseDto(true, "deleted successfully");
    }

    public Person getPersonById(Long id) {
       return personRepository.findById(id).get();

      //   return new ResponseDto(true, "Get Each Result By Id");

    }

    public List<Person> ListAll() {
        List<PersonResponseDto> personResponseDto = new ArrayList<>();
        return (List<Person>) personRepository.findAll();
    }
//
//    public ResponseDto active(Long id) {
//        Account account = accountRepository.findById(id).get();
//        if (account.getAccountStatus().equals("Activate")){
//            account.setAccountStatus("Deactivate");
//        } else if (account.getAccountStatus().equals("Deactivate")) {
//            account.setAccountStatus("Activate");
//        }
//
//        accountRepository.save(account);
//        return new ResponseDto(true, "Active or Deactivate");
//
//    }
}
