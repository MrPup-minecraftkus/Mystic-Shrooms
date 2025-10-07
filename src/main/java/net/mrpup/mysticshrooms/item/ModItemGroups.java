package net.mrpup.mysticshrooms.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.PotionContentsComponent;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.potion.Potion;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.mrpup.mysticshrooms.MysticShrooms;
import net.mrpup.mysticshrooms.block.ModBlocks;
import net.mrpup.mysticshrooms.potion.ModPotions;

public class ModItemGroups {

    private static ItemStack createPotionStack(RegistryEntry<Potion> potionEntry, Item base) {
        ItemStack stack = new ItemStack(base);
        stack.set(DataComponentTypes.POTION_CONTENTS, new PotionContentsComponent(potionEntry));
        return stack;
    }

    public static final ItemGroup MYSTIC_SHROOMS = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(MysticShrooms.MOD_ID, "mystic_shrooms"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModBlocks.SOMNOLIS))
                    .displayName(Text.translatable("itemgroup.mystic_shrooms.mystic_shrooms"))
                    .entries((displayContext, entries) -> {

                        entries.add(ModBlocks.SOMNOLIS);
                        entries.add(ModBlocks.PALE_SHROOM);
                        entries.add(createPotionStack(ModPotions.SOMNOLENCE_POTION, Items.POTION));
                        entries.add(createPotionStack(ModPotions.CHEERFULNESS_POTION, Items.POTION));
                        entries.add(createPotionStack(ModPotions.ANTI_PHANTOM_POTION, Items.POTION));


                    }).build());



    public static void registerItemGroups() {
    }
}
