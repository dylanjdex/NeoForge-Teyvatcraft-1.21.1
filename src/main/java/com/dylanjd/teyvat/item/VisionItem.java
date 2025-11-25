package com.dylanjd.teyvat.item;

import com.dylanjd.teyvat.screen.custom.VisionMenu;
import com.dylanjd.teyvat.util.ParticleCircle;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.InventoryMenu;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;

public class VisionItem extends Item {
    public VisionItem(Properties properties) {
        super(properties);
    }

    @Override
    public @NotNull InteractionResultHolder<ItemStack> use(Level level, @NotNull Player player, InteractionHand usedHand) {
        if (!level.isClientSide && level instanceof ServerLevel) {
            ((ServerLevel) level).sendParticles(ParticleTypes.SMALL_GUST, player.getX(), player.getY() + 1, player.getZ(), 1, 0f, 0f, 0f, 0);
            ParticleCircle.serverParticleCircle((ServerLevel) level, player, ParticleTypes.SMALL_GUST, 3, 20);
        }
        return super.use(level, player, usedHand);
    }
}
