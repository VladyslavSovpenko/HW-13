package TaskOne;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Path;

public class Methods {

    public String create(String uri) throws IOException, InterruptedException {

        HttpClient client = HttpClient.newHttpClient();
//        String json= getByIDOrName(Main.fivethTask);
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(uri))
                .header("Content-Type", "application/json")
                //             .POST(HttpRequest
                //                     .BodyPublishers.ofString(json))
                .POST(HttpRequest.BodyPublishers.ofFile(Path.of("C:\\\\Users\\\\Vlad\\\\IdeaProjects\\\\HW-13\\\\src\\\\TaskOne\\\\user.json")))
                .build();
        HttpResponse<String> response =
                client.send(request, HttpResponse.BodyHandlers.ofString());

        return response.body();

    }

    public String getAll(String uri) throws IOException, InterruptedException {

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(uri))
                .GET()
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        return response.body();
    }

    public String getByIDOrName(String something) throws IOException, InterruptedException {

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(something))
                .GET()
                .build();
        HttpResponse response = client.send(request, HttpResponse.BodyHandlers.ofString());
        return (String) response.body();
    }

    public int delete(String link) throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(link))
                .DELETE()
                .build();
        HttpResponse response = client.send(request, HttpResponse.BodyHandlers.ofString());
        return response.statusCode();
    }
    public String put(String url) throws IOException, InterruptedException {
        HttpClient client=HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .header("Content-Type", "application/json")
                .PUT(HttpRequest
                        .BodyPublishers
                        .ofFile(Path.of("C:\\\\Users\\\\Vlad\\\\IdeaProjects\\\\HW-13\\\\src\\\\TaskOne\\\\user.json")))
                .build();
        HttpResponse response = client.send(request,HttpResponse.BodyHandlers.ofString());

        return String.valueOf(response.body());

    }
}
