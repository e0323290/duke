import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EventTest {
    private Event eventTest = new Event("meeting", "12/12/2019 1800");
    @Test
    void getDescriptionTest() {
        assertEquals("[E][\u2718] meeting (at: 12/12/2019 1800)", eventTest.getDescription());
    }

    @Test
    void getFormatTest() {
        assertEquals("E | 0 | meeting | 12/12/2019 1800", eventTest.getFormat());
    }
}
