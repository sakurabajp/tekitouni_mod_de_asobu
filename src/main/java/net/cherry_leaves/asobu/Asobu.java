package net.cherry_leaves.asobu;

import net.fabricmc.api.ModInitializer;
import net.minecraft.component.type.FoodComponent;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class Asobu implements ModInitializer {

    public static final Item SUSPICIOUS_SUBSTANCE = ModItems.register(
            new Item(new Item.Settings().food(new FoodComponent(1, 1,false ,1, null))),
            "suspicious_substance"
    );

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
        }
    }
}
