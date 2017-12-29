package de.madana.common.datastructures;

import org.joda.money.CurrencyUnit;
import org.joda.money.Money;

import java.util.ArrayList;
import java.util.List;

/**
 * Shopping cart of items that have a description and a price.
 *
 * @author Christian Plewnia
 */
public class ShoppingCart {

    /**
     * Shopping cart item.
     */
    public static class Item {
        private String description;
        private Money price;

        /**
         * A single item of the shopping cart.
         *
         * @param description Description of the item
         * @param price       Price of the item
         */
        public Item(String description, Money price) {
            this.description = description;
            this.price = price;
        }

        public String getDescription() {
            return description;
        }

        public Money getPrice() {
            return price;
        }
    }

    /**
     * Shopping cart's contents
     */
    private List<Item> items;

    /**
     * Shopping cart's currency
     */
    private CurrencyUnit currencyUnit;

    /**
     * Creates a new shopping cart for the given currency.
     *
     * @param currencyUnit Currency (e.g. CurrencyUnit.EUR for Euros)
     */
    public ShoppingCart(CurrencyUnit currencyUnit) {
        this.currencyUnit = currencyUnit;
        items = new ArrayList<>();
    }

    /**
     * Provides the shopping cart's content
     *
     * @return List of all items in the shopping cart
     */
    public List<Item> getItems() {
        return items;
    }

    /**
     * Add an item to the shopping cart
     *
     * Method allows for method chaining: shoppingCart.addItem(...).addItem(...);
     *
     * @param item Item to be added
     */
    public ShoppingCart addItem(Item item) {
        this.items.add(item);
        return this;
    }

    /**
     * The shopping cart's total value
     *
     * @return Total price
     */
    public Money totalPrice() {
        Money totalPrice = Money.zero(this.currencyUnit);
        for (Item item : items) {
            totalPrice.plus(item.getPrice());
        }
        return totalPrice;
    }

}
