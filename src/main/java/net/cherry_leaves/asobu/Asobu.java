package net.cherry_leaves.asobu;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.component.type.FoodComponent;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;

import java.util.ArrayList;
import java.util.List;

import static net.cherry_leaves.asobu.Asobu.ModItems.register;

public class Asobu implements ModInitializer {


    static List<FoodComponent.StatusEffectEntry> statusEffects = new ArrayList<>();
    public static final Item special_edible_gunpowder = register(new Item(new Item.Settings().maxCount(64).rarity(Rarity.EPIC).food(new FoodComponent(3, 3, false, 1.6F , statusEffects))), "special_edible_gunpowder");
    public static final Item tekitou = register(new Item(new Item.Settings().maxCount(64).rarity(Rarity.COMMON)), "tekitou");

    public static final Identifier O_DISC_SOUND_ID = new Identifier("asobu", "music.o_disc");
    public static SoundEvent O_DISC_SOUND_EVENT = SoundEvent.of(O_DISC_SOUND_ID);
    public static final Item O_DISC = register(
            new MusicDiscItem(    15,
                    O_DISC_SOUND_EVENT,
                    new Item.Settings().maxCount(1).rarity(Rarity.RARE),
                    127 * 20
            ),
            "o_disc"
    );




    @Override
    public void onInitialize() {
        ModItems.initialize();
        Registry.register(Registries.SOUND_EVENT, O_DISC_SOUND_ID, O_DISC_SOUND_EVENT);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS).register(
                entries -> entries.add(O_DISC)
        );

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
            ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK)
                    .register((itemGroup) -> itemGroup.add(Asobu.special_edible_gunpowder));
            ItemGroupEvents.modifyEntriesEvent(ItemGroups.INVENTORY)
                    .register((itemGroup) -> itemGroup.add(Asobu.tekitou));
        }
    }
}
