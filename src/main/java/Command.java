import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

/**
 *
 */
public class Command {
    private Storage storage;
    private String type;
    private Tasklist tasklist;

    /**
     *
     * @param inputStorage
     * @param inputType
     * @param tasklist
     */
    public Command(Storage inputStorage, String inputType, Tasklist tasklist) {
         this.tasklist = tasklist;
         storage = inputStorage;
         type = inputType;

        }

    /**
     * This method adds todo tasks to the list of tasks when called and
     * outputs an error if nothing follows up the word "todo"
     *
     * @param inputString
     */
    public void addToDo(String inputString) {
            String[] toDoString = inputString.split(" ");
            List<String> myList = new ArrayList<String>(Arrays.asList(toDoString));
            try {
                if (myList.size() == 1) {
                    throw new DukeException(" ☹ OOPS!!! The description of a todo cannot be empty.");
                }
                myList.remove(0);
                String description = String.join(" ", myList);
                ToDo toDo = new ToDo(description);
                tasklist.getList().add(toDo);
                System.out.println("Got it. I've added this task: ");
                System.out.println("\t" + toDo.getDescription());
                System.out.println("Now you have " + tasklist.getList().size() + " tasks in the list.");

                storage.saveToFile();
            } catch (DukeException e) {
                System.out.println(e.getMessage());
            }
        }

    /**
     * This method marks a task as done and change the status icon from incomplete to completed
     *
     * @param inputString
     */
    public void donezo(String inputString) {
        String[] strings = inputString.split(" ");
        System.out.println("Nice! I've marked this task as done: ");
        for (String i : strings) {
            if (!i.equals("done")) {
                int index = Integer.parseInt(i) - 1;
                tasklist.getList().get(index).markAsDone();
                System.out.println(tasklist.getList().get(index).getDescription());

                storage.saveToFile();
            }
        }
    }

    /**
     * This method adds deadline tasks to the list of tasks when called and
     * outputs an error if nothing follows up the word "deadline"
     *
     * @param inputString
     */
    public void addDeadline(String inputString) {
            String[] deadlineString = inputString.split(" ");
            List<String> myList = new ArrayList<String>(Arrays.asList(deadlineString));
            try {
                if (myList.size() == 1) {
                    throw new DukeException(" ☹ OOPS!!! The description of a deadline cannot be empty.");
                }
                myList.remove(0);
                String description = String.join(" ", myList);
                String[] inputs = description.split(" /by ");
                Deadline deadLine = new Deadline(inputs[0], new ConvertDateTime().formatDateTime(inputs[1]));
                tasklist.getList().add(deadLine);
                System.out.println("Got it. I've added this task: ");
                System.out.println("\t " + deadLine.getDescription());
                System.out.println("Now you have " + tasklist.getList().size() + " tasks in the list.");

                storage.saveToFile();
            } catch (DukeException e) {
                System.out.println(e.getMessage());
            }
        }

    /**
     * This method adds event tasks to the list of tasks when called and
     * outputs an error if nothing follows up the word "event"
     *
     * @param inputString
     */
    public void addEvent(String inputString) {
        String[] eventString = inputString.split(" ");
        List<String> myList = new ArrayList<>(Arrays.asList(eventString));
        try {
            if (myList.size() == 1) {
                throw new DukeException(" ☹ OOPS!!! The description of a event cannot be empty.");
            }
            myList.remove(0);
            String description = String.join(" ", myList);
            String[] inputs = description.split(" /at ");
            Event eVent = new Event(inputs[0], new ConvertDateTime().formatDateTime(inputs[1]));
            tasklist.getList().add(eVent);
            System.out.println("Got it. I've added this task: ");
            System.out.println("\t " + eVent.getDescription());
            System.out.println("Now you have " + tasklist.getList().size() + " tasks in the list.");
            storage.saveToFile();
        } catch (DukeException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * This method deletes any tasks from the task list when the task number in the list is called
     * after the word "delete"
     *
     * @param inputString
     */
    public void deleteFromList(String inputString) {
        String[] strings = inputString.split(" ");
        System.out.println("Noted. I've removed this task: ");
        for (String i : strings) {
            if (!i.equals("delete")) {
                int index = Integer.parseInt(i) - 1;
                System.out.println("\t" + tasklist.getList().get(index).getDescription());
                tasklist.getList().remove(index);
                System.out.println("Now you have " + tasklist.getList().size() + " tasks in the list.");
                storage.saveToFile();
            }
        }
    }

    /**
     * This method finds tasks that contains a specific keyword and outputs
     * that task description in a list
     *
     * @param inputString
     */
    public void findFromList(String inputString) {
            String[] parts = inputString.split(" ", 2);
            String wordToBeFound = parts[1];

            System.out.println("Here are the matching tasks in your list: ");
            ArrayList<Task> wordFound = new ArrayList<>();
            for (Task i : tasklist.getList()) {
                if (i.getDescription().contains(wordToBeFound)) {
                    wordFound.add(i);
                }
            }
            for (int i = 0; i < wordFound.size(); i++) {
                System.out.println((i + 1) + "." + wordFound.get(i).getDescription());
            }
        }

    /**
     * This method detects the task called and carries out the respective method
     *
     */
    public void execute() {
        String[] tokens = type.split(Pattern.quote(" "));
        if(tokens[0].equals("todo")) {
            addToDo(type);
        } else if(tokens[0].equals("done")) {
            donezo(type);
        } else if(tokens[0].equals("deadline")) {
            addDeadline(type);
        } else if(tokens[0].equals("event")) {
            addEvent(type);
        } else if(tokens[0].equals("delete")) {
            deleteFromList(type);
        } else if(tokens[0].equals("find")) {
            findFromList(type);
        } else if(tokens[0].equals("list")) {
            tasklist.printList();
        }
    }
}