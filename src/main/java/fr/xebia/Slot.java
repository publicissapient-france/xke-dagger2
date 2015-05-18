package fr.xebia;

import java.time.LocalDate;

public class Slot {

    public final String title;
    public final String pitch;
    public final XkeUser speaker;
    public final LocalDate creationDate;

    public Slot(String title, String pitch, XkeUser speaker, LocalDate creationDate) {
        this.title = title;
        this.pitch = pitch;
        this.speaker = speaker;
        this.creationDate = creationDate;
    }
}
