import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Tasklist {
    private ArrayList<Task> arrayList;

    public Tasklist(ArrayList inputList) {
        arrayList = inputList;
    }

    public void printList() {
        System.out.println("Here are the tasks in your list:"
                + "");

        for (int i = 0; i < arrayList.size(); i++) {

            System.out.println((i + 1) + "." + arrayList.get(i).getDescription());
        }
    }

    public ArrayList<Task> getList(){
        return arrayList;
    }

}
