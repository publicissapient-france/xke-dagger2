package fr.xebia;

import net.codestory.http.annotations.Get;
import net.codestory.http.annotations.Prefix;

@Prefix("/users")
public class UserResource {

    private final UserDB userDB = new UserDB();
    private final Mailer mailer = new Mailer();

    @Get("/:id")
    public XkeUser findById(Long id) {
        XkeUser user = userDB.findById(id);
        mailer.send(user);
        return user;
    }
}
