import java.util.ArrayDeque;

public class UserInfo {
    private String userPassword;
    private String userName;
    private String userEmail;
    private String securityQuestion;
    private String securityQuestionAnwer;
    private boolean securityQuestionSetted = false;

    private ArrayDeque<Message> mailbox;


    public UserInfo(String userName, String userPassword, String userEmail) {
        this.userPassword = userPassword;
        this.userName = userName;
        this.userEmail = userEmail;
        mailbox = new ArrayDeque<Message>();
    }

    public void addMessage(Message m) {
        mailbox.add(m);
    }

    public boolean isMailboxEmpty() {
        return mailbox.isEmpty();
    }

    public Message readNextMessage() {
        return mailbox.pollFirst();
    }

    public int getUnreadMessages() {
        return mailbox.size();
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


    public boolean isSecurityQuestionSetted() {
        return this.securityQuestionSetted;
    }

    public boolean getSecurityQuestionSetted() {
        return this.securityQuestionSetted;
    }

    public void setSecurityQuestionSetted(boolean securityQuestionSetted) {
        this.securityQuestionSetted = securityQuestionSetted;
    }



}