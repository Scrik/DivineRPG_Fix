package net.divinerpg.items.base;

import java.util.List;

import net.divinerpg.libs.Reference;
import net.divinerpg.utils.LangRegistry;
import net.divinerpg.utils.TooltipLocalizer;
import net.divinerpg.utils.Util;
import net.divinerpg.utils.tabs.DivineRPGTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemHoe;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item.ToolMaterial;
import cpw.mods.fml.common.registry.GameRegistry;

public class ItemModHoe extends ItemHoe {

    protected String name;

    public ItemModHoe(ToolMaterial tool, String name) {
        super(tool);
        setCreativeTab(DivineRPGTabs.tools);
        setTextureName(Reference.PREFIX + name);
        setUnlocalizedName(name);
        GameRegistry.registerItem(this, name);
        LangRegistry.addItem(this);
    }

    @Override
    public void addInformation(ItemStack item, EntityPlayer player, List infoList, boolean par4) {
        if(item.getMaxItemUseDuration() != -1) infoList.add(TooltipLocalizer.usesRemaining(item.getMaxItemUseDuration() - item.getItemDamage()));
        else infoList.add(TooltipLocalizer.infiniteUses());
    }
}
