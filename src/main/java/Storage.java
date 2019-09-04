import java.io.*;
import java.util.ArrayList;

public class Storage {
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
    public void ReadFile(ArrayList<Task> arr) {
        BufferedReader br = null;
        String line;
        try {
            FileReader fr = new FileReader("C:\\Users\\ayh_j\\Documents\\duke\\dataTask.txt");
            br = new BufferedReader(fr);
            while((line = br.readLine()) != null) {
                String[] splitter = line.split("\\|");
                for(int i = 0; i < splitter.length; i++) {
                    splitter[i] = splitter[i].trim();
                }
                if(splitter[0].equals("D")) {
                    Deadline newD = new Deadline(splitter[2] + " ", " " + splitter[3]);
                    if(splitter[1] == "0") {
                        newD.isDone = false;
                    }
                    else if (splitter[1] == "1") {
                        newD.isDone = true;
                    }
                    arr.add(newD);
                }
                else if(splitter[0].equals("E")) {
                    Event newE = new Event(splitter[2] + " ", " " + splitter[3]);
                    if(splitter[1] == "0") {
                        newE.isDone = false;
                    }
                    else if (splitter[1] == "1") {
                        newE.isDone = true;
                    }
                    arr.add(newE);
                }
                else {
                    ToDo newT = new ToDo(splitter[2]);
                    if(splitter[1] == "0") {
                        newT.isDone = false;
                    }
                    else if (splitter[1] == "1") {
                        newT.isDone = true;
                    }
                    arr.add(newT);
                }
            }
            fr.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
