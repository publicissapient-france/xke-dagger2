package fr.xebia;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import net.codestory.http.security.User;

public class XkeUser implements User {

    private final String login;

    @JsonCreator
    public XkeUser(@JsonProperty("login") String login) {
        this.login = login;
    }

    @Override
    public String login() {
        return login;
    }

    @Override
    public String[] roles() {
        return new String[0];
    }
}
