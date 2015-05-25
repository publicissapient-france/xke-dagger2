package fr.xebia;

import net.codestory.http.WebServer;

public class App {

    private final UserResource userResource = new UserResource();
    private final SlotResource slotResource = new SlotResource();

    public static void main( String[] args ) {
        new App().start();
    }

    private void start() {
        new WebServer().
                configure(routes -> routes
                                .add(userResource)
                                .add(slotResource)
                ).start();
    }
}
