import java.sql.Array;
import java.sql.SQLOutput;
import java.util.*;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

public class Duke {
    /**
     * Main class.
     *
     *
     * @param args empty
     */

    public static void main(String[] args) {
        ArrayList<Task> arrayList = new ArrayList<Task>();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Hello! I'm Duke \nWhat can I do for you?");
        // String inputString = scanner.nextLine();

        while (true) {
            String inputString = scanner.nextLine();
            StringTokenizer split = new StringTokenizer(inputString);
            if (inputString.equals("list")) {
                System.out.println("Here are the tasks in your list:"
                        + "");

                for (int i = 0; i < arrayList.size(); i++) {

                    System.out.print(i + 1 + ".");

                    System.out.println(arrayList.get(i).getDescription());
                }

            } else if (inputString.equals("bye")) {
                System.out.println("Bye. Hope to see you again soon!");
                break;
            } else if (inputString.contains("done")) {
                String[] strings = inputString.split(" ");
                System.out.println("Nice! I've marked this task as done: ");
                for (String i : strings) {
                    if (!i.equals("done")) {
                        int index = Integer.parseInt(i) - 1;
                        arrayList.get(index).markAsDone();
                        System.out.println(arrayList.get(index).getDescription());
                        saveToFile(arrayList);
                    }
                }

            } else {
                if (inputString.contains("todo")) {
                    String[] toDoString = inputString.split(" ");
                    List<String> myList = new ArrayList<String>(Arrays.asList(toDoString));
                    try {
                        if (myList.size() == 1) {
                            throw new DukeException(" ☹ OOPS!!! The description of a todo cannot be empty.");
                        }
                    }
                        catch(DukeException e) {
                            System.out.println(e.getMessage());
                            continue;
                        }

                    myList.remove(0);
                    String description = String.join(" ", myList);
                    ToDo toDo = new ToDo(description);
                    arrayList.add(toDo);
                    System.out.println("Got it. I've added this task: ");
                    System.out.println("\t" + toDo.getDescription());
                    System.out.println("Now you have " + arrayList.size() + " tasks in the list.");
                    saveToFile(arrayList);
                } else if (inputString.contains("deadline")) {
                    String[] deadlineString = inputString.split(" ");
                    List<String> myList = new ArrayList<String>(Arrays.asList(deadlineString));
                    try {
                        if (myList.size() == 1) {
                            throw new DukeException(" ☹ OOPS!!! The description of a deadline cannot be empty.");
                        }
                    }
                    catch(DukeException e) {
                        System.out.println(e.getMessage());
                        continue;
                    }
                    myList.remove(0);
                    String description = String.join(" ", myList);
                    String[] inputs = description.split(" /by ");
                    Deadline deadLine = new Deadline(inputs[0], new ConvertDateTime().formatDateTime(inputs[1]));
                    arrayList.add(deadLine);
                    System.out.println("Got it. I've added this task: ");
                    System.out.println("\t " + deadLine.getDescription());
                    System.out.println("Now you have " + arrayList.size() + " tasks in the list.");
                    saveToFile(arrayList);

                } else if (inputString.contains("event")) {
                    String[] eventString = inputString.split(" ");
                    List<String> myList = new ArrayList<>(Arrays.asList(eventString));
                    try {
                        if (myList.size() == 1) {
                            throw new DukeException(" ☹ OOPS!!! The description of a event cannot be empty.");
                        }
                    }
                    catch(DukeException e) {
                        System.out.println(e.getMessage());
                        continue;
                    }
                    myList.remove(0);
                    String description = String.join(" ", myList);
                    String[] inputs = description.split(" /at ");
                    Event eVent = new Event(inputs[0], new ConvertDateTime().formatDateTime(inputs[1]));
                    arrayList.add(eVent);
                    System.out.println("Got it. I've added this task: ");
                    System.out.println("\t " + eVent.getDescription());
                    System.out.println("Now you have " + arrayList.size() + " tasks in the list.");
                    saveToFile(arrayList);

                } else if (inputString.contains("delete")) {
                    String[] strings = inputString.split(" ");
                    System.out.println("Noted. I've removed this task: ");
                    for (String i : strings) {
                        if (!i.equals("delete")) {
                            int index = Integer.parseInt(i) - 1;
                            System.out.println("\t" + arrayList.get(index).getDescription());
                            arrayList.remove(index);
                            System.out.println("Now you have " + arrayList.size() + " tasks in the list.");
                            saveToFile(arrayList);
                        }
                    }

                }
                else {
                    try {
                        if (!inputString.matches("todo|deadline|task|list|event"))
                            throw new DukeException("☹ OOPS!!! I'm sorry, but I don't know what that means :-(");
                    } catch (DukeException e) {
                        System.out.println(e.getMessage());
                        continue;
                    }
                }
            }


        }

    }
    // The function to save all the task into the textfile
    public static void saveToFile(ArrayList<Task> taskList) {
        File file = new File("C:\\Users\\ayh_j\\Documents\\duke\\dataTask.txt"); // Creating the textfile
        try {
            PrintWriter output = new PrintWriter(file);
            for (Task x : taskList) {
                output.println(x.getFormat());
            }
            output.close();
        } catch (IOException ex) {
            System.out.print("ERROR: Not Available");
        }
    }
}

