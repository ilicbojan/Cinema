package cinemaapp.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Set;

@Entity
@Table(name = "cinema")
public class Cinema {

    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Id
    private long id;

    @NotNull(message = "Name is required")
    @Size(max = 30, message = "Name must be less than 30 characters")
    @Column(name = "name", unique = true)
    private String name;

    @NotNull(message = "Address is required")
    @Size(max = 50, message = "Address must be less than 50 characters")
    @Column(name = "address")
    private String address;

    @NotNull(message = "Phone number is required")
    @Size(max = 25, min = 9, message = "Phone number must be greater than 9 and less than 25 characters")
    @Column(name = "phone_number")
    private String phoneNumber;

    @NotNull(message = "Image is required")
    @Column(name = "image")
    private String image;

    @ManyToOne
    private City city;

    @OneToMany(mappedBy = "cinema", cascade = CascadeType.ALL)
    private Set<Hall> halls;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public Set<Hall> getHalls() {
        return halls;
    }

    public void setHalls(Set<Hall> halls) {
        this.halls = halls;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
