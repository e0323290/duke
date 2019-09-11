import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Takes in user command and understands it
 */
public class Parser {
    private Tasklist tasklist;
    private Storage storage;

    /**
     * @param tasklist the list of all tasks recorded
     * @param inputStorage inputs that are to be saved in Desktop
     */
    public Parser(Tasklist tasklist, Storage inputStorage) {
        this.tasklist = tasklist;
        storage = inputStorage;
    }

    /**
     * Taking in user command
     * @param inputString
     * @return
     */
    public Command parse(String inputString) {
        return new Command(storage, inputString, tasklist);
    }
}
