package com.example.travelbuddyapps;

import com.example.travelbuddyapps.Activity.Registration;
import com.example.travelbuddyapps.BLL.LoginBLL;
import com.example.travelbuddyapps.BLL.RegistrationBLL;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test

    public void testlogin() {
        LoginBLL loginBLL = new LoginBLL();
        boolean result = loginBLL.signin("Anupama", "123456");
        assertEquals(true, result);
    }

    public void testRegistration() {
        RegistrationBLL RegistrationBLL = new RegistrationBLL();
        boolean result = RegistrationBLL.signup("anupama@gmail.com", "Nepal", "Anupama", "123456");
        assertEquals(true, result);
//    }
}