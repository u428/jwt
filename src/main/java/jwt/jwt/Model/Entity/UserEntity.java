package jwt.jwt.Model.Entity;


import jwt.jwt.Enams.StatusMode;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigInteger;
import java.util.List;

@Entity(name = "users")
public class UserEntity implements Serializable {

    private static final Long serialVersionUID=1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable=false)
    private String userId;
    @Column(nullable = false, length = 50)
    private String firstName;
    @Column(nullable = false, length = 50)
    private String lastName;
    @Column(nullable = false, length = 120)
    private String email;
    @Column(nullable = false)
    private String encryptedPassword;

    @Column(nullable = false)
    private BigInteger cardNumber;

    @Column()
    private String address;

    @Column()
    private StatusMode status;

    @Column()
    private String emailVerificationToken;
    @Column()
    private Boolean emailVerificationStatus;

    @OneToMany(mappedBy = "userDetails", cascade = CascadeType.ALL)
    private List<Game_User> gameUser;

    @OneToOne(cascade = CascadeType.MERGE)
    @JoinTable(name = "user_role", joinColumns = {
            @JoinColumn(name = "USER_ID", referencedColumnName = "ID") }, inverseJoinColumns = {
            @JoinColumn(name = "ROLE_ID", referencedColumnName = "ID") })
    private Role roles;

    public Role getRoles() {
        return roles;
    }

    public void setRoles(Role roles) {
        this.roles = roles;
    }

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

    public List<Game_User> getGameUser() {
        return gameUser;
    }

    public void setGameUser(List<Game_User> gameUser) {
        this.gameUser = gameUser;
    }
}
