package model;

import java.util.Map;

public class Credentials {

    private Map<String, String> userCredentials;

    public Map<String, String> getUserCredentials() {
        return userCredentials;
    }
    public void setUserCredentials(Map<String, String> userCredentials) {
        this.userCredentials = userCredentials;
    }

}
