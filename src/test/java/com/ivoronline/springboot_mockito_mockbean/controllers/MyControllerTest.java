package com.ivoronline.springboot_mockito_mockbean.controllers;

import com.ivoronline.springboot_mockito_mockbean.entities.Person;
import com.ivoronline.springboot_mockito_mockbean.repositories.PersonRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.mockito.Mock;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MyControllerTest {

  //MOCK DEPENDENCY CLASS
  @MockBean PersonRepository personRepositoryMock;

  //INJECT MOCKS (where @autowired is used)
  @Autowired MyController myController;

  @Test
  void getPerson() {

    //MOCK METHOD: getPersonById(1)
    when(personRepositoryMock.getPersonById(1)).thenReturn(new Person(1, "Susan", 50));

    //TEST CONTROLLER'S ENDPOINT
    String result = myController.getPerson(1);

    //TEST RESULT
    assertEquals("Susan is 50 years old", result);

  }

}
