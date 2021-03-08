package jwt.jwt.Model.Entity;



import javax.persistence.*;
import java.sql.Date;

@Entity(name = "game")
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column()
    private double summa;

    @Column()
    private Date date;

    @OneToOne
    @JoinColumn(name = "Game_User_id")
    private Game_User gameUser;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Game_User getGameUser() {
        return gameUser;
    }

    public void setGameUser(Game_User gameUser) {
        this.gameUser = gameUser;
    }

    public double getSumma() {
        return summa;
    }

    public void setSumma(double summa) {
        this.summa = summa;
    }
}
