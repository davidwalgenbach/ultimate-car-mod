package de.maxhenkel.car.items;

import net.minecraft.world.item.Item;

public abstract class AbstractItemCarPart extends Item implements ICarPart {

    public AbstractItemCarPart(Properties properties) {
        super(properties);
    }

}