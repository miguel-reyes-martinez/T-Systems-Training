public class UserInfo {
    private String userPassword;
    private String userName;
    private String userEmail;
    private String securityQuestion = "¿Cuál es el nombre de tu primera mascota?";
    private String securityQuestionAnwer;


    public UserInfo(String userName, String userPassword, String userEmail) {
        this.userPassword = userPassword;
        this.userName = userName;
        this.userEmail = userEmail;
    }

    public String getUserPassword() {
        return this.userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserName() {
        return this.userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserEmail() {
        return this.userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }


    public String getSecurityQuestion() {
        return this.securityQuestion;
    }

    public void setSecurityQuestion(String securityQuestion) {
        this.securityQuestion = securityQuestion;
    }

    public String getSecurityQuestionAnwer() {
        return this.securityQuestionAnwer;
    }

    public void setSecurityQuestionAnwer(String securityQuestionAnwer) {
        this.securityQuestionAnwer = securityQuestionAnwer;
    }


}