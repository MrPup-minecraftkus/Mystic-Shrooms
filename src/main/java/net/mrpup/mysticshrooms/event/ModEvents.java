package net.mrpup.mysticshrooms.event;

import net.minecraft.world.item.alchemy.PotionBrewing;
import net.minecraft.world.item.alchemy.Potions;
import net.mrpup.mysticshrooms.MysticShrooms;
import net.mrpup.mysticshrooms.block.ModBlocks;
import net.mrpup.mysticshrooms.potion.ModPotions;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.brewing.RegisterBrewingRecipesEvent;

@EventBusSubscriber(modid = MysticShrooms.MOD_ID)
public class ModEvents {

    @SubscribeEvent
    public static void onBrewingRecipeRegister(RegisterBrewingRecipesEvent event) {
        PotionBrewing.Builder builder = event.getBuilder();

        builder.addMix(Potions.AWKWARD, ModBlocks.SOMNOLIS.asItem(), ModPotions.SOMNOLENCE_POTION);
        builder.addMix(Potions.AWKWARD, ModBlocks.PALE_SHROOM.asItem(), ModPotions.CHEERFULNESS_POTION);
        builder.addMix(ModPotions.SOMNOLENCE_POTION, ModBlocks.PALE_SHROOM.asItem(), ModPotions.ANTI_PHANTOM_POTION);
        builder.addMix(ModPotions.CHEERFULNESS_POTION, ModBlocks.SOMNOLIS.asItem(), ModPotions.ANTI_PHANTOM_POTION);
    }

}
