package TaskTwo;

import TaskOne.Methods;
import com.google.gson.Gson;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class SecondMain {
    public static void main(String[] args) throws IOException, InterruptedException {
        extracted(1l, "https://jsonplaceholder.typicode.com/users/1/posts");
    }

    private static void extracted(Long id, String linkId) throws IOException, InterruptedException {
        Methods methods = new Methods();
        Long maxId = 0l;
        String post = methods.getByIDOrName(linkId);
        Gson gson = new Gson();
        Posts posts = gson.fromJson(post, Posts.class);
        for (Post a : posts) {
            if (a.getId() > maxId)
                maxId = a.getId();
        }
        String commentsString = methods.getByIDOrName("https://jsonplaceholder.typicode.com/posts/" + maxId + "/comments");
        Comments comments = gson.fromJson(commentsString, Comments.class);
        File file = new File("user-" + id + "-post-" + maxId + "-comments.json");

        Gson gsonWriter = new Gson().newBuilder().setPrettyPrinting().create();

        String commentAsJson = gsonWriter.toJson(comments);

        FileWriter fileWriter = new FileWriter(file);
        fileWriter.write(commentAsJson);
        fileWriter.flush();
        System.out.println("File was created!");
    }
}
