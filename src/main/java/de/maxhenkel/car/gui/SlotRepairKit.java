package de.maxhenkel.car.gui;

import de.maxhenkel.car.Config;
import de.maxhenkel.car.entity.car.base.EntityCarBatteryBase;
import de.maxhenkel.car.entity.car.base.EntityCarDamageBase;
import de.maxhenkel.car.items.ModItems;
import de.maxhenkel.car.sounds.ModSounds;
import de.maxhenkel.tools.ItemTools;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.InventoryBasic;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;

public class SlotRepairKit extends Slot{

	private EntityCarDamageBase car;

	public SlotRepairKit(EntityCarDamageBase car, int index, int xPosition, int yPosition) {
		super(new InventoryBasic("", false, 1), index, xPosition, yPosition);
		this.car=car;
	}

	@Override
	public void putStack(ItemStack stack) {
		if(stack==null){
			return;
		}

		if(!stack.getItem().equals(ModItems.REPAIR_KIT)){
			return;
		}

		if (car.getDamage() >= 90) {

			ItemTools.decrItemStack(stack, null);

			float damage = car.getDamage() - Config.repairKitRepairAmount;
			if (damage >= 0) {
				car.setDamage(damage);
			}
			ModSounds.playSound(ModSounds.ratchet, car.world, car.getPosition(), null, SoundCategory.BLOCKS);
		}

		EntityPlayer player=car.getDriver();

		if(player==null){
			InventoryHelper.spawnItemStack(car.world, car.posX, car.posY, car.posZ, stack);
			return;
		}

		if(!player.inventory.addItemStackToInventory(stack)){
			InventoryHelper.spawnItemStack(car.world, car.posX, car.posY, car.posZ, stack);
		}
	}

	@Override
	public boolean isItemValid(ItemStack stack) {
		return stack.getItem().equals(ModItems.REPAIR_KIT);
	}

}
