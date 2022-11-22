package com.pm.deckofcardsapi;

import com.pm.deckofcards.Card;
import com.pm.deckofcards.DeckOfCards;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/deckofcards")
public class DeckOfCardsApi {

    DeckOfCards activeDeckOfCards = null;

    /**
     * Show the deck
     *
     * @return the complete list of cards currently in the deck
     */
    @GetMapping
    public List<Card> show() {
        return (activeDeckOfCards != null) ? activeDeckOfCards.getCards() : new ArrayList<>();
    }

    @GetMapping("/size")
    public Integer size(){
        return (activeDeckOfCards != null) ? activeDeckOfCards.size() : null;
    }

    /**
     * Create a new deck
     */
    @PostMapping
    public void create() {
        activeDeckOfCards = new DeckOfCards();
    }

    /**
     * Shuffle the current active deck
     */
    @PutMapping("/shuffle")
    public void shuffle() {
        if (activeDeckOfCards != null) {
            this.activeDeckOfCards.shuffle();
        }
    }

    /**
     * Deal one card from the deck.
     * Currently returns the first card in the deck.
     *
     * @return the first card in the deck
     */
    @PostMapping("/dealone")
    public Card dealOneCard() {
        Card cardDealt = null;
        if (activeDeckOfCards != null) {
            cardDealt = activeDeckOfCards.dealOneCard();
        }
        return cardDealt;
    }


}
