package test.testng;

import org.testng.annotations.*;

public class FooterTest {
    @BeforeSuite
    public void beforeSuite(){
        System.out.println("before suite footer");
    }
    @BeforeTest
    public void beforeTest(){
        System.out.println("\t=========> before test footer");
    }
    @BeforeClass
    public void beforeClass(){
        System.out.println("\t\t=========>before class footer");
    }
    @BeforeMethod
    public void beforeMethod(){
        System.out.println("\t\t\t=========> before method footer");
    }
    @AfterSuite
    public void afterSuite(){
        System.out.println("after suite footer");
    }
    @AfterTest
    public void afterTest(){
        System.out.println("\t=========> after test footer");
    }
    @AfterClass
    public void afterClass(){
        System.out.println("\t\t=========>after class footer");
    }
    @AfterMethod
    public void afterMethod(){
        System.out.println("\t\t\t=========> after method footer");
    }

    @Test
    public void testFooterHomePage(){
        System.out.println("Footer Test | Homepage");

    }

    @Test
    public void testFooterCategoryPage(){
        System.out.println("Footer Test | Category page");

    }
}
