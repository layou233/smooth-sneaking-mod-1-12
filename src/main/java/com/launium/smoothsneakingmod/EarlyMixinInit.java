package com.launium.smoothsneakingmod;

import net.minecraftforge.common.ForgeVersion;
import net.minecraftforge.fml.relauncher.FMLLaunchHandler;
import net.minecraftforge.fml.relauncher.IFMLLoadingPlugin;
import net.minecraftforge.fml.relauncher.Side;
import zone.rong.mixinbooter.IEarlyMixinLoader;

import java.util.Collections;
import java.util.List;
import java.util.Map;

@IFMLLoadingPlugin.Name("SmoothSneakingMod")
@IFMLLoadingPlugin.MCVersion(ForgeVersion.mcVersion)
public class EarlyMixinInit implements IFMLLoadingPlugin, IEarlyMixinLoader {

    public static final boolean isClient = FMLLaunchHandler.side() == Side.CLIENT;

    @Override
    public List<String> getMixinConfigs() {
        return Collections.singletonList("mixins.smoothsneakingmod.json");
    }

    @Override
    public String[] getASMTransformerClass() {
        return null;
    }

    @Override
    public String getModContainerClass() {
        return null;
    }

    @Override
    public String getSetupClass() {
        return null;
    }

    @Override
    public void injectData(Map<String, Object> data) {
    }

    @Override
    public String getAccessTransformerClass() {
        return null;
    }

}
