import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TodoTest {
    private ToDo todoTest = new ToDo("read book");

    @Test
    void getDescriptionTest() {
        assertEquals("[T][\u2718] read book", todoTest.getDescription());
    }

    @Test
    void getFormatTest() {
        assertEquals("T | 0 | read book", todoTest.getFormat());
    }

}
