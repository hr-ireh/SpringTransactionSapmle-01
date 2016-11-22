package ir.hri.entities;

import javax.persistence.*;

@Entity
@Table(name = "USER")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID", nullable = false)
    int id;

    @Column(name = "USERNAME", length = 30, nullable = false)
    String username;

    @Column(name = "FIRS_NAME", length = 50, nullable = false)
    String firsName;

    @Column(name = "LAST_NAME", length = 50, nullable = false)
    String lastName;

    public User() {
    }

    public User(int id, String username, String firsName, String lastName) {
        this.id = id;
        this.username = username;
        this.firsName = firsName;
        this.lastName = lastName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirsName() {
        return firsName;
    }

    public void setFirsName(String firsName) {
        this.firsName = firsName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (id != user.id) return false;
        if (username != null ? !username.equals(user.username) : user.username != null) return false;
        if (firsName != null ? !firsName.equals(user.firsName) : user.firsName != null) return false;
        return !(lastName != null ? !lastName.equals(user.lastName) : user.lastName != null);

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (username != null ? username.hashCode() : 0);
        result = 31 * result + (firsName != null ? firsName.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        return result;
    }
}
