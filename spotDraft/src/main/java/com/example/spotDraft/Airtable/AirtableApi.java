package com.example.spotDraft.Airtable;
import java.io.IOException;
import java.net.http.HttpResponse;

import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.json.simple.JSONObject;

public class AirtableApi {
    @SuppressWarnings("unchecked")
	public static void main(String[] args) {
        String apiKey = "patZB7TEGXD6FRywr.845c22108cdec1e661069fd298ddbcbb8ca1fdfeda56764a67715b46c2b90858";
        String baseId = "appHe4bvo7p4PdbNq";
        String tableName = "Asana%20Tasks";

        // User-provided data
        JSONObject fields = new JSONObject();
        fields.put("Task ID", "852201");
        fields.put("Name", "Ranjeet Kumar");

        JSONObject assignee = new JSONObject();
        assignee.put("id", "usrZDPoNZFKkZgUCf");
        assignee.put("email", "ranjeet030200@gmail.com");
        assignee.put("name", "RANJEET KUMAR");
        fields.put("Assignee", assignee);

        fields.put("Due Date", "2023-08-02");
        fields.put("Description", "This is api test");

        JSONObject record = new JSONObject();
        record.put("fields", fields);

        JSONObject requestPayload = new JSONObject();
        requestPayload.put("records", new JSONObject[]{record});

        System.out.print("huaa");
        
        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
            HttpPost httpPost = new HttpPost("https://api.airtable.com/v0/" + baseId + "/" + tableName);
            httpPost.addHeader("Authorization", "Bearer " + apiKey);
            httpPost.addHeader("Content-Type", "application/json");

            StringEntity entity = new StringEntity(requestPayload.toString());
            httpPost.setEntity(entity);

            HttpResponse response = (HttpResponse) httpClient.execute(httpPost);

            
            int statusCode = ((org.apache.http.HttpResponse) response).getStatusLine().getStatusCode();
            System.out.println("Response Status Code: " + statusCode);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
