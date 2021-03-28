package _interview_questions;

import java.util.*;

/**
 * company: Google
 *
 * there is a Product, which can have multiple Offers of different prices.
 * example: iphone: offer-1: price=999.6
 * 	       : offer-2: price=895.5
 * 	       : offer-3: price=896.1
 * provide implementation of below 3 methods:
 *
 * //Add
 * void addOffer(long product_id, long offer_id, double offerPrice);
 *
 * //remove an offer
 * void removeOffer(long offer_id, long product_id);
 *
 * //find and return best offer
 * //ecample: if input price is 895.6 > best offer is offer-2
 * //       : if input price is 896   > best offer id offer-3
 * long getBestOffer(long product_id, double price);
 *
 */
public class FindBestOffer {

    private final Map<Long, List<Offer>> productsAndOffers;

    public FindBestOffer() {
        productsAndOffers = new HashMap<>();
    }

    // O(nlog n) - since we are sorting offers list on every add
    public void addOffer(long productId, long offerId, double price) {
        List<Offer> offers = null;
        if(productsAndOffers.containsKey(productId)) {
            offers = productsAndOffers.get(productId);
        } else {
            offers = new ArrayList<>();
            productsAndOffers.put(productId, offers);
        }
        offers.add(new Offer(offerId, price));
        Collections.sort(offers);
    }

    // O(n)
    public void removeOffer(long productId, long offerId) {
        if(!productsAndOffers.containsKey(productId))
            return;

        List<Offer> offers = productsAndOffers.get(productId);
        offers.removeIf(o -> o.offerId == offerId);
    }

    // O(log n) - due to binary search
    public double getBestOffer(long productId, double price) {
        List<Offer> offers = productsAndOffers.get(productId);
        int lo = 0;
        int hi = offers.size()-1;

        if(price < offers.get(0).offerPrice)
            return offers.get(0).offerPrice;

        if(price > offers.get(hi).offerPrice)
            return offers.get(hi).offerPrice;

        while(hi - lo > 2) {
            int mid = lo + (hi - lo)/2;
            double midPrice = offers.get(mid).offerPrice;
            if(price == midPrice)
                return offers.get(mid).offerPrice;

            if(price < midPrice)
                hi = mid;
            else
                lo = mid;
        }

        double price1 = offers.get(lo).offerPrice;
        double diff1 = Math.abs(price - productId);

        double price2 = offers.get(hi).offerPrice;
        double diff2 = Math.abs(price - price2);

        return diff1 < diff2 ? price1 : price2;
    }

    private static class Offer implements Comparable<Offer> {
        long offerId;
        double offerPrice;

        public Offer(long offerId, double offerPrice) {
            this.offerId = offerId;
            this.offerPrice = offerPrice;
        }

        @Override
        public int compareTo(Offer o) {
            return ((Double)offerPrice).compareTo(o.offerPrice);
        }

        @Override
        public boolean equals(Object o) {
            if(o == null)
                return false;
            if(! (o instanceof Offer))
                return false;
            Offer secondOffer = (Offer) o;
            return offerId == secondOffer.offerId;
        }

        @Override
        public int hashCode() {
            return Objects.hash(this.offerId);
        }
    }
}
