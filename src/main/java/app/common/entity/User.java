package app.common.entity;


import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "userlogin")
public class User {


    @Id
    @Column(name = "user_id")
    private long id;

    @Size(min = 3)
    @NotEmpty
    @Pattern(regexp = "^[a-zA-Z\\d\\s]*$", message = "{only English characters allowed, without special characters}")
    @Column(name = "login")
    private String login;

    @Size(min = 5)
    @NotEmpty
    @Column(name = "password")
    private String password;

    @Size(min = 5)
    @NotEmpty
    @Column(name = "TFA_FLAG")
    private String tfa;


    @OneToOne(fetch = FetchType.EAGER)
    @JoinTable(name = "userinfo",
            joinColumns = {@JoinColumn(name = "userID")},
            inverseJoinColumns = {@JoinColumn(name = "user_id")})
    private UserInfo userInfo;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getTfa() {
        return tfa;
    }

    public void setTfa(String tfa) {
        this.tfa = tfa;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }

    //
//    @Override
//    public String toString() {
//        final StringBuilder sb = new StringBuilder("User{");
//        sb.append("id=").append(id);
//        sb.append(", login='").append(login).append('\'');
//        sb.append(", password='").append(password).append('\'');
//        sb.append(", surname='").append(surname).append('\'');
//        sb.append(", name='").append(name).append('\'');
//        sb.append(", patronymic='").append(patronymic).append('\'');
//        sb.append(", roles=").append(roles);
//        sb.append(", phoneBookItems=").append(phoneBookItems);
//        sb.append('}');
//        return sb.toString();
//    }
}
