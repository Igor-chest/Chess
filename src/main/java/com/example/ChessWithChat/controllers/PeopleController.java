package com.example.ChessWithChat.controllers;

import com.example.ChessWithChat.dto.PersonDTO;
import com.example.ChessWithChat.models.Person;
import com.example.ChessWithChat.services.PersonDetailsService;
import com.example.ChessWithChat.util.PersonErrorResponse;
import com.example.ChessWithChat.util.PersonNotCreatedException;
import com.example.ChessWithChat.util.PersonNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.parameters.P;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/people")
public class PeopleController {

    private final PersonDetailsService personDetailsService;
    private final ModelMapper modelMapper;

    @Autowired
    public PeopleController(PersonDetailsService personDetailsService, ModelMapper modelMapper) {
        this.personDetailsService = personDetailsService;
        this.modelMapper = modelMapper;
    }

    @GetMapping()
    public List<PersonDTO> getPeople() {
        List<PersonDTO> dtoList = personDetailsService
                .findAll()
                .stream()
                .map(this::convertToPersonDTO)
                .collect(Collectors.toList());


        return personDetailsService
                .findAll()
                .stream()
                .map(this::convertToPersonDTO)
                .collect(Collectors.toList()); // Jackson автоматически конвертирует в json
    }

    @GetMapping("/{id}")
    public PersonDTO getPerson(@PathVariable("id") int id) {
        return convertToPersonDTO(personDetailsService.findOne(id));
    }

    @PostMapping// получаем http-запрос от клиента в формате json, и сразу его конвертируем в person
    public ResponseEntity<HttpStatus> create(@Valid @RequestBody PersonDTO personDTO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {

            StringBuilder errorMsg = new StringBuilder();

            List<FieldError> errors = bindingResult.getFieldErrors();
            for(FieldError error : errors) {
                errorMsg.append(error.getField()).append(" - ").append(error.getDefaultMessage()).append(";");
            }

            throw new PersonNotCreatedException(errorMsg.toString());
        }

        personDetailsService.save(convertToPerson(personDTO));

        return ResponseEntity.ok(HttpStatus.OK); // говорим клиенту, что все нормально, получили (статус 200)
    }

    @ExceptionHandler // для отправления exception в json формате
    private ResponseEntity<PersonErrorResponse> handleException(PersonNotFoundException exception) {
        PersonErrorResponse response = new PersonErrorResponse(
                "person width this id wasn't found",
                System.currentTimeMillis()
        );

        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND); // NOT_FOUND - 404 статус
    }

    @ExceptionHandler // для отправления exception в json формате
    private ResponseEntity<PersonErrorResponse> handleException(PersonNotCreatedException exception) {
        PersonErrorResponse response = new PersonErrorResponse(
                exception.getMessage(),
                System.currentTimeMillis()
        );

        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST); // BAD_REQUEST - 400 статус
    }

    private Person convertToPerson(PersonDTO personDTO) {
        return modelMapper.map(personDTO, Person.class);
    }

    private PersonDTO convertToPersonDTO(Person person) {
        return modelMapper.map(person, PersonDTO.class);
    }
}
