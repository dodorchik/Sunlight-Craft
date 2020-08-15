package sunlight.craft.procedure;

import sunlight.craft.ElementsScMod;

import net.minecraft.util.DamageSource;
import net.minecraft.entity.Entity;

import java.util.Map;

@ElementsScMod.ModElement.Tag
public class ProcedureEvilOnPotionActiveTick extends ElementsScMod.ModElement {
	public ProcedureEvilOnPotionActiveTick(ElementsScMod instance) {
		super(instance, 33);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure EvilOnPotionActiveTick!");
			return;
		}
		if (dependencies.get("amplifier") == null) {
			System.err.println("Failed to load dependency amplifier for procedure EvilOnPotionActiveTick!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		int amplifier = (int) dependencies.get("amplifier");
		double seconds = 0;
		double ticks = 0;
		double damage = 0;
		double lvl = 0;
		if (((amplifier) != 0)) {
			lvl = (double) (amplifier);
		} else {
			lvl = (double) 1;
		}
		ticks = (double) (entity.getEntityData().getDouble("scpticks"));
		seconds = (double) (entity.getEntityData().getDouble("scpseconds"));
		damage = (double) (entity.getEntityData().getDouble("scpdamage"));
		for (int index0 = 0; index0 < (int) (1); index0++) {
			ticks = (double) ((ticks) + 1);
			if (((ticks) >= (40 / (lvl)))) {
				seconds = (double) ((seconds) + 1);
				ticks = (double) 0;
			}
			if (((seconds) == (20 / (lvl)))) {
				entity.attackEntityFrom(DamageSource.MAGIC, (float) (damage));
				System.out.println("Deal damage!");
			} else if (((seconds) >= (40 / (lvl)))) {
				damage = (double) ((damage) + 1);
				seconds = (double) 0;
				System.out.println("Damage up!");
			}
		}
		entity.getEntityData().setDouble("scpdamage", (damage));
		entity.getEntityData().setDouble("scpticks", (ticks));
		entity.getEntityData().setDouble("scpseconds", (seconds));
	}
}
