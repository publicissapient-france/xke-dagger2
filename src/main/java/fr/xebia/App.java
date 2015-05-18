package fr.xebia;

import static java.time.LocalDate.now;
import net.codestory.http.WebServer;
import net.codestory.http.payload.Payload;

public class App {

    public static void main( String[] args ) {
        new WebServer().
                configure(routes -> routes
                        .get("/users/1", new XkeUser("Jérémie"))

                        .url("/slots")
                            .get((context) -> {
                                return new Slot("Dagger 2", "Super slot sur la nouvelle version de Dagger !", new XkeUser("Pierre-Jean"), now());
                            })
                            .post((context) -> {
                                new Slot("Dagger 2", "Super slot sur la nouvelle version de Dagger !", new XkeUser("Pierre-Jean"), now());
                                return Payload.created();
                            })

                ).start();
    }
}
