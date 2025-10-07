package net.mrpup.mysticshrooms;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.registry.FabricBrewingRecipeRegistryBuilder;
import net.minecraft.potion.Potions;
import net.mrpup.mysticshrooms.block.ModBlocks;
import net.mrpup.mysticshrooms.effect.ModEffects;
import net.mrpup.mysticshrooms.item.ModItemGroups;
import net.mrpup.mysticshrooms.potion.ModPotions;
import net.mrpup.mysticshrooms.world.ModTreeDecorators;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MysticShrooms implements ModInitializer {
	public static final String MOD_ID = "mystic_shrooms";

	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {

        ModBlocks.registerModBlocks();

        ModEffects.registerEffects();
        ModPotions.registerPotions();

        ModItemGroups.registerItemGroups();

        ModTreeDecorators.register();

        FabricBrewingRecipeRegistryBuilder.BUILD.register(builder -> {
            builder.registerPotionRecipe(Potions.AWKWARD, ModBlocks.PALE_SHROOM.asItem(), ModPotions.CHEERFULNESS_POTION);
            builder.registerPotionRecipe(Potions.AWKWARD, ModBlocks.SOMNOLIS.asItem(), ModPotions.SOMNOLENCE_POTION);
            builder.registerPotionRecipe(ModPotions.SOMNOLENCE_POTION, ModBlocks.PALE_SHROOM.asItem(), ModPotions.ANTI_PHANTOM_POTION);
            builder.registerPotionRecipe(ModPotions.CHEERFULNESS_POTION, ModBlocks.SOMNOLIS.asItem(), ModPotions.ANTI_PHANTOM_POTION);
        });
	}
}