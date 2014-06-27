package models;

import play.db.ebean.Model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;


@Entity
@Table(name="domains")
public class Domain extends Model {

    public static Finder<String, Domain> find
            = new Finder<String, Domain>(String.class, Domain.class);

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

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @OneToMany
    private List<Alias> aliasList;

    public List<Alias> getAliasList() {
        return aliasList;
    }

    public void setAliasList(List<Alias> aliasList) {
        this.aliasList = aliasList;
    }

    @OneToMany
    private List<Mailbox> mailboxList;

    public List<Mailbox> getMailboxList() {
        return mailboxList;
    }

    public void setMailboxList(List<Mailbox> mailboxList) {
        this.mailboxList = mailboxList;
    }

    private TransportType transport;

    public TransportType getTransport() {
        return transport;
    }

    public void setTransport(TransportType transport) {
        this.transport = transport;
    }

    private String vacation_domain;

    public String getVacation_domain() {
        return vacation_domain;
    }

    public void setVacation_domain(String vacation_domain) {
        this.vacation_domain = vacation_domain;
    }
}


