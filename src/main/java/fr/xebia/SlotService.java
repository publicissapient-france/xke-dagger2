package fr.xebia;

import static java.time.LocalDate.now;
import java.util.List;

public class SlotService {

    private final SlotDB slotDB;
    private final SlotMailer slotMailer;

    public SlotService(SlotDB slotDB, SlotMailer slotMailer) {
        this.slotDB = slotDB;
        this.slotMailer = slotMailer;
    }

    public List<Slot> all() {
        return slotDB.all();
    }

    public void create(Slot slot) {
        if (slot.title == null || slot.title.trim().isEmpty()){
            throw new IllegalArgumentException("Slot's title should not be null or empty");
        }
        if (slot.pitch == null || slot.pitch.trim().isEmpty()){
            throw new IllegalArgumentException("Slot's pitch should not be null or empty");
        }
        if (slot.speaker == null ){
            throw new IllegalArgumentException("Slot's speaker should not be null");
        }
        if (slot.creationDate == null || slot.creationDate.isBefore(now())){
            throw new IllegalArgumentException("Slot's creationDate should not be null or in the past");
        }
        slotDB.create(slot);
        slotMailer.send(slot);
    }
}
