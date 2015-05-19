package fr.xebia;

import java.util.List;
import net.codestory.http.annotations.Get;
import net.codestory.http.annotations.Post;
import net.codestory.http.annotations.Prefix;
import net.codestory.http.payload.Payload;

import javax.inject.Inject;

@Prefix("/slots")
public class SlotResource {

    @Inject SlotService slotService;

    @Get
    public List<Slot> all() {
        return slotService.all();
    }

    @Post
    public Payload create(Slot slot) {
        try {
            slotService.create(slot);
            return Payload.created();
        } catch (IllegalArgumentException e) {
            return new Payload("text/plain", e.getMessage(), 400);
        }
    }
}
