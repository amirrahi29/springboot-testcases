package com.crud.example.demo_crud.Service;

import com.crud.example.demo_crud.service.BlogService;
import com.crud.example.demo_crud.service.DummyService;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

public class DummyServiceTest {

    static int counter = 0;

    @Autowired
    private BlogService blogService;

    @AfterEach
    public void HelloAfterWorld(){
        counter++;
        System.out.println("Hello after call "+counter);
    }

    @Test
    public void addTwoNumbersTest(){
        int result = DummyService.addTwoNumbers(2,5);
        int expectedResult = 7;
        Assertions.assertEquals(expectedResult,result);
    }

    @Test
    public void substractTwoNumbersTest(){
        int result = DummyService.substractTwoNumbers(9,5);
        int expectedResult = 4;
        Assertions.assertEquals(expectedResult,result);
    }

    @BeforeEach
    public void HelloWorld(){
        counter++;
        System.out.println("Hello before call "+counter);
    }

    @BeforeAll
    public static void HelloWorldBeforeFinal(){
        counter++;
        System.out.println("Hello final before call "+new Date());
    }


    @AfterAll
    public static void HelloWorldAfterFinal(){
        counter++;
        System.out.println("Hello final after call "+counter);
    }

}
