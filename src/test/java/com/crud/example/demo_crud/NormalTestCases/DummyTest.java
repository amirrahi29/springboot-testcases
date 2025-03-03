package com.crud.example.demo_crud.NormalTestCases;

import com.crud.example.demo_crud.service.BlogService;
import com.crud.example.demo_crud.service.DummyTestService;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

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
//        String a = "Hello";
//        String b = "Hello";

        String name = new String("Hello");
        String expectedName = new String("Hello");
        Assertions.assertEquals(name,expectedName);
    }

    @Test
    public void compareTwoInt(){
        int a = 9;
        int b = 9;
        Assertions.assertEquals(a,b);
    }

    //@Disabled
    @Test
    public void compareConditional(){
        int a = 2;
        int b = 2;
        boolean result = a == b;

        //Assertions.assertTrue(5>4);
        Assertions.assertTrue(result);
    }

    @Test
    public void checkNotNull(){
        //Object data = "null";
        Object data = null;

        //Assertions.assertNotNull(data);
        Assertions.assertNull(data);
    }

    @Test
    public void listCompare(){
        List<Integer> result = Arrays.asList(1,4,5,6,8,9);
        List<Integer> expectedResult = Arrays.asList(1,4,5,6,8,9);
        Assertions.assertIterableEquals(expectedResult,result);
    }

    @Test
    public void throwsErrors(){
        Assertions.assertThrows(RuntimeException.class,()->{

            //comment or uncomment exceptions
           System.out.println("this is testing executables");
           throw new RuntimeException("this is testing exception");
        });
    }

    @ParameterizedTest
    @CsvSource({
            "1,1,2",
            "2,10,12",
            "3,3,6"
    })
    public void test(int a, int b, int expected){
        assertEquals(expected,a+b);
    }


    //also compare many things like list string, list integer, executables etc.

}
