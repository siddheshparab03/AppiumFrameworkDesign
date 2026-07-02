package org.rahulshettyacademy;

import org.rahulshettyacademy.TestUtils.AndroidBaseTest;
import org.testng.annotations.Test;

public class ecommerce_tc_1 extends AndroidBaseTest {

    @Test
    public void fillForm(){

        formPage.setNameField("Rahul Shetty");
        formPage.setGender("female");
        formPage.setCountrySelection("Argentina");
        formPage.submitForm();

    }


}
