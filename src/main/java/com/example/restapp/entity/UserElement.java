package com.example.restapp.entity;
import javax.persistence.*;

@Entity
public class UserElement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int UEId;
    private boolean type;

    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.MERGE)
    User user;
    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.MERGE)
    Element element;

    public UserElement() {
    }

    public int getUEId() {
        return UEId;
    }

    public void setUEId(int UEId) {
        this.UEId = UEId;
    }

    public boolean isType() {
        return type;
    }

    public void setType(boolean type) {
        this.type = type;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setElement(Element element) {
        this.element = element;
    }

    @Override
    public String toString() {
        return "UserElement{" +
                "UEId=" + UEId +
                ", type=" + type +
                '}';
    }
}
