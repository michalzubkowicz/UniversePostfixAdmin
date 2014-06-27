package models;

/**
 * Created by Michal Zubkowicz (michal.zubkowicz@gmail.com) on 27.06.14.
 */
public enum TransportType {

    VIRTUAL("virtual"),
    LOCAL("local"),
    RELAY("relay");

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private TransportType(String name) {
        this.name = name;
    }

}
