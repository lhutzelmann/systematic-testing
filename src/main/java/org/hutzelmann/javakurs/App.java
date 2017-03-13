package org.hutzelmann.javakurs;

import org.hutzelmann.javakurs.sut.LoginManager;
import org.hutzelmann.javakurs.sut.SessionManager;

/**
 * Hello world!
 *
 */
public class App 
{
    final static String USER = "test";
    final static String PASSWORD = "123";
    public static void main( String[] args )
    {
        String user = args[0];
        System.out.println("user=" + user);
        String password = args[1];
        System.out.println("password=" + password);

        SessionManager sessionManager = new SessionManager(1000);
        String sessionId = sessionManager.startSession();

        LoginManager loginManager = new LoginManager(user, password);
        if (loginManager.login(user, password)){
            while(sessionManager.validateSession(sessionId)){
                System.out.println("Using application...");
                sessionManager.wait(600);
            }
        }
        loginManager.logOff();
        sessionManager.killSession(sessionId);
    }
}
