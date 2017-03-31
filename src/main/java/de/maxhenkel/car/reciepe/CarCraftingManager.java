package de.maxhenkel.car.reciepe;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Nullable;
import de.maxhenkel.car.items.ModItems;
import net.minecraft.block.Block;
import net.minecraft.block.BlockPlanks.EnumType;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class CarCraftingManager {
	private static final CarCraftingManager INSTANCE = new CarCraftingManager();
	private final List<ICarRecipe> recipes;

	public static CarCraftingManager getInstance() {
		return INSTANCE;
	}

	private CarCraftingManager() {
		this.recipes=new ArrayList<ICarRecipe>();
		addRecipe(new CarBuilderWoodCar(EnumType.OAK), "car_wood_oak", "XWSUC", "EPFPP", "TTXTT", 
				Character.valueOf('W'), new ItemStack(ModItems.WINDSHIELD),
				Character.valueOf('S'), new ItemStack(ModItems.CAR_SEAT),
				Character.valueOf('E'), new ItemStack(ModItems.ENGINE_3_CYLINDER),
				Character.valueOf('T'), new ItemStack(ModItems.WOODEN_WHEEL),
				Character.valueOf('U'), new ItemStack(ModItems.CONTROL_UNIT),
				Character.valueOf('C'), new ItemStack(Blocks.CHEST),
				Character.valueOf('F'), new ItemStack(ModItems.CAR_TANK),
				Character.valueOf('P'), new ItemStack(ModItems.CAR_BODY_PART_WOOD, 1, 0));
		
		addRecipe(new CarBuilderWoodCar(EnumType.SPRUCE), "car_wood_spruce", "XWSUC", "EPFPP", "TTXTT", 
				Character.valueOf('W'), new ItemStack(ModItems.WINDSHIELD),
				Character.valueOf('S'), new ItemStack(ModItems.CAR_SEAT),
				Character.valueOf('E'), new ItemStack(ModItems.ENGINE_3_CYLINDER),
				Character.valueOf('T'), new ItemStack(ModItems.WOODEN_WHEEL),
				Character.valueOf('U'), new ItemStack(ModItems.CONTROL_UNIT),
				Character.valueOf('C'), new ItemStack(Blocks.CHEST),
				Character.valueOf('F'), new ItemStack(ModItems.CAR_TANK),
				Character.valueOf('P'), new ItemStack(ModItems.CAR_BODY_PART_WOOD, 1, 1));
		
		addRecipe(new CarBuilderWoodCar(EnumType.BIRCH), "car_wood_birch", "XWSUC", "EPFPP", "TTXTT", 
				Character.valueOf('W'), new ItemStack(ModItems.WINDSHIELD),
				Character.valueOf('S'), new ItemStack(ModItems.CAR_SEAT),
				Character.valueOf('E'), new ItemStack(ModItems.ENGINE_3_CYLINDER),
				Character.valueOf('T'), new ItemStack(ModItems.WOODEN_WHEEL),
				Character.valueOf('U'), new ItemStack(ModItems.CONTROL_UNIT),
				Character.valueOf('C'), new ItemStack(Blocks.CHEST),
				Character.valueOf('F'), new ItemStack(ModItems.CAR_TANK),
				Character.valueOf('P'), new ItemStack(ModItems.CAR_BODY_PART_WOOD, 1, 2));
		
		addRecipe(new CarBuilderWoodCar(EnumType.JUNGLE), "car_wood_jungle", "XWSUC", "EPFPP", "TTXTT", 
				Character.valueOf('W'), new ItemStack(ModItems.WINDSHIELD),
				Character.valueOf('S'), new ItemStack(ModItems.CAR_SEAT),
				Character.valueOf('E'), new ItemStack(ModItems.ENGINE_3_CYLINDER),
				Character.valueOf('T'), new ItemStack(ModItems.WOODEN_WHEEL),
				Character.valueOf('U'), new ItemStack(ModItems.CONTROL_UNIT),
				Character.valueOf('C'), new ItemStack(Blocks.CHEST),
				Character.valueOf('F'), new ItemStack(ModItems.CAR_TANK),
				Character.valueOf('P'), new ItemStack(ModItems.CAR_BODY_PART_WOOD, 1, 3));
		
		addRecipe(new CarBuilderWoodCar(EnumType.ACACIA), "car_wood_acacia", "XWSUC", "EPFPP", "TTXTT", 
				Character.valueOf('W'), new ItemStack(ModItems.WINDSHIELD),
				Character.valueOf('S'), new ItemStack(ModItems.CAR_SEAT),
				Character.valueOf('E'), new ItemStack(ModItems.ENGINE_3_CYLINDER),
				Character.valueOf('T'), new ItemStack(ModItems.WOODEN_WHEEL),
				Character.valueOf('U'), new ItemStack(ModItems.CONTROL_UNIT),
				Character.valueOf('C'), new ItemStack(Blocks.CHEST),
				Character.valueOf('F'), new ItemStack(ModItems.CAR_TANK),
				Character.valueOf('P'), new ItemStack(ModItems.CAR_BODY_PART_WOOD, 1, 4));
		
		addRecipe(new CarBuilderWoodCar(EnumType.DARK_OAK), "car_wood_dark_oak", "XWSUC", "EPFPP", "TTXTT", 
				Character.valueOf('W'), new ItemStack(ModItems.WINDSHIELD),
				Character.valueOf('S'), new ItemStack(ModItems.CAR_SEAT),
				Character.valueOf('E'), new ItemStack(ModItems.ENGINE_3_CYLINDER),
				Character.valueOf('T'), new ItemStack(ModItems.WOODEN_WHEEL),
				Character.valueOf('U'), new ItemStack(ModItems.CONTROL_UNIT),
				Character.valueOf('C'), new ItemStack(Blocks.CHEST),
				Character.valueOf('F'), new ItemStack(ModItems.CAR_TANK),
				Character.valueOf('P'), new ItemStack(ModItems.CAR_BODY_PART_WOOD, 1, 5));
		
		//Big car
		
		addRecipe(new CarBuilderWoodCarBig(EnumType.OAK), "car_big_wood_oak", "WSSUC", "EPFPP", "TTXTT", 
				Character.valueOf('W'), new ItemStack(ModItems.WINDSHIELD),
				Character.valueOf('S'), new ItemStack(ModItems.CAR_SEAT),
				Character.valueOf('E'), new ItemStack(ModItems.ENGINE_3_CYLINDER),
				Character.valueOf('T'), new ItemStack(ModItems.WOODEN_WHEEL),
				Character.valueOf('U'), new ItemStack(ModItems.CONTROL_UNIT),
				Character.valueOf('C'), new ItemStack(Blocks.CHEST),
				Character.valueOf('F'), new ItemStack(ModItems.CAR_TANK),
				Character.valueOf('P'), new ItemStack(ModItems.CAR_BODY_PART_WOOD, 1, 0));
	}

	public void addRecipe(ICarbuilder builder , String name, Object... recipeComponents) {

		String pattern=new String();
		
		int offset=0;
		
		while (recipeComponents[offset] instanceof String) {
			pattern=pattern+recipeComponents[offset];
			
			offset++;
			
			if(offset>=recipeComponents.length){
				break;
			}
		}
		
		Map<Character, ItemStack> map=new HashMap<Character, ItemStack>();

		for(int i=offset; i<recipeComponents.length; i+=2){
			Character character = (Character) recipeComponents[i];
			ItemStack itemstack = null;

			if (recipeComponents[i + 1] instanceof Item) {
				itemstack = new ItemStack((Item) recipeComponents[i + 1]);
			} else if (recipeComponents[i + 1] instanceof Block) {
				itemstack = new ItemStack((Block) recipeComponents[i + 1]);//??????????  , 1, 32767
			} else if (recipeComponents[i + 1] instanceof ItemStack) {
				itemstack = (ItemStack) recipeComponents[i + 1];
			}
			
			if(itemstack!=null){
				map.put(character, itemstack);
			}
		}

		ItemStack[] stackPattern = new ItemStack[pattern.length()];

		for (int i=0; i<stackPattern.length; i++) {
			Character character = Character.valueOf(pattern.charAt(i));

			if (map.containsKey(character)) {
				stackPattern[i] = map.get(character).copy();
			} else {
				stackPattern[i] = null;
			}
		}

		ShapedCarRecipe recipe=new ShapedCarRecipe(stackPattern, builder, name);
		this.recipes.add(recipe);
	}

	public void addRecipe(ICarRecipe recipe) {
		this.recipes.add(recipe);
	}

	@Nullable
	public ICarbuilder findMatchingRecipe(ICarCraftingInventory craftMatrix) {
		for (ICarRecipe irecipe : this.recipes) {
			if (irecipe.matches(craftMatrix)) {
				return irecipe.getCraftingResult();
			}
		}
		return null;
	}

	public List<ICarRecipe> getRecipeList() {
		return this.recipes;
	}
	
	public ICarRecipe getReciepeByName(String name){
		for(ICarRecipe reciepe:recipes){
			if(reciepe.getName().equals(name)){
				return reciepe;
			}
		}
		return null;
	}
}
