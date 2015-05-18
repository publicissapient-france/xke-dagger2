package fr.xebia;

import java.time.LocalDate;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Slot {

    public final String title;
    public final String pitch;
    public final XkeUser speaker;
    public final LocalDate creationDate;

    @JsonCreator
    public Slot(@JsonProperty("title") String title,
                @JsonProperty("pitch") String pitch,
                @JsonProperty("speaker") XkeUser speaker,
                @JsonProperty("creationDate") LocalDate creationDate) {
        this.title = title;
        this.pitch = pitch;
        this.speaker = speaker;
        this.creationDate = creationDate;
    }
}
