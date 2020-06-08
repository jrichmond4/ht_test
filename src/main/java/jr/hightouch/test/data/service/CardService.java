package jr.hightouch.test.data.service;

import jr.hightouch.test.data.facade.ICardService;
import jr.hightouch.test.data.model.Card;
import jr.hightouch.test.data.repository.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CardService implements ICardService {
    @Autowired
    private CardRepository cardRepository;

    public Iterable<Card> getCards() {
        return cardRepository.findAll();
    }

    @Override
    public Card saveCard(Card card) {
        return cardRepository.save(card);
    }

    @Override
    public Card updateCard(Card card) {
        return cardRepository.save(card);
    }

    @Override
    public Optional<Card> getCard(long id) {
        return cardRepository.findById(id);
    }
}
