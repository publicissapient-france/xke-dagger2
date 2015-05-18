package fr.xebia;

import static java.lang.String.format;

public class SlotMailer {

    public void send(Slot slot) {
        System.out.println(
                format("New Slot:\n- title: %s,\n- pitch: %s,\n- speaker: %s,\n- creation date: %s.",
                        slot.title,
                        slot.pitch,
                        slot.speaker,
                        slot.creationDate
                )
        );
    }
}
