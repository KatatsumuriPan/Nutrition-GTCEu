package kpan.nutrition_gtceu;

import gregtech.api.items.metaitem.FoodUseManager;
import gregtech.api.items.metaitem.MetaItem;
import gregtech.api.items.metaitem.stats.IFoodBehavior;
import gregtech.api.items.metaitem.stats.IItemUseManager;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import javax.annotation.Nullable;

public class FoodUtil {
	@Nullable
	public static IFoodBehavior getFoodBehavior(ItemStack itemStack) {
		Item item = itemStack.getItem();
		if (!(item instanceof MetaItem<?> metaItem))
			return null;
		MetaItem<?>.MetaValueItem metaValueItem = metaItem.getItem(itemStack);
		if (metaValueItem == null)
			return null;
		IItemUseManager useManager = metaValueItem.getUseManager();
		if (useManager instanceof FoodUseManager foodUseManager)
			return foodUseManager.getFoodStats();
		return null;
	}
}
