package jwt.jwt.Model.DTO;


import java.util.Date;

public class GameDTO {

    private Long id;
    private double summa;
    private Date date;
    private GameUserDTO gameUserDTO;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getSumma() {
        return summa;
    }

    public void setSumma(double summa) {
        this.summa = summa;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public GameUserDTO getGameUserDTO() {
        return gameUserDTO;
    }

    public void setGameUserDTO(GameUserDTO gameUserDTO) {
        this.gameUserDTO = gameUserDTO;
    }
}
