package fr.xebia;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

public class SlotDB {

    private static final Map<Long, Slot> slots = new HashMap<>();
    private static final AtomicLong idsGenerator = new AtomicLong(0L);

    public List<Slot> all() {
        return new ArrayList<>(slots.values());
    }

    public void create(Slot slot) {
        slots.put(idsGenerator.getAndIncrement(), slot);
    }
}
