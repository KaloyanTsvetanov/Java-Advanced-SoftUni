public class Pokemon {
    private String nameOfPokemon;
    private String elementOfPokemon;

    public Pokemon(String nameOfPokemon, String elementOfPokemon) {
        this.nameOfPokemon = nameOfPokemon;
        this.elementOfPokemon = elementOfPokemon;
    }

    public String getNameOfPokemon() {
        return nameOfPokemon;
    }

    public void setNameOfPokemon(String nameOfPokemon) {
        this.nameOfPokemon = nameOfPokemon;
    }

    public String getElementOfPokemon() {
        return elementOfPokemon;
    }

    public void setElementOfPokemon(String elementOfPokemon) {
        this.elementOfPokemon = elementOfPokemon;
    }

    @Override
    public String toString() {
        return String.format(getNameOfPokemon()+" "+getElementOfPokemon());
    }
}
