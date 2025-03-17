import java.util.Random;

public class Mulligan {


        public void mulliganOdds(){
            double trials = 10000;//number of trials
            int handSize = 7;//how many cards in hand
            int pokemonCount = 1;//amount of pokemon in deck
            int mulliganCounter = 0;//amount of time we had to mulligan
            //assigns a 60 card deck
            Card[] pokemonDeck = new Card[60];
            for (int i = 0; i < pokemonDeck.length; i++) {
                pokemonDeck[i] = new Card();
            }
            //puts one pokemon card in deck and 59 energies
            pokemonDeck[0].setPokemonCard("pokemon");
            for(int i = 1; i < pokemonDeck.length; i++){
                pokemonDeck[i].setPokemonCard("energy");
            }

            for(int trial = 0; trial < trials; trial++){
                //shuffles Deck
                Random rand = new Random();
                for(int i = pokemonDeck.length - 1; i > 0; i--){
                    int j = rand.nextInt(i + 1);
                    Card temp = pokemonDeck[i];
                    pokemonDeck[i] = pokemonDeck[j];
                    pokemonDeck[j] = temp;
                }
                //checks your hand for a pokemon card
                boolean isPokemon = false;
                for(int card = 0; card < handSize; card++){
                    if("pokemon".equals(pokemonDeck[card].getPokemonCard())){
                        isPokemon = true;
                        break;
                        }
                    }

                if(!isPokemon){
                    //updates mulligan counter if no pokemon was found
                    mulliganCounter++;
                }
                //gives you the odds of a mulligan after 10000 trials
                if((trial + 1) % trials == 0){
                    double odds = (mulliganCounter / trials) * 100;
                    System.out.println("The pokemon cards in deck are:" + pokemonCount);
                    System.out.println("The odds of a mulligan are:" + odds);

                }
                //updates the number of pokemon cards in deck
                if((trial + 1) % trials == 0 && pokemonCount < pokemonDeck.length){
                    for(int i = 0; i < pokemonDeck.length; i++){
                        if("energy".equals(pokemonDeck[i].getPokemonCard())){
                            //sets a energy card to a pokemon card
                            pokemonDeck[i].setPokemonCard("pokemon");
                            pokemonCount++;//updates the amount of pokemon cards in deck
                            mulliganCounter = 0;//resets mulligan counter
                            trial = 0;//resets trial
                            break;
                        }
                    }
                }
            }

        }

}
