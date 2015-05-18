package fr.xebia;

import net.codestory.http.security.User;

public class XkeUser implements User {

    private final String login;

    public XkeUser(String login) {
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
