import java.util.Scanner;

public class App {
    static UserManager passManager = new UserManager();

    public static void main(String[] args) throws Exception {

        boolean exit = false;
        boolean logged = false;

        String userName = "admin";
        String password = "password";
        String email = "admin@t-systems.com";
        passManager.signUp(userName, password, email);

        Scanner sc = new Scanner(System.in);

        do {
            System.out.println("BIENVENIDO A T-SYSTEMS - ¿Qué vas ha hacer?");
            System.out.println("\t( 1 ) Iniciar sesión.");
            System.out.println("\t( 2 ) Registrarse.");
            System.out.println("\t( 3 ) Reestablecer contraseña."); // TO DO
            System.out.println("\t( 4 ) Salir.");
            System.out.print("Mi elección [1-4]:\t");

            int choice = Integer.parseInt(sc.nextLine());
            int userChoice = 0;

            switch (choice) {
                case 1:
                    // Scanner scanner = new Scanner(System.in);
                    System.out.print("\nPor favor introduzca el nombre de usuario: ");
                    String inputUser = sc.nextLine();

                    System.out.print("\nPor favor introduzca la contraseña: ");
                    String inputPass = sc.nextLine();

                    boolean status = passManager.authenticateUser(inputUser, inputPass);
                    if (status) {
                        UserInfo currentUser = passManager.getUserInfo(inputUser);
                        System.out.println("¡Loggeado!");
                        logged = true;
                        do {
                            System.out.println("\t( 1 ) Establecer pregunta de seguridad."); // Si no recuerdas la
                                                                                             // contraseña puedes
                                                                                             // reestrablecerla
                            System.out.println("\t( 2 ) Modificar email.");
                            System.out.println("\t( 3 ) Modificar contraseña.");
                            System.out.println("\t( 4 ) Cerrar sesión.");
                            System.out.print("Mi elección [1-4]:\t");

                            userChoice = Integer.parseInt(sc.nextLine());

                            switch (userChoice) {
                                case 1:
                                    readNewSecurityQuestion(sc, currentUser);
                                    break;

                                case 2:
                                    System.out.print("\nPor favor introduzca el nuevo email: ");
                                    String newEmail = sc.nextLine();
                                    passManager.changePassword(currentUser, newEmail);
                                    System.out.println("Email actualizado a '" + newEmail + "'.");
                                    break;

                                case 3:
                                    try {
                                        readChangePassword(sc, currentUser);
                                    } catch (Exception e) {
                                        System.out.println("[ERROR] " + e.getMessage());
                                        readChangePassword(sc, currentUser);
                                    }
                                    break;

                                case 4:
                                    logged = false;
                                    break;

                                default:
                                    break;
                            }
                        } while (logged);
                    } else {
                        System.out.println("Lo sentimos, nombre de usuario o contraseña incorrectos.");
                    }

                    break;

                case 2:

                    try {
                        readNewUser(sc);
                    } catch (Exception e) {
                        System.out.println("[ERROR] " + e.getMessage());
                        readNewUser(sc);
                    }

                    break;
                    case 3:
                    try {
                        readResetPassword(sc);
                    } catch (Exception e) {
                        System.out.println("[ERROR] " + e.getMessage());
                    }
                    break;
                case 4:
                    exit = true;
                    break;
                default:
                    break;
            }

        } while (!exit);
        sc.close();
    }

    public static void readResetPassword(Scanner sc) throws Exception{
        
        System.out.print("\nPor favor introduzca el nombre de usuario: ");
        String user = sc.nextLine();
        if (passManager.checkUserExits(user)) {
            
            System.out.print("\nResponda a la siguinte pregunta de seguridad: ");
            System.out.println(passManager.getUserInfo(user).getSecurityQuestion());
            String answer = passManager.getUserInfo(user).getSecurityQuestionAnwer();

            System.out.print("\nRespuesta: ");
            String userAnswer = sc.nextLine();
            if (answer.equals(userAnswer)) {
                System.out.println("Respuesta correcta.");
                UserInfo userInfo = passManager.getUserInfo(user);
                try {
                    readChangePassword(sc, userInfo);
                } catch (Exception e) {
                    System.out.println("[ERROR] " + e.getMessage());
                    readChangePassword(sc, userInfo);
                }
                
            } else {
                System.out.println("Respuesta incorrecta.");
            }
        }else{
            System.out.println("El usuario introducido no existe.");
        }
    }

    public static void readChangePassword(Scanner sc, UserInfo user) throws Exception {

        System.out.print("\nPor favor introduzca la nueva contraseña: ");
        String newPassword = sc.nextLine();

        System.out.print("\nPor favor introduzca de nuevo la contraseña: ");
        String newPasswordRepeat = sc.nextLine();

        if (newPassword.equals(newPasswordRepeat)) {
            passManager.changePassword(user, newPassword);
            System.out.println("Contraseña actualizada.");
        } else {
            throw new Exception("Las contraseñas no coinciden, inténtelo de nuevo");
        }
    }

    public static void readNewSecurityQuestion(Scanner sc, UserInfo user) {

        for (int i = 0; i < Questions.pool.length ; i++) {
            System.out.println("["+i+"] "+Questions.pool[i]);
        }
        System.out.print("\nPor favor elija una pregunta de seguridad: ");
        int chosenQuestion = Integer.parseInt(sc.nextLine());

        System.out.print("\nPor favor introduzca la respuesta a la pregunta: ");
        String chosenAnswer = sc.nextLine();

        passManager.setSecurityQuestion(user, Questions.pool[chosenQuestion], chosenAnswer);
        System.out.println("\nPregunta de seguridad actualizada.");
    }

    public static void readNewUser(Scanner sc) throws Exception {
        System.out.print("\nPor favor introduzca el nombre de usuario: ");
        String newUserUserName = sc.nextLine();

        System.out.print("\nPor favor introduzca un email: ");
        String newUserEmail = sc.nextLine();

        System.out.print("\nPor favor introduzca la contraseña: ");
        String newUserPassword = sc.nextLine();

        System.out.print("\nPor favor introduzca de nuevo la contraseña: ");
        String newUserPasswordRepeat = sc.nextLine();

        if (newUserPassword.equals(newUserPasswordRepeat)) {
            passManager.signUp(newUserUserName, newUserPassword, newUserEmail);
            System.out.println("Usuario '" + newUserUserName + "' creado.");
        } else {
            throw new Exception("Las contraseñas no coinciden, inténtelo de nuevo");
        }
    }
}
