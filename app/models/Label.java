package models;

import play.Logger;
import play.db.ebean.Model;

import javax.persistence.*;
import java.util.HashMap;
import java.util.Map;

@Entity
@Table(name="labels")

public class Label extends Model {

    public static Finder<Long, Label> find
            = new Finder<>(Long.class, Label.class);

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long   id;
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id=id;
    }


    @Column(unique=true)
    private String name;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    private String pl;

    public String getPl() {
        return pl;
    }

    public void setPl(String pl) {
        this.pl = pl;
    }

    private String de;

    public String getDe() {
        return de;
    }

    public void setDe(String de) {
        this.de = de;
    }

    private String en;

    public String getEn() {
        return en;
    }

    public void setEn(String en) {
        this.en = en;
    }

    public String getTranslatedValue(String lang) {
        switch (lang) {
            case "en" : return this.en;
            case "de" : return this.de;
            case "pl" : return this.pl;
        }
        return "There is no translation in language "+lang;
    }

    public void setValue(String s) {
        this.de=s;
        this.en=s;
        this.pl=s;
    }

    public static Map<String,String> getLabels() {
        return Label.getLabels("en");
    }


    public static Map<String,String> getLabels(String lang) {
        Map<String,String> labels=new HashMap<>();
        try {
            for (Label i : find.all()) {
                labels.put(i.getName(), i.getTranslatedValue(lang));
            }
        } catch(Exception e) {
            Logger.error(e.getMessage(), e);
        }

        return labels;
    }

    public static Map<String,Label> getAllLabels() {
        Map<String,Label> labels=new HashMap<>();
        try {
            for (Label i : find.all()) {
                labels.put(i.getName(), i);
            }
        } catch(Exception e) {
            Logger.error(e.getMessage(), e);
        }

        return labels;
    }

}