import java.sql.SQLOutput;
import java.util.*;
import java.lang.*;

public class Duke {
    /**
     * Main class.
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
            if (inputString.equals("list")) {
                System.out.println("Here are the tasks in your list:" +
                        "");
                for (int i = 0; i < arrayList.size(); i++) {
                    System.out.print(i + 1 + ".");
                    System.out.println("[" + arrayList.get(i).getStatusIcon() + "] " + arrayList.get(i).getDescription());
                }

            } else if (inputString.equals("bye")){
                System.out.println("Bye. Hope to see you again soon!");
                break;
            }
            else if (inputString.contains("done")) {
                String[] strings = inputString.split(" ");
                System.out.println("Nice! I've marked this task as done: ");
                for (String i : strings) {
                    if(!i.equals("done")) {
                        int index = Integer.parseInt(i) - 1;
                        arrayList.get(index).markAsDone();
                        System.out.println("[" + arrayList.get(index).getStatusIcon() + "] " + arrayList.get(index).getDescription());
                    }
                }
            } else {
                Task newTask = new Task(inputString);
                arrayList.add(newTask);
                System.out.println("added: " + inputString);
            }
        }
    }
}