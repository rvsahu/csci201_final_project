package fpIO;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class User {

    /*@SerializedName("username")
    @Expose*/
    private String username;
    /*@SerializedName("password")
    @Expose*/
    private String password;
    /*@SerializedName("token")
    @Expose*/
    private String token = "";
    private String mapJson = "";
    private String playerJson = "";

    public User(String n, String p) {
        username = n;
        password = p;
    }
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getMapJson() {
        return mapJson;
    }

    public void setMapJson(String mapJson) {
        this.mapJson = mapJson;
    }

    public String getPlayerJson() {
        return playerJson;
    }

    public void setPlayerJson(String playerJson) {
        this.playerJson = playerJson;
    }

    @Override
    public String toString() {
        System.out.println(mapJson);
        System.out.println(playerJson);
        return new ToStringBuilder(this).append("username", username).append("password", password).append("token", token).toString();
    }

}
