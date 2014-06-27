package models;

import play.db.ebean.Model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name="vacation_notification") //only for compability with vacation perl script
public class VacationNotification extends Model {
    public static Model.Finder<String, VacationNotification> find
            = new Model.Finder<String, VacationNotification>(String.class, VacationNotification.class);

    @Id
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    private String on_vacation;

    public String getOn_vacation() {
        return on_vacation;
    }

    public void setOn_vacation(String on_vacation) {
        this.on_vacation = on_vacation;
    }

    private String notified;

    public String getNotified() {
        return notified;
    }

    public void setNotified(String notified) {
        this.notified = notified;
    }

    private Date notified_at;

    public Date getNotified_at() {
        return notified_at;
    }

    public void setNotified_at(Date notified_at) {
        this.notified_at = notified_at;
    }
}
