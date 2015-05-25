package fr.xebia;

import net.codestory.http.annotations.Get;
import net.codestory.http.annotations.Prefix;

import javax.inject.Inject;

@Prefix("/users")
public class UserResource {

    private final UserDB userDB;

    @Inject
    public UserResource(UserDB userDB) {
        this.userDB = userDB;
    }

    @Get("/:id")
    public XkeUser findById(Long id) {
        return userDB.findById(id);
    }
}
