package ci.dojo.gilderRose;

import java.util.Arrays;

class GildedRose {
    Item[] items;

    public GildedRose(Item... items) {
        notAllowProudctQualityMoreThan50(items);
        this.items = items;
    }

    private static void notAllowProudctQualityMoreThan50(Item... item) throws RuntimeException{
        Arrays.asList(item).forEach((currentItem) -> {
            if(currentItem.quality > 50)
                throw new RuntimeException(
                        String.format("product {%s} is {%s} must quality must equal or less than 50 ",
                                currentItem.name,
                                currentItem.quality
                                )
                );
        });
    }

    public void updateQuality() {
        for (Item item: items){
            updateOneItemQuality(item);
        }
    }

    public void updateOneItemQuality(Item item){
        // if timeout
        if(item.sellIn == 0){
            isQualityGreatThanZero(item);
        }
        // default
        isQualityGreatThanZero(item);
        item.sellIn--;

        if(item.name.equals("Aged Brie") && item.quality < 50)
            item.quality = item.quality+2;

        if(item.name.equals("Sulfuras, Hand of Ragnaros") && item.quality < 50){
            item.quality++;
            item.sellIn++;
        }
        if(item.name.equals("Backstage passes to a TAFKAL80ETC concert") && item.sellIn <= 10)
            item.quality = item.quality+3;

        if(item.name.equals("Backstage passes to a TAFKAL80ETC concert") && item.sellIn <= 5)
            item.quality++;

        if(item.name.equals("Conjured"))
            item.quality--;

    }

    private static void isQualityGreatThanZero(Item item) {
        if(item.quality > 0 && item.quality < 50) item.quality--;
    }

    public void updateQualityLegacyCodeBurk() {
        for (int i = 0; i < items.length; i++) {
            if (!items[i].name.equals("Aged Brie")
                    && !items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                if (items[i].quality > 0) {
                    if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
                        items[i].quality = items[i].quality - 1;
                    }
                }
            } else {
                if (items[i].quality < 50) {
                    items[i].quality = items[i].quality + 1;

                    if (items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                        if (items[i].sellIn < 11) {
                            if (items[i].quality < 50) {
                                items[i].quality = items[i].quality + 1;
                            }
                        }

                        if (items[i].sellIn < 6) {
                            if (items[i].quality < 50) {
                                items[i].quality = items[i].quality + 1;
                            }
                        }
                    }
                }
            }

            if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
                items[i].sellIn = items[i].sellIn - 1;
            }

            if (items[i].name.equals("Conjured")) {
                items[i].quality = items[i].quality - 1;
            }

            if (items[i].sellIn < 0) {
                if (!items[i].name.equals("Aged Brie")) {
                    if (!items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                        if (items[i].quality > 0) {
                            if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
                                items[i].quality = items[i].quality - 1;
                            }
                        }
                    } else {
                        items[i].quality = items[i].quality - items[i].quality;
                    }
                } else {
                    if (items[i].quality < 50) {
                        items[i].quality = items[i].quality + 1;
                    }
                }
            }
        }
    }
}