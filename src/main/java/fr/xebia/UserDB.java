package fr.xebia;

import javax.inject.Singleton;
import java.util.HashMap;
import java.util.Map;

@Singleton
public class UserDB {

    private static final Map<Long, XkeUser> users = new HashMap<>();

    static {
        users.put(1L, new XkeUser("Jeremie"));
        users.put(2L, new XkeUser("Pierre-Jean"));
    }

    public XkeUser findById(Long id) {
        return users.get(id);
    }
}
