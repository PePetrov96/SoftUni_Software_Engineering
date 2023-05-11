package com.example.accountsystem.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "full_name")
    private String fullName;
    @Column(name = "username", columnDefinition = "VARCHAR(30)", nullable = false, unique = true)
    private String username;
    @Column(name = "password", columnDefinition = "VARCHAR(50)", nullable = false)
    private String password;
    @Column(name = "email", nullable = false, columnDefinition = "VARCHAR(50)")
    private String email;
    @Column(name = "registered_on", nullable = false)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime registeredOn;
    @Column(name = "last_time_logged_in")
    private LocalDateTime lastTimeLoggedIn;
    @Column(name = "age", nullable = false)
    private int age;
    @Column(name = "is_deleted", columnDefinition = "BOOLEAN", nullable = false)
    private boolean isDeleted;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "born_town_id")
    private Town bornTown;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "living_in_town_id")
    private Town livingInTown;
    @ManyToMany
    @JoinTable(
            name = "user_friends",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "friend_id")
    )
    private Set<User> friends;

    public User() {
        friends = new HashSet<>();
    }

    public User(String firstName, String lastName, String username, String password, String email, int age) {
        this();

        setFirstName(firstName);
        setLastName(lastName);
        setFullName();
        setUsername(username);
        setPassword(password);
        setEmail(email);
        setRegisteredOn();
        setAge(age);
        this.isDeleted = false;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        if (username.length() < 4 || username.length() > 30) {
            throw new IllegalArgumentException("Username must be between 4 and 30 characters.");
        }
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        String check = passwordCheck(password);

        if (!check.trim().isEmpty()) {
            throw new IllegalArgumentException(check);
        }

        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        String regex = "^[A-Za-z0-9]+([._-][A-Za-z0-9]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)+$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);

        if (matcher.matches()) {
            this.email = email;
        } else {
            throw new IllegalArgumentException("Email must be in a format <user>@<host.domain>");
        }
    }

    public LocalDateTime getRegisteredOn() {
        return registeredOn;
    }

    public void setRegisteredOn() {
        this.registeredOn = LocalDateTime.now();
    }

    public LocalDateTime getLastTimeLoggedIn() {
        return lastTimeLoggedIn;
    }

    public void setLastTimeLoggedIn(LocalDateTime lastTimeLoggedIn) {
        this.lastTimeLoggedIn = lastTimeLoggedIn;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age < 1 || age > 120) {
            throw new IllegalArgumentException("Age must be between 1 and 120 years");
        }
        this.age = age;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }

    public Town getBornTown() {
        return bornTown;
    }

    public void setBornTown(Town bornTown) {
        this.bornTown = bornTown;
        bornTown.addBornTownUser(this);
    }

    public Town getLivingInTown() {
        return livingInTown;
    }

    public void setLivingInTown(Town livingInTown) {
        this.livingInTown = livingInTown;
        livingInTown.addBornTownUser(this);
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName() {
        this.fullName = getFirstName() + " " + getLastName();
    }

    private static String passwordCheck (String password) {
        StringBuilder out = new StringBuilder();

        if (password.length() < 6 || password.length() > 50) {
           out.append("Password length must be between 6 and 50 characters.")
                   .append(System.lineSeparator());
        }

        String lowerCase = "[a-z]";
        Pattern patternLowerCase = Pattern.compile(lowerCase);
        Matcher matcherLowerCase = patternLowerCase.matcher(password);

        if (!matcherLowerCase.find()) {
            out.append("Password must contain at least 1 lower case letter.")
                    .append(System.lineSeparator());
        }

        String upperCase = "[A-Z]";
        Pattern patternUpperCase = Pattern.compile(upperCase);
        Matcher matcherUpperCase = patternUpperCase.matcher(password);

        if (!matcherUpperCase.find()) {
            out.append("Password must contain at least 1 upper case letter.")
                    .append(System.lineSeparator());
        }

        String numbers = "[0-9]";
        Pattern patternNumbers = Pattern.compile(numbers);
        Matcher matcherNumbers = patternNumbers.matcher(password);

        if (!matcherNumbers.find()) {
            out.append("Password must contain at least 1 number.")
                    .append(System.lineSeparator());
        }

        String special = "[!@#$%^&*()_+<>?]";
        Pattern patternSpecial = Pattern.compile(special);
        Matcher matcherSpecial = patternSpecial.matcher(password);

        if (!matcherSpecial.find()) {
            out.append("Password must contain at least 1 special character (!, @, #, $, %, ^, &, *, (, ), _, +, <, >, ?).")
                    .append(System.lineSeparator());
        }

        return out.toString().trim();
    }

    public void addFriend(User user) {
        this.friends.add(user);
        user.reverseAddFriend(this);
    }

    private void reverseAddFriend(User user) {
        this.friends.add(user);
    }
}