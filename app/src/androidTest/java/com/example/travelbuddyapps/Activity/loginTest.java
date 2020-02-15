package com.example.travelbuddyapps.Activity;

import org.hamcrest.Matchers;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import androidx.test.rule.ActivityTestRule;

import com.example.travelbuddyapps.R;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.RootMatchers.withDecorView;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

public class loginTest {

    @Rule
    public ActivityTestRule<login> testRule = new ActivityTestRule<>(login.class);

    login login = null;
    @Before
    public void setUp() throws Exception {
        login = testRule.getActivity();
    }

    @Test
    public void ComponentsTest(){
        assertNotNull(login.etusername);
        assertNotNull(login.etpassword);

    }

    @Test
    public void LoginUItest(){

        onView(withId(R.id.etUser))
                .perform(typeText("Anupama"));
        onView(withId(R.id.etPass))
                .perform(typeText("123456"));

        closeSoftKeyboard();

        onView(withId(R.id.login))
                .perform(click());

        onView(withText("Login success")).
                inRoot(withDecorView(Matchers.not(is(login.getWindow().getDecorView())))).
                check(matches(isDisplayed()));
    }

    @After
    public void tearDown() throws Exception {
    }
}