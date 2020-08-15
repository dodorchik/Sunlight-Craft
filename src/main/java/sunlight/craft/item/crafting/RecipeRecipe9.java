
package sunlight.craft.item.crafting;

import sunlight.craft.item.ItemSunlightnugget;
import sunlight.craft.block.BlockSunlightore;
import sunlight.craft.ElementsScMod;

import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

import net.minecraft.item.ItemStack;

@ElementsScMod.ModElement.Tag
public class RecipeRecipe9 extends ElementsScMod.ModElement {
	public RecipeRecipe9(ElementsScMod instance) {
		super(instance, 21);
	}

	@Override
	public void init(FMLInitializationEvent event) {
		GameRegistry.addSmelting(new ItemStack(BlockSunlightore.block, (int) (1)), new ItemStack(ItemSunlightnugget.block, (int) (1)), 1F);
	}
}
