import java.util.Scanner;

/**
 * Prints out the welcome message initially and bye message when command "bye" is called
 */
public class Ui {
    private Scanner scanner = new Scanner(System.in);

    /**
     * Prints welcome message initially when programme is built
     */
    public void showWelcome() {
        System.out.println("Hello! I'm Duke \nWhat can I do for you?");
    }

    /**
     * @return scanner that reads the next line and takes it in as input
     */
    public String readCommand(){
        return scanner.nextLine();
    }

    /**
     * Prints bye message when input is "bye"
     */
    public void showBye() {
        System.out.println("Bye. Hope to see you again soon!");
    }
}
