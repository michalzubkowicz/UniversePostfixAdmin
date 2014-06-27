package models;

import play.db.ebean.Model;

import javax.persistence.*;

@Entity
@Table(name="mailboxes")
public class Mailbox {

    public static Model.Finder<String, Mailbox> find
            = new Model.Finder<String, Mailbox>(String.class, Mailbox.class);

    @Id
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    private Boolean active;

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }


    private String username;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    private String maildir;

    public String getMaildir() {
        return maildir;
    }

    public void setMaildir(String maildir) {
        this.maildir = maildir;
    }

    @Column(name="local_part")
    private String localPart;

    public String getLocalPart() {
        return localPart;
    }

    public void setLocalPart(String localPart) {
        this.localPart = localPart;
    }

    @ManyToOne
    private Domain domain;

    public Domain getDomain() {
        return domain;
    }

    public void setDomain(Domain domain) {
        this.domain = domain;
    }

    @OneToOne
    private Vacation vacation;

    public Vacation getVacation() {
        return vacation;
    }

    public void setVacation(Vacation vacation) {
        this.vacation = vacation;
    }

    public static Boolean authenticate(String email, String enteredPassword) {
        return false;
    }
}
