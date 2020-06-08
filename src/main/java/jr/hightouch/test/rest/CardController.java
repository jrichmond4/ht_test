package jr.hightouch.test.rest;

import jr.hightouch.test.data.facade.ICardService;
import jr.hightouch.test.data.model.Card;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Optional;

@RestController
public class CardController {
    @Autowired
    private ICardService cardService;

    @GetMapping("/cards")
    public ResponseEntity<Iterable<Card>> getCards() {
        return ResponseEntity.ok(cardService.getCards());
    }

    @GetMapping("/cards/{id}")
    public Object getCard(@PathVariable long id) {
        Optional<Card> card = cardService.getCard(id);

        if (!card.isPresent())
            return ResponseEntity.notFound();

        return ResponseEntity.ok(card.get());
    }

    @PostMapping("/cards")
    public ResponseEntity<Card> createCard(@RequestBody Card card) {
            Card newCard = cardService.saveCard(card);

            URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                    .buildAndExpand(newCard.getId()).toUri();

            return ResponseEntity.created(location).build();
    }

    @PutMapping("/cards/{id}")
    public ResponseEntity<Object> updateCard(@RequestBody Card card, @PathVariable long id) {

        Optional<Card> cardOptional = cardService.getCard(id);

        if (!cardOptional.isPresent())
            return ResponseEntity.notFound().build();

        card.setId(id);

        cardService.saveCard(card);

        return ResponseEntity.noContent().build();
    }
}
