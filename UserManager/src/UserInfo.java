import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;



public class UserInfo {
    private String userPassword;
    private String userName;
    private String userEmail;
    private String securityQuestion;
    private String securityQuestionAnwer;
    private boolean securityQuestionSetted = false;

    private ArrayDeque<Message> mailbox;

    //Pokemon
    ArrayList<Pokemon> listaUsuario = new ArrayList();



    public UserInfo(String userName, String userPassword, String userEmail) {
        this.userPassword = userPassword;
        this.userName = userName;
        this.userEmail = userEmail;
        mailbox = new ArrayDeque<Message>();

        for (int i = 0; i < 6; i++) {
            listaUsuario.add(PokemonGo.getRandomPokemon());
        }
        
        
    }

    public void removePokemon(Pokemon enemigo) {
        listaUsuario.remove(enemigo);
    }

    public ArrayList<Pokemon> getListaUsuario() {
        return this.listaUsuario;
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