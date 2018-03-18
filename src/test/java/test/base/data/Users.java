package test.base.data;

import create.account.step2account.S2Individual;

public enum Users {

    ADMIN("Admin", "Adminov", "admin", "!swGo4!KVtH9z^sEOUNfcB31", "05/07/1980", "123456789",
            "Admiv Street", "LA", "1234", "0697643478", "Director", "EntityName", "127856745", "RetireName", "DivName", "SecAdress"),
    CHESALOV("Vladyslav", "Chesalov", "vladwyane@gmail.com", "V123456789ch", "11/07/1987", "123456789",
            "Milutenka Street", "Kharkiv", "1234", "0668843478", "QA", "EntityName", "123456745", "RetireName", "DivName", "SecAdress"),
    VLADWYANE("Vlad", "Ches", "vladwyane@gmail.com", "rdf49dw07", "12/07/2001", "987654321",
            "Shevchenka", "Kiev", "56789", "0995467891", "Manager", "EntityName","123456745", "RetireName", "DivName", "SecAdress"),
    VLAD("V", "Ch", "vladyslav.chesalov@p2h.com", "JR6GMs4ywG", "01/07/1991", "987654",
            "Ivanova", "Alchevsk", "59", "0995467", "Director","EntityName","123456745", "RetireName", "DivName", "SecAdress");

    public String getFirstUserName() {
        return userFirstName;
    }

    public String getLastUserName() {
        return userLastName;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public String getSSN() {
        return SSN;
    }

    public String getStAddress() {
        return stAddress;
    }

    public String getCity() {
        return city;
    }

    public String getPCode() {
        return pCode;
    }

    public String getPhNumber() { return phNumber; }

    public String getPosition() { return position; }

    public String getEntityName() {
        return entityName;
    }

    public String getTaxNum() { return taxNum; }

    public String getRetireName() { return retireName; }

    public String getDivFullName() {
        return divFullName;
    }

    public String getSecondAddress() {
        return secondAddress;
    }


    private String userFirstName;
    private String userLastName;
    private String email;
    private String password;
    private String birthDate;
    private String SSN;
    private String stAddress;
    private String city;
    private String pCode;
    private String phNumber;
    private String position;
    private String entityName;
    private String taxNum;
    private String retireName;
    private String divFullName;
    private String secondAddress;



    Users(String userFirstName, String userLastName, String email, String password, String birthDate, String SSN,
          String stAddress, String city, String pCode, String phNumber, String position, String entityName,
          String taxNum, String retireName, String divFullName, String secondAddress) {
        this.userFirstName = userFirstName;
        this.userLastName = userLastName;
        this.email = email;
        this.password = password;
        this.birthDate = birthDate;
        this.SSN = SSN;
        this.stAddress = stAddress;
        this.city = city;
        this.pCode = pCode;
        this.phNumber = phNumber;
        this.position = position;
        this.entityName = entityName;
        this.taxNum = taxNum;
        this.retireName = retireName;
        this.divFullName = divFullName;
        this.secondAddress = secondAddress;

    }
}
