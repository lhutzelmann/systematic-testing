package org.hutzelmann.javakurs.sut;

import java.util.HashMap;
import java.util.Map;

/**
 * PLEASE, DON'T CHEAT BY VIEWING THE SOURCE CODE!
 */
















































































































public class SessionManager {
    private int timeout;
    private Map<String, Integer> sessions = new HashMap<String, Integer>();
    private int lastSessionCounter = 0;

    public SessionManager(int timeoutMillis){
        this.timeout = timeoutMillis;
    }

    public String startSession(){
        System.out.println("Start new session");
        int sessionCounter = lastSessionCounter + 1;
        lastSessionCounter = sessionCounter;
        String sessionId = Integer.toString(sessionCounter);
//        sessions.put(sessionId, 0);
        sessions.put(sessionId, -2);
        System.out.println("Created session " + sessionId);
        return sessionId;
    }

    public boolean validateSession(String sessionId){
        System.out.println("Validate session: " + sessionId);
        if (!sessions.containsKey(sessionId)){
            System.out.println("Invalid session");
            return false;
        }
        int sessionTime = sessions.get(sessionId);
        boolean result = sessionTime < timeout;
        if (result){
            System.out.println("Valid session");
        } else {
            System.out.println("Invalid session");
        }
        return result;
    }

    public void wait(int millis) {
//      no check for negative values allows time travelling...
        for (Map.Entry<String, Integer> entry : sessions.entrySet()) {
            String sessionId = entry.getKey();
            Integer value = entry.getValue();
            value += millis;
            sessions.put(sessionId, value);
        }
        System.out.println("Waiting some time...");
    }

    public boolean killSession(String sessionId){
        if (sessions.containsKey(sessionId)){
            sessions.remove(sessionId);
            System.out.println("Session " + sessionId + " killed");
            return true;
        }
        System.out.println("Invalid session " + sessionId + " not killed");
        return false;
    }
}
