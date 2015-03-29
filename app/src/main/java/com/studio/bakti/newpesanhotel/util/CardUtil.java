package com.studio.bakti.newpesanhotel.util;

import it.gmariotti.cardslib.library.internal.Card;
import it.gmariotti.cardslib.library.internal.CardHeader;
import it.gmariotti.cardslib.library.internal.CardThumbnail;

import com.studio.bakti.newpesanhotel.R;
import com.studio.bakti.newpesanhotel.model.SearchResult;
import com.studio.bakti.newpesanhotel.view.card.CardThumbnailCircle;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;

/**
 * Created by bakti on 3/29/15.
 */
public class CardUtil {
    public static ArrayList<Card> getCards(Context context, List<SearchResult.SearchItem> items) {
        ArrayList<Card> cards;
        cards = new ArrayList<Card>();
        for (SearchResult.SearchItem item : items) {
            Card card = new Card(context);
            CardHeader header = new CardHeader(context);
            header.setTitle(item.getName());
            card.setTitle("Rp " + item.getPrice() +
                    "\n" + item.getAddress());
            card.addCardHeader(header);
            card.setSwipeable(true);
            CardThumbnail thumb = new CardThumbnailCircle(context);
            card.addCardThumbnail(thumb);
            String URLPhoto = item.getPhotoPrimary();
            thumb.setUrlResource(URLPhoto);
            card.addCardThumbnail(thumb);
            cards.add(card);
        }
        return cards;
    }
}
