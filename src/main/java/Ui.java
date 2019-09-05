import java.util.Scanner;

public class Ui {
    private Scanner scanner = new Scanner(System.in);

    public void showWelcome() {
        System.out.println("Hello! I'm Duke \nWhat can I do for you?");
    }

    public String readCommand(){
        return scanner.nextLine();
    }

    public void showBye() {
        System.out.println("Bye. Hope to see you again soon!");
    }
}
