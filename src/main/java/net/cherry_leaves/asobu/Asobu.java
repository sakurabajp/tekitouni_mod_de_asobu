package net.cherry_leaves.asobu;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.component.type.FoodComponent;
import net.minecraft.item.Item;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;

public class Asobu implements ModInitializer {

    public static final Item special_edible_gunpowder = ModItems.register(
            new Item(new Item.Settings().maxCount(63).rarity(Rarity.EPIC)), "special_edible_gunpowder");


    @Override
    public void onInitialize() {
        ModItems.initialize();
    }

    public static class ModItems {
        public static Item register(Item item, String id) {
            Identifier itemID = Identifier.of("asobu", id);
            Item registeredItem = Registry.register(Registries.ITEM, itemID, item);
            return registeredItem;
        }

        public static void initialize() {
            ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS)
                    .register((itemGroup) -> itemGroup.add(Asobu.special_edible_gunpowder));
        }
    }
}
