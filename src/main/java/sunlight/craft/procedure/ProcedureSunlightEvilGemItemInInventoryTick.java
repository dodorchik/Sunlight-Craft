package sunlight.craft.procedure;

import sunlight.craft.potion.PotionEvil;
import sunlight.craft.ElementsScMod;

import net.minecraft.potion.PotionEffect;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.Entity;

import java.util.Map;
import java.util.Collection;

@ElementsScMod.ModElement.Tag
public class ProcedureSunlightEvilGemItemInInventoryTick extends ElementsScMod.ModElement {
	public ProcedureSunlightEvilGemItemInInventoryTick(ElementsScMod instance) {
		super(instance, 28);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure SunlightEvilGemItemInInventoryTick!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if ((!(new Object() {
			boolean check() {
				if (entity instanceof EntityLivingBase) {
					Collection<PotionEffect> effects = ((EntityLivingBase) entity).getActivePotionEffects();
					for (PotionEffect effect : effects) {
						if (effect.getPotion() == PotionEvil.potion)
							return true;
					}
				}
				return false;
			}
		}.check()))) {
			if (entity instanceof EntityLivingBase)
				((EntityLivingBase) entity).addPotionEffect(new PotionEffect(PotionEvil.potion, (int) 2000, (int) 2));
		}
	}
}
