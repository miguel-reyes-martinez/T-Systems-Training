public class Pokemon {
    private int numPokemon;
    private String nombrePokemon;
    private String tipoPokemon;
    private int fuerzaPokemon;
    private int nivelPokemon;
    
    public Pokemon(int numPokemon, String nombrePokemon, String tipoPokemon, int fuerzaPokemon, int nivelPokemon){
        this.numPokemon=numPokemon;
        this.nombrePokemon=nombrePokemon;
        this.tipoPokemon=tipoPokemon;
        this.fuerzaPokemon=fuerzaPokemon;
        this.nivelPokemon=nivelPokemon;
    }

    public Pokemon(Pokemon other){
        this.numPokemon= other.numPokemon;
        this.nombrePokemon= other.nombrePokemon;
        this.tipoPokemon= other.tipoPokemon;
        this.fuerzaPokemon= other.fuerzaPokemon;
        this.nivelPokemon= other.nivelPokemon;
    }
    
    @Override
    public String toString(){
        return nombrePokemon + " de tipo "+ tipoPokemon +", su fuerza es "+ fuerzaPokemon + " y su nivel es el " + nivelPokemon;
    }
  
    public void entrenar(){
        ++nivelPokemon;
        fuerzaPokemon *= 1.5;
    }
    
    public boolean combatir(Pokemon enemigo){
        int fuerzaEnemigo=enemigo.getFuerzaPokemon();
        int fuerzaJugador=fuerzaPokemon;
        
        return fuerzaJugador > fuerzaEnemigo;
    }
    
    public int getNumPokemon() {
        return numPokemon;
    }

    public void setNumPokemon(int numPokemon) {
        this.numPokemon = numPokemon;
    }

    public String getNombrePokemon() {
        return nombrePokemon;
    }

    public void setNombrePokemon(String nombrePokemon) {
        this.nombrePokemon = nombrePokemon;
    }

    public String getTipoPokemon() {
        return tipoPokemon;
    }

    public void setTipoPokemon(String tipoPokemon) {
        this.tipoPokemon = tipoPokemon;
    }

    public int getFuerzaPokemon() {
        return fuerzaPokemon;
    }

    public void setFuerzaPokemon(int fuerzaPokemon) {
        this.fuerzaPokemon = fuerzaPokemon;
    }

    public int getNivelPokemon() {
        return nivelPokemon;
    }

    public void setNivelPokemon(int nivelPokemon) {
        this.nivelPokemon = nivelPokemon;
    }
       
}
