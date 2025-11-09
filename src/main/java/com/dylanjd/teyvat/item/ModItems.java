package com.dylanjd.teyvat.item;

import com.dylanjd.teyvat.Teyvat;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModItems {
    public static DeferredRegister.Items ITEMS = DeferredRegister.createItems(Teyvat.MODID);

    public static final Supplier<Item> COR_LAPIS = ITEMS.registerItem(
            "cor_lapis",
            Item::new, // The factory that the properties will be passed into
            new Item.Properties() // The properties to use
    );

    public static final Supplier<AnemoVisionItem> ANEMO_VISION = ITEMS.registerItem(
            "anemo_vision",
            AnemoVisionItem::new,
            new AnemoVisionItem.Properties()
    );

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
