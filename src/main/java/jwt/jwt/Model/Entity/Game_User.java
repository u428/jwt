package jwt.jwt.Model.Entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name = "gameUser")
public class Game_User implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private int gameNumber;

    @Column(nullable = false)
    private int atGameNumber;

    @ManyToOne
    @JoinColumn(name = "UserEntity_id")
    private UserEntity userDetails;

    @OneToOne(mappedBy = "gameUser", cascade = CascadeType.ALL)
    private Game game;

    public Game_User() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getGameNumber() {
        return gameNumber;
    }

    public void setGameNumber(int gameNumber) {
        this.gameNumber = gameNumber;
    }

    public int getAtGameNumber() {
        return atGameNumber;
    }

    public void setAtGameNumber(int atGameNumber) {
        this.atGameNumber = atGameNumber;
    }

    public UserEntity getUserDetails() {
        return userDetails;
    }

    public void setUserDetails(UserEntity userDetails) {
        this.userDetails = userDetails;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }
}
