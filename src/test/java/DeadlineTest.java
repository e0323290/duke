import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DeadlineTest {
    private Deadline deadlineTest = new Deadline("submission", "12/12/2019 1800");

    @Test
    void getDescriptionTest() {
        assertEquals("[D][\u2718] submission (by: 12/12/2019 1800)", deadlineTest.getDescription());
    }

    @Test
    void getFormatTest() {
        assertEquals("D | 0 | submission | 12/12/2019 1800", deadlineTest.getFormat());
    }
}
