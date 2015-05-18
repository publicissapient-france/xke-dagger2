package fr.xebia;

import static java.lang.Long.parseLong;
import net.codestory.http.WebServer;
import net.codestory.http.payload.Payload;

public class App {

    public static void main( String[] args ) {

        UserDB userDB = new UserDB();
        SlotService slotService = new SlotService(new SlotDB(), new SlotMailer());

        new WebServer().
                configure(routes -> routes
                                .get("/users/:id", (context, id) -> userDB.findById(parseLong(id)))

                                .url("/slots")
                                    .get((context) -> {
                                        return slotService.all();
                                    })
                                    .post((context) -> {
                                        try {
                                            slotService.create(context.extract(Slot.class));
                                        } catch (IllegalArgumentException e) {
                                            return new Payload("text/plain", e.getMessage(), 400);
                                        }
                                        return Payload.created();
                                    })

                ).start();
    }
}
