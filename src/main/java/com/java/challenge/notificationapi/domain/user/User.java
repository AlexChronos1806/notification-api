package com.java.challenge.notificationapi.domain.user;

import com.java.challenge.notificationapi.domain.notification.Category;
import com.java.challenge.notificationapi.domain.notification.NotificationType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "users")
public class User {

    @Id
    private Long id;
    private String name;
    private String email;
    private String phone;

    @Transient
    private List<Category> categories;

    @Transient
    private List<NotificationType> channels;

    public User() {
    }

    public User(UserBuilder userBuilder) {
        this.id = userBuilder.id;
        this.name = userBuilder.name;
        this.email = userBuilder.email;
        this.phone = userBuilder.phone;
        this.categories = userBuilder.categories;
        this.channels = userBuilder.channels;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    public List<NotificationType> getChannels() {
        return channels;
    }

    public void setChannels(List<NotificationType> channels) {
        this.channels = channels;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", categories=" + categories +
                ", channels=" + channels +
                '}';
    }

    public static class UserBuilder {
        private Long id;
        private String name;
        private String email;
        private String phone;
        private List<Category> categories;
        private List<NotificationType> channels;

        public UserBuilder id(Long id) {
            this.id = id;
            return this;
        }

        public UserBuilder name(String name) {
            this.name = name;
            return this;
        }

        public UserBuilder email(String email) {
            this.email = email;
            return this;
        }

        public UserBuilder phone(String phone) {
            this.phone = phone;
            return this;
        }

        public UserBuilder categories(List<Category> categories) {
            this.categories = categories;
            return this;
        }

        public UserBuilder channels(List<NotificationType> channels) {
            this.channels = channels;
            return this;
        }

        public User build() {
            return new User(this);
        }
    }

}
