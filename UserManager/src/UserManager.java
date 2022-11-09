import java.util.HashMap;
import java.util.Map;


public class UserManager {
    private Map<String, UserInfo> userDatabase = new HashMap<String, UserInfo>();

    public boolean authenticateUser(String inputUser, String inputPass) throws Exception {
        UserInfo user = userDatabase.get(inputUser);
        if (user == null) {
            return false;
        } else if (inputPass.equals(user.getUserPassword())) {
            return true;
        } else {
            return false;
        }
    }

    public void signUp(String userName, String password, String email) throws Exception {

        UserInfo user = new UserInfo(userName, password, email);
        saveUser(user);
    }

    public void saveUser(UserInfo user) {
        userDatabase.put(user.getUserName(), user);
    }

    public void changePassword(UserInfo user, String newPassword) {
        user.setUserPassword(newPassword);
    }

    public void changeEmail(UserInfo user, String newEmail) {
        user.setUserEmail(newEmail);
    }

    public void setSecurityQuestion(UserInfo user, String newSecurityQuestion, String newSecurityAnswer) {
        user.setSecurityQuestion(newSecurityQuestion);
        user.setSecurityQuestionAnwer(newSecurityAnswer);
    }

    public UserInfo getUserInfo(String userName){
        return userDatabase.get(userName);
    }

    public boolean checkUserExits(String userName){
        return (userDatabase.get(userName) != null);
    }
}
