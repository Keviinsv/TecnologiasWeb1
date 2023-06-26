package api;
import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

public class InstagramAPI {

    private static final String ACCESS_TOKEN = "IGQVJYUXk0OXh3OFk4Vk5CbEhSSlpKRWk5R3pDUm5ZAUTh3bGMxUmFrdFdRTTBadk1NbUE2Qk1WZAUR3SFhfSUhqY1ZAleEV4am5aaDVkYjdTakpYYk1Uek9vNGlVcUFWUWt6TkhKYTZAEX2F5aU42XzBORkJ0dGxMYkxCYTA4";
    private static final String USER_ID = "6196610240392076";

    public static void main(String[] args) {
        Client client = ClientBuilder.newClient();

        // Obtener el perfil del usuario
        String userProfileEndpoint = "https://api.instagram.com/v1/users/" + USER_ID + "/?access_token=" + ACCESS_TOKEN;
        WebTarget userProfileTarget = client.target(userProfileEndpoint);
        Response userProfileResponse = userProfileTarget.request(MediaType.APPLICATION_JSON).get();
        String userProfileJson = userProfileResponse.readEntity(String.class);

        System.out.println("Perfil del usuario:");
        System.out.println(userProfileJson);

        // Obtener el contenido multimedia del usuario
        String userMediaEndpoint = "https://api.instagram.com/v1/users/" + USER_ID + "/media/recent/?access_token=" + ACCESS_TOKEN;
        WebTarget userMediaTarget = client.target(userMediaEndpoint);
        Response userMediaResponse = userMediaTarget.request(MediaType.APPLICATION_JSON).get();
        String userMediaJson = userMediaResponse.readEntity(String.class);

        System.out.println("Contenido multimedia del usuario:");
        System.out.println(userMediaJson);

        client.close();
    }
}
