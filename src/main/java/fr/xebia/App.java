package fr.xebia;

import net.codestory.http.WebServer;

public class App {

    public static void main( String[] args ) {
        new WebServer().
                configure(routes -> routes
                                .add(new UserResource())
                                .add(new SlotResource())
                ).start();
    }
}
