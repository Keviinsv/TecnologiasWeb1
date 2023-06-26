package controller;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import model.UserMedia;
import model.UserProfile;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/userProfileController")
public class UserProfileController extends HttpServlet {
    private static final String ACCESS_TOKEN = "IGQVJYUXk0OXh3OFk4Vk5CbEhSSlpKRWk5R3pDUm5ZAUTh3bGMxUmFrdFdRTTBadk1NbUE2Qk1WZAUR3SFhfSUhqY1ZAleEV4am5aaDVkYjdTakpYYk1Uek9vNGlVcUFWUWt6TkhKYTZAEX2F5aU42XzBORkJ0dGxMYkxCYTA4";
    private static final String USER_ID = "6196610240392076";

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String userProfileEndpoint = "https://api.instagram.com/v1/users/" + USER_ID + "/?access_token=" + ACCESS_TOKEN;
        String userProfileJson = makeHttpGetRequest(userProfileEndpoint);
        UserProfile userProfile = parseUserProfileJson(userProfileJson);

        String userMediaEndpoint = "https://api.instagram.com/v1/users/" + USER_ID + "/media/recent/?access_token="
                + ACCESS_TOKEN;
        String userMediaJson = makeHttpGetRequest(userMediaEndpoint);
        List<UserMedia> userMediaList = parseUserMediaJson(userMediaJson);
        request.setAttribute("userProfile", userProfile);
        request.setAttribute("userMediaList", userMediaList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("userProfileView.jsp");
        dispatcher.forward(request, response);
    }

    private String makeHttpGetRequest(String endpoint) throws IOException {
        URL url = new URL(endpoint);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");

        StringBuilder response = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
            String line;
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
        }

        return response.toString();
    }

    private UserProfile parseUserProfileJson(String userProfileJson) {
        JsonObject jsonObject = JsonParser.parseString(userProfileJson).getAsJsonObject();
        String userId = jsonObject.get("id").getAsString();
        String username = jsonObject.get("username").getAsString();
        // Obtener otros campos del perfil y crear un objeto UserProfile
        UserProfile userProfile = new UserProfile(userId, username);
        return userProfile;
    }

    private List<UserMedia> parseUserMediaJson(String userMediaJson) {
        JsonObject jsonObject = JsonParser.parseString(userMediaJson).getAsJsonObject();
        JsonArray mediaArray = jsonObject.getAsJsonArray("data");
        List<UserMedia> userMediaList = new ArrayList<>();
        for (JsonElement element : mediaArray) {
            JsonObject mediaObject = element.getAsJsonObject();
            String mediaId = mediaObject.get("id").getAsString();
            String imageUrl = mediaObject.get("image_url").getAsString();
            String caption = mediaObject.get("caption").getAsString();
            UserMedia userMedia = new UserMedia(mediaId, imageUrl, caption);
            userMediaList.add(userMedia);
        }
        return userMediaList;
    }
}
