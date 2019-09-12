import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ConvertDateTimeTest {
    private ConvertDateTime convertDateTime = new ConvertDateTime();
    @Test
    public void formatDateTimeTest() {
        assertEquals("2nd of December 2019, 6pm", convertDateTime.formatDateTime("2/12/2019 1800"));
    }
}
