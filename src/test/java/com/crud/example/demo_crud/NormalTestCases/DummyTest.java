package com.crud.example.demo_crud.NormalTestCases;

import com.crud.example.demo_crud.service.BlogService;
import com.crud.example.demo_crud.service.DummyTestService;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

public class DummyTest {

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
        int result = DummyTestService.addTwoNumbers(2,5);
        int expectedResult = 7;
        Assertions.assertEquals(expectedResult,result);
    }

    @Test
    public void substractTwoNumbersTest(){
        int result = DummyTestService.substractTwoNumbers(9,5);
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

    @Test
    public void arrayCompare(){
        int[] a = {3,4,6,7,8};
        int[] b = {3,4,6,7,8};

        Assertions.assertArrayEquals(a,b);
    }

    @AfterAll
    public static void HelloWorldAfterFinal(){
        counter++;
        System.out.println("Hello final after call "+counter);
    }

    @Test
    public void compareTwoString(){
        String a = "Hello";
        String b = "Hello";
        Assertions.assertEquals(a,b);
    }

    @Test
    public void compareTwoInt(){
        int a = 9;
        int b = 9;
        Assertions.assertEquals(a,b);
    }

}
