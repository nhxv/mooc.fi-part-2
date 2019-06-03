import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Hand implements Comparable<Hand> {

    private List<Card> cardList;

    public Hand() {
        this.cardList = new ArrayList<Card>();
    }

    public void add(Card card) {
        cardList.add(card);
    }

    public void print() {
        for (Card card : cardList) {
            System.out.println(card);
        }
    }

    public void sort() {
        Collections.sort(cardList);
    }

    public void sortAgainstSuit() {
        Collections.sort(cardList, new SortAgainstSuitAndValue());
    }

    public int getCardValue() {
        int cardValue = 0;
        for (Card card : cardList) {
            cardValue += card.getValue();
        }
        return cardValue;
    }

    @Override
    public int compareTo(Hand card) {
        return this.getCardValue() - card.getCardValue();
    }
}
