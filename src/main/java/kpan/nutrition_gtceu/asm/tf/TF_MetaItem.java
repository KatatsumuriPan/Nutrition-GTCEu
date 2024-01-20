package kpan.nutrition_gtceu.asm.tf;

import kpan.nutrition_gtceu.asm.core.AsmTypes;
import kpan.nutrition_gtceu.asm.core.adapters.MixinAccessorAdapter;
import org.objectweb.asm.ClassVisitor;

public class TF_MetaItem {

	private static final String TARGET = "gregtech.api.items.metaitem.MetaItem";
	private static final String ACC = AsmTypes.ACC + "ACC_" + "MetaItem";

	public static ClassVisitor appendVisitor(ClassVisitor cv, String className) {
		if (!TARGET.equals(className))
			return cv;
		ClassVisitor newcv = new MixinAccessorAdapter(cv, className, ACC);
		return newcv;
	}
}
