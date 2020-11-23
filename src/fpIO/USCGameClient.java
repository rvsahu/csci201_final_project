package fpIO;


import com.google.gson.Gson;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;

public class USCGameClient {
    final private Client client;
    final private String SERVICE_URL = "http://uscgames.heletz.net:8080/USCapeServer_war_exploded/Server2";
    /*private static final String SUCCESS_RESULT = "<result>success</result>";
    private static final String PASS = "pass";
    private static final String FAIL = "fail";*/

    public USCGameClient() {
        this.client = ClientBuilder.newClient();
    }

    public static void main(String[] args) {
        USCGameClient uscGameClient = new USCGameClient();
//        uscGameClient.testGetMessage();
//        main.addUser();
        User user = new User("mheletz", "bernie2020");
        uscGameClient.logIn(user);
        user.setMapJson("Map JSON");
        user.setPlayerJson("Player JSON");
        uscGameClient.save(user);
        User rUser = uscGameClient.load(user.getToken());
        System.out.println(rUser.getMapJson());
        System.out.println(rUser.getPlayerJson());


    }

    /*public void testGetMessage(){
        String message = "Bernie";

        message = client
                .target(SERVICE_URL)
                .path("getMessage/"+ message)
                .request("text/plain")
                .get(String.class);
        System.out.println(message);
    }*/
    public String addUser(User user) {

//        System.out.println(Entity.json(user).toString());
        String token = client.
                target(SERVICE_URL)
                .path("addUser")
                .request(MediaType.APPLICATION_JSON)
                .accept("text/plain")
                .post(Entity.json(user), String.class);
        user.setToken(token);
//        System.out.println(user.getToken());
        return token;
    }

    public String logIn(User user) {
        String token = client.
                target(SERVICE_URL)
                .path("login")
                .request(MediaType.APPLICATION_JSON)
                .accept("text/plain")
                .post(Entity.json(user), String.class);
        user.setToken(token);
        System.out.println(user.getToken());
        return token;
    }

    public String save(User user) {
        String status = client.
                target(SERVICE_URL)
                .path("save")
                .request(MediaType.APPLICATION_JSON)
                .accept("text/plain")
                .post(Entity.json(user), String.class);
        System.out.println("Save: " + status);
        return status;
    }

    public User load(String token) {

        try {
            String userJson = client.
                    target(SERVICE_URL).
                    path("load").
                    request("text/plain")
                    .accept("text/plain")
                    .post(Entity.text(token), String.class);
            Gson gson = new Gson();
            return gson.fromJson(userJson, User.class);
        } catch (Exception e) {

            return new User(e.getMessage(), "");
        }
    }
}