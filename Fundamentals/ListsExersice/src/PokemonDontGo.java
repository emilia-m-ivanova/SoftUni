import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PokemonDontGo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> pokemonDistance = readList(scanner);
        int sum = 0;

        while (!pokemonDistance.isEmpty()) {
            int index = Integer.parseInt(scanner.nextLine());
            int currentPokemon = catchPokemon(pokemonDistance, index);
            sum+=currentPokemon;
            changePokemons(pokemonDistance,currentPokemon);
        }

        System.out.println(sum);
    }

    private static void changePokemons(List<Integer> pokemonDistance, int currentPokemon) {
        for (int i = 0; i < pokemonDistance.size(); i++) {
            int element = pokemonDistance.get(i);
            if(element<=currentPokemon){
                pokemonDistance.set(i,element+currentPokemon);
            }else {
                pokemonDistance.set(i,element-currentPokemon);
            }
        }

    }

    private static int catchPokemon(List<Integer> pokemonDistance, int index) {
        int currentPokemon;
        if (index < 0) {
            currentPokemon = pokemonDistance.get(0);
            pokemonDistance.set(0, pokemonDistance.get(pokemonDistance.size()-1));
        } else if (index >= pokemonDistance.size()) {
            currentPokemon = pokemonDistance.get(pokemonDistance.size() - 1);
            pokemonDistance.set(pokemonDistance.size() - 1, pokemonDistance.get(0));
        } else {
            currentPokemon = pokemonDistance.get(index);
            pokemonDistance.remove(index);
        }
        return currentPokemon;
    }

    private static List<Integer> readList(Scanner scanner) {
        String[] integersAsString = scanner.nextLine().split(" ");
        List<Integer> integerList = new ArrayList<>();
        for (String element : integersAsString) {
            integerList.add(Integer.parseInt(element));
        }
        return integerList;
    }
}
