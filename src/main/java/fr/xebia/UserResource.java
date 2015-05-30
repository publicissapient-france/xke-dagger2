package fr.xebia;

import net.codestory.http.annotations.Get;
import net.codestory.http.annotations.Prefix;

import javax.inject.Inject;

@Prefix("/users")
public class UserResource {

    private final UserDB userDB;
    private final Mailer mailer;
    @Inject
    public UserResource(UserDB userDB, Mailer mailer) {
        this.userDB = userDB;
        this.mailer = mailer;
    }

    @Get("/:id")
    public XkeUser findById(Long id) {
        XkeUser user = userDB.findById(id);
        mailer.send(user);
        return user;
    }
}
