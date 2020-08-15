package sunlight.craft.procedure;

import sunlight.craft.ElementsScMod;

import net.minecraft.entity.Entity;

import java.util.Map;

@ElementsScMod.ModElement.Tag
public class ProcedureEvilPotionExpires extends ElementsScMod.ModElement {
	public ProcedureEvilPotionExpires(ElementsScMod instance) {
		super(instance, 25);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure EvilPotionExpires!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		entity.getEntityData().setDouble("scpdamage", 0);
		entity.getEntityData().setDouble("scpticks", 0);
		entity.getEntityData().setDouble("scpseconds", 0);
	}
}
