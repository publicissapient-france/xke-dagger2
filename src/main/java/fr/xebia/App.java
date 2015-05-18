package fr.xebia;

import net.codestory.http.WebServer;

public class App {

    public static void main( String[] args ) {
        new WebServer().
                configure(routes -> routes
                                .add(new UserResource(new UserDB()))
                                .add(new SlotResource(new SlotService(new SlotDB(), new SlotMailer())))
                ).start();
    }
}
