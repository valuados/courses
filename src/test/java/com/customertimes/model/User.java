package com.customertimes.model;

public class User {

    private String email;
    private String password;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public static Builder newBuilder() { return new Builder(); }

    public User() {
    }

    private User(final Builder builder) {
        email = builder.email;
        password = builder.password;
    }

    public static final class Builder {
        private String email;
        private String password;

        private Builder() {
        }

        public Builder withEmail(final String email) {
            this.email = email;
            return this;
        }

        public Builder withPassword(final String password) {
            this.password = password;
            return this;
        }

        public User build() {return new User( this);}
    }

}
