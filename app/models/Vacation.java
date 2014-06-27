package models;

import play.db.ebean.Model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="vacations")
public class Vacation {

    public static Model.Finder<String, Vacation> find
            = new Model.Finder<String, Vacation>(String.class, Vacation.class);

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

    @OneToOne
    private Mailbox mailbox;

    public Mailbox getMailbox() {
        return mailbox;
    }

    public void setMailbox(Mailbox mailbox) {
        this.mailbox = mailbox;
    }

    private String subject;

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    @Column(columnDefinition="TEXT")
    private String body;

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    private Date start;

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    private Date end;

    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
    }

    private Integer onlyBefore;//hour

    public Integer getOnlyBefore() {
        return onlyBefore;
    }

    public void setOnlyBefore(Integer onlyBefore) {
        this.onlyBefore = onlyBefore;
    }

    private Integer onlyAfter; //hour

    public Integer getOnlyAfter() {
        return onlyAfter;
    }

    public void setOnlyAfter(Integer onlyAfter) {
        this.onlyAfter = onlyAfter;
    }
}
