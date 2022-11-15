import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

public class PokemonGo {

    public static HashMap<Integer, Pokemon> listaPokemon = new HashMap<>();
    static {
        
    }

    static Random numAleatorio = new Random();

    public PokemonGo() {
        listaPokemon.put(1, new Pokemon(1, "Bulbasaur", "Planta", 30, 1));
        listaPokemon.put(2, new Pokemon(2, "Charmander", "Fuego", 45, 1));
        listaPokemon.put(3, new Pokemon(3, "Squirtle", "Agua", 40, 1));
        listaPokemon.put(4, new Pokemon(4, "Nidoran", "Veneno", 40, 1));
        listaPokemon.put(5, new Pokemon(5, "Pikachu", "Eléctrico", 50, 1));
        listaPokemon.put(6, new Pokemon(6, "Caterpie", "Bicho", 25, 1));
        listaPokemon.put(7, new Pokemon(7, "Clefairy", "Hada", 35, 1));
        listaPokemon.put(8, new Pokemon(8, "Gastly", "Fantasma", 20, 1));
        listaPokemon.put(9, new Pokemon(9, "Cubone", "Tierra", 35, 1));
        listaPokemon.put(10, new Pokemon(10, "Pidgey", "Volador", 40, 1));
    }

    public static Pokemon getPokemon(int id) {
        return listaPokemon.get(id);
    }

    public static Pokemon getRandomPokemon() {

        return listaPokemon.get(numAleatorio.nextInt(listaPokemon.size() - 1));
    }

    public static void menu() {
        
        System.out.println("1.Lista de mi Pokemons. ");
        System.out.println("2.Entrenar Pokemon. ");
        System.out.println("3.Combatir contra pokemon salvaje. ");
        System.out.println("4.Combatir contra otro jugador. ");
        System.out.println("5.Salir. ");
        System.out.print("Elige una opción: ");
    }

    public void play(Scanner sc, UserInfo currentUser, ArrayList<UserInfo> userList) {
        int opcion;
        int numero;
        Pokemon miPokemon;
        int aleatorio;
        Pokemon enemigo;

        do {
            menu();
            
            opcion = Integer.parseInt(sc.nextLine()); 
            

            switch (opcion) {
                case 1:
                    for (int i = 0; i < currentUser.getListaUsuario().size(); i++) {
                        System.out.println((i + 1) + ". " + currentUser.getListaUsuario().get(i).toString());
                    }
                    break;
                case 2:
                    for (int i = 0; i < currentUser.getListaUsuario().size(); i++) {
                        System.out.println((i + 1) + ". " + currentUser.getListaUsuario().get(i).toString());
                    }

                    System.out.print("Elige un pokemon: ");
                    numero = Integer.parseInt( sc.nextLine());
                    miPokemon = currentUser.getListaUsuario().get(numero - 1);
                    miPokemon.entrenar();
                    System.out.println("El Pokemon " + miPokemon.getNombrePokemon() + " ha subido su fuerza "
                            + miPokemon.getFuerzaPokemon() + " y ha subido de nivel a " + miPokemon.getNivelPokemon()
                            + "\n");
                    break;
                case 3:
                    for (int i = 0; i < currentUser.getListaUsuario().size(); i++) {
                        System.out.println(i + 1 + ". " + currentUser.getListaUsuario().get(i).toString());
                    }
                    aleatorio = numAleatorio.nextInt(listaPokemon.size() - 1);
                    System.out.print("Elige un pokemon para luchar: ");
                    numero = Integer.parseInt( sc.nextLine());
                    miPokemon = currentUser.getListaUsuario().get(numero - 1);
                    enemigo = listaPokemon.get(aleatorio);
                    System.out.println("Se ha encontrado un Pokemon para combatir: " + enemigo.getNombrePokemon());
                    //miPokemon.combatir(enemigo);

                    if (miPokemon.combatir(enemigo)) {
                        miPokemon.setNivelPokemon(miPokemon.getNivelPokemon() + 2);
                        currentUser.getListaUsuario().add(enemigo);
                        System.out.println("¡Has ganado! " + "," + " tu Pokemon " + miPokemon.getNombrePokemon()
                                + " ha subido al nivel " + miPokemon.getNivelPokemon());
                        System.out.println(
                                "¡Se ha añadidio nuevo Pokemon a tu lista: " + enemigo.getNombrePokemon() + ".");
                    }else{
                        System.out.println("¡Has perdido!");
                    }
                    break;
                case 4:
                    System.out.println("\nLista de entrenadores: ");
                    int i = 0;
                    for (UserInfo s : userList) {
                        System.out.println("[" + i + "] - " + s.getUserName());
                        i++;
                    }

                    System.out.print("\nPor favor introduzca el nombre del adversario: ");
                    int selectedTrainer = Integer.parseInt(sc.nextLine()) ;

                    
                    UserInfo enemyTrainer = userList.get(selectedTrainer);

                    miPokemon = currentUser.getListaUsuario().get(0);
                    enemigo = enemyTrainer.getListaUsuario().get(0);

                    if (miPokemon.combatir(enemigo)) {
                        miPokemon.setNivelPokemon(miPokemon.getNivelPokemon() + 2);
                        currentUser.getListaUsuario().add(enemigo);
                        System.out.println("!Has ganadao¡ " + "," + " tu Pokemon " + miPokemon.getNombrePokemon()
                                + " ha subido al nivel " + miPokemon.getNivelPokemon());
                        System.out.println(
                                "¡Se ha añadidio nuevo Pokemon a tu lista: " + enemigo.getNombrePokemon() + ".");

                        enemyTrainer.removePokemon(enemigo);
                    }else{
                        System.out.println("¡Has perdido!");
                    }

                    break;
            }

        } while (opcion != 5);
    }

}
