package twilightforest.block;

import java.util.Random;

import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.block.BlockLog;
import net.minecraft.item.Item;
import twilightforest.item.TFItems;

public class BlockTFCinderLog extends BlockLog {

	protected BlockTFCinderLog() {
		this.setHardness(1.0F);
		this.setCreativeTab(TFItems.creativeTab);
		this.setDefaultState(blockState.getBaseState().withProperty(LOG_AXIS, EnumAxis.Y));
	}

	@Override
	public BlockStateContainer createBlockState() {
		return new BlockStateContainer(this, LOG_AXIS);
	}

	@Override
	public int getMetaFromState(IBlockState state) {
		switch (state.getValue(LOG_AXIS)) {
			case X: return 4;
			case Y: return 0;
			case Z: return 8;
			case NONE:
			default: return 12;
		}
	}

	@Override
	public IBlockState getStateFromMeta(int meta) {
		switch (meta) {
			case 0: return getDefaultState().withProperty(LOG_AXIS, EnumAxis.Y);
			case 4: return getDefaultState().withProperty(LOG_AXIS, EnumAxis.X);
			case 8: return getDefaultState().withProperty(LOG_AXIS, EnumAxis.Z);
			case 12:
			default: return getDefaultState().withProperty(LOG_AXIS, EnumAxis.NONE);
		}
	}

    @Override
	public Item getItemDropped(IBlockState state, Random par2Random, int par3)
    {
        return Item.getItemFromBlock(TFBlocks.cinderLog); // hey that's my block ID!
    }


}
