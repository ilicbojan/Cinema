package cinemaapp.dto;

import org.springframework.web.multipart.MultipartFile;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class CinemaDto {
    private long id;

    @NotNull(message = "Name is required")
    @Size(max = 30, message = "Name must be less than 30 characters")
    private String name;

    @NotNull(message = "Address is required")
    @Size(max = 50, message = "Address must be less than 50 characters")
    private String address;

    @NotNull(message = "Phone number is required")
    @Size(max = 25, min = 9, message = "Phone number must be greater than 9 and less than 25 characters")
    private String phoneNumber;

    @NotNull(message = "Image is required")
    @Column(name = "image")
    private MultipartFile image;

    @NotNull(message = "City is required")
    private long cityId;

    public CinemaDto() {}

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

    public MultipartFile getImage() {
        return image;
    }

    public void setImage(MultipartFile image) {
        this.image = image;
    }

    public long getCityId() {
        return cityId;
    }

    public void setCityId(long cityId) {
        this.cityId = cityId;
    }
}
