package jwt.jwt.Model.DTO;




public class GameUserDTO {

    private Long id;
    private int gameNumber;
    private int atGameNumber;
    private UserDto userDto;
    private GameDTO gameDTO;

    public GameUserDTO() {
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

    public UserDto getUserDto() {
        return userDto;
    }

    public void setUserDto(UserDto userDto) {
        this.userDto = userDto;
    }

    public GameDTO getGameDTO() {
        return gameDTO;
    }

    public void setGameDTO(GameDTO gameDTO) {
        this.gameDTO = gameDTO;
    }
}
