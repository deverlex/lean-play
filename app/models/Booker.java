package models;

import com.avaje.ebean.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "booker")
public class Booker extends Model {

    @Id
    private int id;

    @Column(name = "user_id")
    private int userId;

    @Column(name = "topup")
    private float topup;

    @Column(name = "is_active")
    private boolean isActive;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public float getTopup() {
        return topup;
    }

    public void setTopup(float topup) {
        this.topup = topup;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }
}
