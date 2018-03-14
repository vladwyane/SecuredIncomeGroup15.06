package test.base.data;

public enum Users {
    ADMIN("admin@mfsa.ru", "passwrd"),
    MANAGER("manager@mfsa.ru", "passwrd"),
    VASYA("vasya@mfsa.ru", "123");

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    private String userName;
    private String password;

    Users(String userName, String password) {
        this.userName = userName;
        this.password = password;

    }



}
