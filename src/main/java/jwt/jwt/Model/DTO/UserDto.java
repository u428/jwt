package jwt.jwt.Model.DTO;

import jwt.jwt.Enams.StatusMode;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.List;

public class UserDto implements Serializable {

    private static final Long serialVersionUID=1L;
    private Long id;
    private String userId;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String encryptedPassword;
    private BigInteger cardNumber;
    private String address;
    private StatusMode status;
    private String emailVerificationToken;
    private Boolean emailVerificationStatus;
    private List<GameUserDTO> gameUserDTOS;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEncryptedPassword() {
        return encryptedPassword;
    }

    public void setEncryptedPassword(String encryptedPassword) {
        this.encryptedPassword = encryptedPassword;
    }

    public BigInteger getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(BigInteger cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public StatusMode getStatus() {
        return status;
    }

    public void setStatus(StatusMode status) {
        this.status = status;
    }

    public String getEmailVerificationToken() {
        return emailVerificationToken;
    }

    public void setEmailVerificationToken(String emailVerificationToken) {
        this.emailVerificationToken = emailVerificationToken;
    }

    public Boolean getEmailVerificationStatus() {
        return emailVerificationStatus;
    }

    public void setEmailVerificationStatus(Boolean emailVerificationStatus) {
        this.emailVerificationStatus = emailVerificationStatus;
    }

    public List<GameUserDTO> getGameUserDTOS() {
        return gameUserDTOS;
    }

    public void setGameUserDTOS(List<GameUserDTO> gameUserDTOS) {
        this.gameUserDTOS = gameUserDTOS;
    }
}
