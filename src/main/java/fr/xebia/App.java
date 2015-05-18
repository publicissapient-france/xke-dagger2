package fr.xebia;

import net.codestory.http.WebServer;

public class App {

    public static void main( String[] args ) {

        UserDB userDB = new UserDB();
        SlotService slotService = new SlotService(new SlotDB(), new SlotMailer());

        new WebServer().
                configure(routes -> routes
                                .add(new UserResource(userDB))
                                .add(new SlotResource(slotService))
                ).start();
    }
}
