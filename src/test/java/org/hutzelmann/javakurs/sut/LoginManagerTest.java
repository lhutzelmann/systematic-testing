package org.hutzelmann.javakurs.sut;

import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class LoginManagerTest {

    private LoginManager loginManager;

    @Before
    public void setUp() throws Exception {
        loginManager = new LoginManager("testuser", "12345");
    }

    @Test
    public void successfulLogin(){
        assertTrue(loginManager.login("testuser", "12345"));
    }

    @Test
    public void failedLogin(){
        assertFalse(loginManager.login("testuser", "abcde"));
    }

    @After
    public void tearDown() throws Exception {
        loginManager.logOff();
    }

}