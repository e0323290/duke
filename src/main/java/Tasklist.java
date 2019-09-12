 import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Returns the list of descriptions of tasks when the "list" is called
 */
public class Tasklist {
    private ArrayList<Task> arrayList;

    /**
     * This is a constructor for the class Tasklist
     * @param inputList
     */
    public Tasklist(ArrayList inputList) {
        arrayList = inputList;
    }

    /**
     * Prints the required format of list
     */
    public void printList() {
        System.out.println("Here are the tasks in your list:"
                + "");

        for (int i = 0; i < arrayList.size(); i++) {

            System.out.println((i + 1) + "." + arrayList.get(i).getDescription());
        }
    }

    /**
     *
     * @return the list of tasks
     */
    public ArrayList<Task> getList(){
        return arrayList;
    }

}
