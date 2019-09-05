import java.util.*;
import java.util.regex.Pattern;

public class Duke {
    private Ui ui;
    private Storage storage;
    private Tasklist tasks;
    private ArrayList<Task> arrayList;
    private Parser parser;

    public Duke() {
        arrayList = new ArrayList<>(100);
        ui = new Ui();
        storage = new Storage(arrayList);
        tasks = new Tasklist(arrayList);
        parser = new Parser(tasks, storage);
    }

    public void run() {
        arrayList = storage.ReadFile();
        ui.showWelcome();
        String input = ui.readCommand();
        while (true) {
            Command c = parser.parse(input);
            c.execute();
            input = ui.readCommand();
            if (input.equals("bye")) {
                ui.showBye();
                break;
            } else {
                try {
                    String[] tokens = input.split(Pattern.quote(" "));
                    if (!tokens[0].matches("todo|deadline|list|event|find|delete|done"))
                        throw new DukeException("☹ OOPS!!! I'm sorry, but I don't know what that means :-(");
                } catch (DukeException e) {
                    System.out.println(e.getMessage());
                }
            }
        }

    }

    public static void main(String[] args) {
        new Duke().run();
    }
}

