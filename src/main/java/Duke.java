import java.util.*;
import java.lang.*;

public class Duke {
    /**
     * Main class.
     *
     * @param args empty
     */

    public static void main(String[] args) {
        ArrayList<String> arrayList = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Hello! I'm Duke \nWhat can I do for you?");
        String inputString = scanner.nextLine();

        int count = 0;
        while(!inputString.equals("bye")) {
            if(inputString.equals("list")) {
                for(int i = 0; i < arrayList.size(); i++) {
                    System.out.print(arrayList.get(i) + "\n");
                }
                inputString = scanner.nextLine();
            }
            else {
                count++;
                System.out.println("added: " + inputString);
                arrayList.add(count + ". " + inputString);
                inputString = scanner.nextLine();
            }
        }
        System.out.println("Bye. Hope to see you again soon!");
    }
}