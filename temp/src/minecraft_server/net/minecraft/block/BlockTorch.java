package net.minecraft.block;

import com.google.common.base.Predicate;
import javax.annotation.Nullable;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Blocks;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockTorch extends Block {
   public static final PropertyDirection field_176596_a = PropertyDirection.func_177712_a("facing", new Predicate<EnumFacing>() {
      public boolean apply(@Nullable EnumFacing p_apply_1_) {
         return p_apply_1_ != EnumFacing.DOWN;
      }
   });
   protected static final AxisAlignedBB field_185738_b = new AxisAlignedBB(0.4000000059604645D, 0.0D, 0.4000000059604645D, 0.6000000238418579D, 0.6000000238418579D, 0.6000000238418579D);
   protected static final AxisAlignedBB field_185739_c = new AxisAlignedBB(0.3499999940395355D, 0.20000000298023224D, 0.699999988079071D, 0.6499999761581421D, 0.800000011920929D, 1.0D);
   protected static final AxisAlignedBB field_185740_d = new AxisAlignedBB(0.3499999940395355D, 0.20000000298023224D, 0.0D, 0.6499999761581421D, 0.800000011920929D, 0.30000001192092896D);
   protected static final AxisAlignedBB field_185741_e = new AxisAlignedBB(0.699999988079071D, 0.20000000298023224D, 0.3499999940395355D, 1.0D, 0.800000011920929D, 0.6499999761581421D);
   protected static final AxisAlignedBB field_185742_f = new AxisAlignedBB(0.0D, 0.20000000298023224D, 0.3499999940395355D, 0.30000001192092896D, 0.800000011920929D, 0.6499999761581421D);

   protected BlockTorch() {
      super(Material.field_151594_q);
      this.func_180632_j(this.field_176227_L.func_177621_b().func_177226_a(field_176596_a, EnumFacing.UP));
      this.func_149675_a(true);
      this.func_149647_a(CreativeTabs.field_78031_c);
   }

   public AxisAlignedBB func_185496_a(IBlockState p_185496_1_, IBlockAccess p_185496_2_, BlockPos p_185496_3_) {
      switch((EnumFacing)p_185496_1_.func_177229_b(field_176596_a)) {
      case EAST:
         return field_185742_f;
      case WEST:
         return field_185741_e;
      case SOUTH:
         return field_185740_d;
      case NORTH:
         return field_185739_c;
      default:
         return field_185738_b;
      }
   }

   @Nullable
   public AxisAlignedBB func_180646_a(IBlockState p_180646_1_, IBlockAccess p_180646_2_, BlockPos p_180646_3_) {
      return field_185506_k;
   }

   public boolean func_149662_c(IBlockState p_149662_1_) {
      return false;
   }

   public boolean func_149686_d(IBlockState p_149686_1_) {
      return false;
   }

   private boolean func_176594_d(World p_176594_1_, BlockPos p_176594_2_) {
      Block block = p_176594_1_.func_180495_p(p_176594_2_).func_177230_c();
      boolean flag = block == Blocks.field_185775_db || block == Blocks.field_150428_aP;
      if (p_176594_1_.func_180495_p(p_176594_2_).func_185896_q()) {
         return !flag;
      } else {
         boolean flag1 = block instanceof BlockFence || block == Blocks.field_150359_w || block == Blocks.field_150463_bK || block == Blocks.field_150399_cn;
         return flag1 && !flag;
      }
   }

   public boolean func_176196_c(World p_176196_1_, BlockPos p_176196_2_) {
      for(EnumFacing enumfacing : field_176596_a.func_177700_c()) {
         if (this.func_176595_b(p_176196_1_, p_176196_2_, enumfacing)) {
            return true;
         }
      }

      return false;
   }

   private boolean func_176595_b(World p_176595_1_, BlockPos p_176595_2_, EnumFacing p_176595_3_) {
      BlockPos blockpos = p_176595_2_.func_177972_a(p_176595_3_.func_176734_d());
      IBlockState iblockstate = p_176595_1_.func_180495_p(blockpos);
      Block block = iblockstate.func_177230_c();
      BlockFaceShape blockfaceshape = iblockstate.func_193401_d(p_176595_1_, blockpos, p_176595_3_);
      if (p_176595_3_.equals(EnumFacing.UP) && this.func_176594_d(p_176595_1_, blockpos)) {
         return true;
      } else if (p_176595_3_ != EnumFacing.UP && p_176595_3_ != EnumFacing.DOWN) {
         return !func_193382_c(block) && blockfaceshape == BlockFaceShape.SOLID;
      } else {
         return false;
      }
   }

   public IBlockState func_180642_a(World p_180642_1_, BlockPos p_180642_2_, EnumFacing p_180642_3_, float p_180642_4_, float p_180642_5_, float p_180642_6_, int p_180642_7_, EntityLivingBase p_180642_8_) {
      if (this.func_176595_b(p_180642_1_, p_180642_2_, p_180642_3_)) {
         return this.func_176223_P().func_177226_a(field_176596_a, p_180642_3_);
      } else {
         for(EnumFacing enumfacing : EnumFacing.Plane.HORIZONTAL) {
            if (this.func_176595_b(p_180642_1_, p_180642_2_, enumfacing)) {
               return this.func_176223_P().func_177226_a(field_176596_a, enumfacing);
            }
         }

         return this.func_176223_P();
      }
   }

   public void func_176213_c(World p_176213_1_, BlockPos p_176213_2_, IBlockState p_176213_3_) {
      this.func_176593_f(p_176213_1_, p_176213_2_, p_176213_3_);
   }

   public void func_189540_a(IBlockState p_189540_1_, World p_189540_2_, BlockPos p_189540_3_, Block p_189540_4_, BlockPos p_189540_5_) {
      this.func_176592_e(p_189540_2_, p_189540_3_, p_189540_1_);
   }

   protected boolean func_176592_e(World p_176592_1_, BlockPos p_176592_2_, IBlockState p_176592_3_) {
      if (!this.func_176593_f(p_176592_1_, p_176592_2_, p_176592_3_)) {
         return true;
      } else {
         EnumFacing enumfacing = (EnumFacing)p_176592_3_.func_177229_b(field_176596_a);
         EnumFacing.Axis enumfacing$axis = enumfacing.func_176740_k();
         EnumFacing enumfacing1 = enumfacing.func_176734_d();
         BlockPos blockpos = p_176592_2_.func_177972_a(enumfacing1);
         boolean flag = false;
         if (enumfacing$axis.func_176722_c() && p_176592_1_.func_180495_p(blockpos).func_193401_d(p_176592_1_, blockpos, enumfacing) != BlockFaceShape.SOLID) {
            flag = true;
         } else if (enumfacing$axis.func_176720_b() && !this.func_176594_d(p_176592_1_, blockpos)) {
            flag = true;
         }

         if (flag) {
            this.func_176226_b(p_176592_1_, p_176592_2_, p_176592_3_, 0);
            p_176592_1_.func_175698_g(p_176592_2_);
            return true;
         } else {
            return false;
         }
      }
   }

   protected boolean func_176593_f(World p_176593_1_, BlockPos p_176593_2_, IBlockState p_176593_3_) {
      if (p_176593_3_.func_177230_c() == this && this.func_176595_b(p_176593_1_, p_176593_2_, (EnumFacing)p_176593_3_.func_177229_b(field_176596_a))) {
         return true;
      } else {
         if (p_176593_1_.func_180495_p(p_176593_2_).func_177230_c() == this) {
            this.func_176226_b(p_176593_1_, p_176593_2_, p_176593_3_, 0);
            p_176593_1_.func_175698_g(p_176593_2_);
         }

         return false;
      }
   }

   public IBlockState func_176203_a(int p_176203_1_) {
      IBlockState iblockstate = this.func_176223_P();
      switch(p_176203_1_) {
      case 1:
         iblockstate = iblockstate.func_177226_a(field_176596_a, EnumFacing.EAST);
         break;
      case 2:
         iblockstate = iblockstate.func_177226_a(field_176596_a, EnumFacing.WEST);
         break;
      case 3:
         iblockstate = iblockstate.func_177226_a(field_176596_a, EnumFacing.SOUTH);
         break;
      case 4:
         iblockstate = iblockstate.func_177226_a(field_176596_a, EnumFacing.NORTH);
         break;
      case 5:
      default:
         iblockstate = iblockstate.func_177226_a(field_176596_a, EnumFacing.UP);
      }

      return iblockstate;
   }

   public int func_176201_c(IBlockState p_176201_1_) {
      int i = 0;
      switch((EnumFacing)p_176201_1_.func_177229_b(field_176596_a)) {
      case EAST:
         i = i | 1;
         break;
      case WEST:
         i = i | 2;
         break;
      case SOUTH:
         i = i | 3;
         break;
      case NORTH:
         i = i | 4;
         break;
      case DOWN:
      case UP:
      default:
         i = i | 5;
      }

      return i;
   }

   public IBlockState func_185499_a(IBlockState p_185499_1_, Rotation p_185499_2_) {
      return p_185499_1_.func_177226_a(field_176596_a, p_185499_2_.func_185831_a((EnumFacing)p_185499_1_.func_177229_b(field_176596_a)));
   }

   public IBlockState func_185471_a(IBlockState p_185471_1_, Mirror p_185471_2_) {
      return p_185471_1_.func_185907_a(p_185471_2_.func_185800_a((EnumFacing)p_185471_1_.func_177229_b(field_176596_a)));
   }

   protected BlockStateContainer func_180661_e() {
      return new BlockStateContainer(this, new IProperty[]{field_176596_a});
   }

   public BlockFaceShape func_193383_a(IBlockAccess p_193383_1_, IBlockState p_193383_2_, BlockPos p_193383_3_, EnumFacing p_193383_4_) {
      return BlockFaceShape.UNDEFINED;
   }
}