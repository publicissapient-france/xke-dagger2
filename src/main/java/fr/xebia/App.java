package fr.xebia;

import static java.lang.Long.parseLong;
import net.codestory.http.WebServer;
import net.codestory.http.payload.Payload;

public class App {

    public static void main( String[] args ) {

        UserDB userDB = new UserDB();
        SlotDB slotDB = new SlotDB();

        new WebServer().
                configure(routes -> routes
                                .get("/users/:id", (context, id) -> userDB.findById(parseLong(id)))

                                .url("/slots")
                                    .get((context) -> {
                                        return slotDB.all();
                                    })
                                    .post((context) -> {
                                        Slot slot = context.extract(Slot.class);
                                        slotDB.create(slot);
                                        return Payload.created();
                                    })

                ).start();
    }
}
