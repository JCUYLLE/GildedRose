package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    /**
     * for loop that goes over every item in the list items
     * and calls the method updateItem for every item.
     */
    public void updateQualityItems() {
        for (Item item: items){
            item.updateItem();
        }
    }

}