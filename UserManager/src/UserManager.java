import java.util.ArrayList;
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

    public void sendMessage(UserInfo sender, UserInfo receiver, String content) {
        Message m = new Message(content, sender.getUserName());
        receiver.addMessage(m);
    }

    public ArrayList<Message> getMessageList(UserInfo user){ 
        ArrayList<Message> list = new ArrayList<Message>();
        for (int i = 0; i < user.getUnreadMessages(); i++) {
            list.add(user.readNextMessage());
        }
        return list;
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

    public ArrayList<UserInfo> getUserList(UserInfo user) {
        ArrayList<UserInfo> result = new ArrayList<UserInfo>();

        userDatabase.forEach((key, value) -> {
            if (key != user.getUserName()) {
                result.add(value);
            }
        });

        return result;
    }

    public void setSecurityQuestion(UserInfo user, String newSecurityQuestion, String newSecurityAnswer) {
        user.setSecurityQuestion(newSecurityQuestion);
        user.setSecurityQuestionAnwer(newSecurityAnswer);
    }

    public UserInfo getUserInfo(String userName) {
        return userDatabase.get(userName);
    }

    public boolean checkUserExits(String userName) {
        return (userDatabase.get(userName) != null);
    }

}
