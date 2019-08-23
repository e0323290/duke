import java.util.*;
import java.lang.*;

public class Duke {
    /**
     * Main class.
     * @param args empty
     */

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Hello! I'm Duke \nWhat can I do for you?");
        String inputString = scanner.nextLine();
        while(!inputString.equals("bye")) {
            System.out.println(inputString);
            inputString = scanner.nextLine();
        }
        System.out.println("Bye. Hope to see you again soon!");
    }

}