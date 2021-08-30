package TaskThree;

import TaskOne.Methods;
import com.google.gson.Gson;

import java.io.IOException;

public class ThirdMain {
    public static void main(String[] args) throws IOException, InterruptedException {
        extractedTasks("https://jsonplaceholder.typicode.com/users/1/todos");
    }

    private static void extractedTasks(String url) throws IOException, InterruptedException {
        Methods methods = new Methods();
        String task = methods.getByIDOrName(url);
        Gson gson = new Gson();
        Users users = gson.fromJson(task, Users.class);
        for (User a : users) {
            if (!a.getCompleted()) {
                System.out.println(a);
            }
        }
    }

}
