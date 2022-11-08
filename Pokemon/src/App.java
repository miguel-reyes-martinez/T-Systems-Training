import java.util.ArrayList;
import java.util.Scanner;

public class App {

    private static boolean exit = false;
    private static ArrayList<Pokemon> myTeam = new ArrayList<Pokemon>();
    private static ArrayList<Pokemon> enemyPokemons = new ArrayList<Pokemon>();

    public static void main(String[] args) throws Exception {

        //Mi pokemon inicial
        myTeam.add(new Pokemon(new Species(Generation1.BULBASAUR), 14));

        //Lista de pokemons enemigos
        enemyPokemons.add(new Pokemon(new Species(Generation1.SQUIRTLE), 12));
        enemyPokemons.add(new Pokemon(new Species(Generation1.CHARMANDER), 14));

        System.out.println("¡Bienvenido al mundo Pokémon!");

        do {
            System.out.println("¿Qué vas ha hacer?");
            System.out.println("\t( 1 ) Consultar equipo.");
            System.out.println("\t( 2 ) Entrenar a un pokémon.");
            System.out.println("\t( 3 ) Combatir contra un pokémon.");
            System.out.println("\t( 4 ) Salir.");
            System.out.print("Mi elección [1-4]:\t");

            Scanner sc = new Scanner(System.in);
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                System.out.println("Esta es tu lista de pokémons:");
                for (Pokemon p : myTeam) {
                    System.out.println(p.toString());
                }
                    break;

                case 2:
                int i = 0;
                for (Pokemon p : myTeam) {
                    System.out.print("("+i+") "+p.getName()+"\t");
                    i++;
                }
                System.out.print("\nElige a un pokemon [0-"+(i-1)+"]:\t");
                Scanner scPokemon = new Scanner(System.in);
                int chosenPokemon = scPokemon.nextInt();
                if (chosenPokemon < i) {
                    myTeam.get(chosenPokemon).train();
                    myTeam.get(chosenPokemon).levelUp();  
                }
                    
                    break;
                case 3:
                    int pickedPokemon = (int)(Math.random() * enemyPokemons.size());
                    myTeam.get(0).fight(enemyPokemons.get(pickedPokemon));
                    
                    break;
                case 4:
                exit = true;
                break;

                default:
                    break;
            }
            sc.close();

        } while (!exit);
        
    }
}
