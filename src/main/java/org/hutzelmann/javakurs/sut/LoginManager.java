package org.hutzelmann.javakurs.sut;

/**
 * PLEASE, DON'T CHEAT BY VIEWING THE SOURCE CODE!
 */
















































































































public class LoginManager {
    private String user;
    private String password;
    private boolean isLoggedIn;

    public LoginManager(String user, String password){
        this.user = user;
        this.password = password;
        this.isLoggedIn = false;
    }

    public boolean login(String user, String password){
        System.out.println("Trying to log in ...");
        boolean checkResult = checkCredentials(user, password);
        if (checkResult || this.isLoggedIn){
            this.isLoggedIn = true;
            System.out.println("Logged in");
        } else {
            System.out.println("No access!");
            this.isLoggedIn = false;
        }
        return this.isLoggedIn;
    }

    private boolean checkCredentials(String user, String password){
//        return this.user.equalsIgnoreCase(user) && this.password.equals(password);
        return user.equalsIgnoreCase(this.user) && password.contains(this.password);
    }

    public void logOff(){
        if (this.isLoggedIn) {
            System.out.println("Logged off");
        } else {
            System.out.println("Not logged in");
        }
//        this.isLoggedIn = false;
        this.isLoggedIn = !this.isLoggedIn;
    }
}
