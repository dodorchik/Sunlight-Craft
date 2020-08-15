
package sunlight.craft.creativetab;

import sunlight.craft.item.ItemSunlightEvilPortal;
import sunlight.craft.ElementsScMod;

import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.fml.relauncher.Side;

import net.minecraft.item.ItemStack;
import net.minecraft.creativetab.CreativeTabs;

@ElementsScMod.ModElement.Tag
public class TabSunlightCraftTab extends ElementsScMod.ModElement {
	public TabSunlightCraftTab(ElementsScMod instance) {
		super(instance, 35);
	}

	@Override
	public void initElements() {
		tab = new CreativeTabs("tabsunlight_craft_tab") {
			@SideOnly(Side.CLIENT)
			@Override
			public ItemStack getTabIconItem() {
				return new ItemStack(ItemSunlightEvilPortal.block, (int) (1));
			}

			@SideOnly(Side.CLIENT)
			public boolean hasSearchBar() {
				return false;
			}
		};
	}
	public static CreativeTabs tab;
}
