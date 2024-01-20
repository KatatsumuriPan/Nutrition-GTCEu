package kpan.nutrition_gtceu.asm.acc;

import ca.wescook.nutrition.api.INutritionFood;
import gregtech.api.items.metaitem.stats.IFoodBehavior;
import kpan.nutrition_gtceu.FoodUtil;
import kpan.nutrition_gtceu.util.MyReflectionHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;

import javax.annotation.Nullable;

public interface ACC_MetaItem extends INutritionFood {

	@Override
	default int getHealAmount(ItemStack itemStack, @Nullable EntityPlayer player) {
		IFoodBehavior foodBehavior = FoodUtil.getFoodBehavior(itemStack);
		if (foodBehavior == null)
			return 0;
		return foodBehavior.getFoodLevel(itemStack, player);
	}

	@Override
	default void setAlwaysEdible(ItemStack itemStack, @Nullable EntityPlayer player) {
		if (FoodUtil.getFoodBehavior(itemStack) == null)
			return;
		MyReflectionHelper.setPrivateField(this, "alwaysEdible", true);
	}

}
