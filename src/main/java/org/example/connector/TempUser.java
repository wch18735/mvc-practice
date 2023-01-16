package org.example.connector;

import java.util.Objects;

public class TempUser {
    private final String userId;
    private final String password;
    private final String name;
    private final String email;

    public TempUser(String userId, String password, String name, String email) {
        this.userId = userId;
        this.password = password;
        this.name = name;
        this.email = email;
    }

    public String getUserId() {
        return userId;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TempUser tempUser = (TempUser) o;
        return Objects.equals(userId, tempUser.userId) && Objects.equals(password, tempUser.password) && Objects.equals(name, tempUser.name) && Objects.equals(email, tempUser.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, password, name, email);
    }
}
