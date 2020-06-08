package jr.hightouch.test.data.facade;


import jr.hightouch.test.data.model.Card;

import java.util.List;
import java.util.Optional;

public interface ICardService {
    Iterable<Card> getCards();
    Card saveCard(Card card);
    Card updateCard(Card card);

    Optional<Card> getCard(long id);
}
