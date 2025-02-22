package org.yearobjectives.api.filter.request;

import jakarta.enterprise.context.RequestScoped;

@RequestScoped
public class UserInformation {
    private User user;

    public User getCurrentUser() {
        return user;
    }

    public void setCurrentUser(User user) {
        this.user = user;
    }

    public record User(String name) {}

}