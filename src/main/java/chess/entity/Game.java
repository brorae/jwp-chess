package chess.entity;

public class Game {

    private int id;
    private String title;
    private String password;
    private String state;

    public Game(int id, String title, String password, String state) {
        this.id = id;
        this.title = title;
        this.password = password;
        this.state = state;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getPassword() {
        return password;
    }

    public String getState() {
        return state;
    }
}
