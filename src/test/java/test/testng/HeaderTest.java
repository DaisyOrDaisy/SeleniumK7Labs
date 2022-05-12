package test.testng;

import org.testng.annotations.*;

public class HeaderTest {
    @BeforeSuite
    public void beforeSuite(){
        System.out.println("before suite header");
    }
    @BeforeTest
    public void beforeTest(){
        System.out.println("\t=========> before test header");
    }
    @BeforeClass
    public void beforeClass(){
        System.out.println("\t\t=========>before class header");
    }
    @BeforeMethod
    public void beforeMethod(){
        System.out.println("\t\t\t=========> before method header");
    }
    @AfterSuite
    public void afterSuite(){
        System.out.println("after suite header");
    }
    @AfterTest
    public void afterTest(){
        System.out.println("\t=========> after test header");
    }
    @AfterClass
    public void afterClass(){
        System.out.println("\t\t=========>after class header");
    }
    @AfterMethod
    public void afterMethod(){
        System.out.println("\t\t\t=========> after method header");
    }








    @Test
    public void testHeaderHomePage(){
        System.out.println("Header Test | Homepage");

    }


    @Test
    public void testHeaderCategoryPage(){
        System.out.println("Header Test | Category page");

    }
}
