package org.itstep;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.function.Supplier;

public class Main {

        public static void main(String[] args) throws IOException, InterruptedException, ExecutionException {
            //getProjectById();
            //getProjects();
            addTask();
        }

        private static void getProjectById() throws IOException, InterruptedException {
            String Uri = "https://api.todoist.com/rest/v1/projects/2294541031";
            // create a client
            HttpClient httpClient = HttpClient.newHttpClient();

            // create a request
            HttpRequest httpRequest = HttpRequest.newBuilder(
                    URI.create(Uri))
                    .header("Authorization","Bearer b49648bcc329b11d4c49646820538e840ceba530")
                    .build();

            // use the client to send the request
            HttpResponse<Supplier<Project>> response = httpClient.send(httpRequest, new JsonBodyHandler<>(Project.class));

            // the response:
           Project project = response.body().get();

            System.out.println(project.getId());
            System.out.println(project.getName());
        }

    private static void getProjects() throws IOException, InterruptedException {
        String Uri = "https://api.todoist.com/rest/v1/projects";
        // create a client
        HttpClient httpClient = HttpClient.newHttpClient();

        // create a request
        HttpRequest httpRequest = HttpRequest.newBuilder(
                URI.create(Uri))
                .header("Authorization","Bearer b49648bcc329b11d4c49646820538e840ceba530")
                .build();

        // use the client to send the request
        HttpResponse<Supplier<Project[]>> response = httpClient.send(httpRequest, new JsonBodyHandler<>(Project[].class));

        // the response:
        Project[] projects = response.body().get();
        System.out.println(projects.length);
    }

    private static void addTask() throws IOException, InterruptedException {
        String Uri = "https://api.todoist.com/rest/v1/projects";
        // create a client
        HttpClient httpClient = HttpClient.newHttpClient();

        // create a request
        var values = new HashMap<String, String>() {{
            put("name", "New Project");
        }};
        var objectMapper = new ObjectMapper();
        String requestBody = objectMapper
                .writeValueAsString(values);

        //Generate random string
        byte[] array = new byte[18]; // length is bounded by 7
        new Random().nextBytes(array);
        String generatedString = new String(array, Charset.forName("UTF-8"));

        HttpRequest httpRequest = HttpRequest.newBuilder(
                URI.create(Uri))
                .setHeader("Authorization","Bearer b49648bcc329b11d4c49646820538e840ceba530")
                .setHeader("Content-Type","application/json")
                .setHeader("X-Request-Id","997d4b53-55f1-48a9-9e66-de5785dfd69b")
                .POST(HttpRequest.BodyPublishers.ofString(requestBody))
                .build();

        // use the client to send the request
        HttpResponse<Supplier<Project>> response = httpClient.send(httpRequest, new JsonBodyHandler<>(Project.class));

        // the response:
        Project project = response.body().get();

        System.out.println(project.getId());
        System.out.println(project.getName());
    }
}

