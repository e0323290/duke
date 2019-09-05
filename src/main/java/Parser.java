import java.lang.reflect.Array;
import java.util.ArrayList;

public class Parser {
    private Tasklist tasklist;
    private Storage storage;

    public Parser(Tasklist tasklist, Storage inputStorage) {
        this.tasklist = tasklist;
        storage = inputStorage;
    }

    public Command parse(String inputString) {
        return new Command(storage, inputString, tasklist);
    }
}
