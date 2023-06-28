package com.java.challenge.notificationapi.domain.user;

import com.java.challenge.notificationapi.domain.category.Category;
import com.java.challenge.notificationapi.domain.channel.Channel;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "users")
public class User {

    @Id
    private Long id;
    private String name;
    private String email;
    private String phone;

    @ManyToMany
    @JoinTable(
            name = "users_categories",
            joinColumns = @JoinColumn(name = "users_id"),
            inverseJoinColumns = @JoinColumn(name = "categories_id")
    )
    private Set<Category> categorySet;

    @ManyToMany
    @JoinTable(
            name = "users_channels",
            joinColumns = @JoinColumn(name = "users_id"),
            inverseJoinColumns = @JoinColumn(name = "channels_id")
    )
    private Set<Channel> channelSet;

    public User() {
    }

    private User(UserBuilder userBuilder) {
        this.id = userBuilder.id;
        this.name = userBuilder.name;
        this.email = userBuilder.email;
        this.phone = userBuilder.phone;
        this.categorySet = userBuilder.categorySet;
        this.channelSet = userBuilder.channelSet;
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

    public Set<Category> getCategorySet() {
        return categorySet;
    }

    public void setCategorySet(Set<Category> categorySet) {
        this.categorySet = categorySet;
    }

    public Set<Channel> getChannelSet() {
        return channelSet;
    }

    public void setChannelSet(Set<Channel> channelSet) {
        this.channelSet = channelSet;
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

    public static class UserBuilder {
        private Long id;
        private String name;
        private String email;
        private String phone;
        private Set<Category> categorySet;
        private Set<Channel> channelSet;

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

        public UserBuilder categories(Set<Category> categorySet) {
            this.categorySet = categorySet;
            return this;
        }

        public UserBuilder channels(Set<Channel> channelSet) {
            this.channelSet = channelSet;
            return this;
        }

        public User build() {
            return new User(this);
        }
    }

}
