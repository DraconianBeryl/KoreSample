package com.scottkillen.mod.koresample;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLInterModComms;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = TheMod.MOD_ID, name = TheMod.MOD_NAME, version = TheMod.MOD_VERSION, useMetadata = true)
public class TheMod
{
    public static final String MOD_ID = "koresample";
    public static final String MOD_NAME = "Kore Sample";
    public static final String MOD_VERSION = "${mod_version}";
    private static final String RESOURCE_PREFIX = MOD_ID.toLowerCase() + ':';
    private static final String VERSIONCHECK_URL =
            "https://raw.githubusercontent.com/ScottKillen/glowing-ninja/master/KoreSample.json";

    public static String resourcePrefix() { return RESOURCE_PREFIX; }

    @EventHandler
    public void onFMLPreInitialization(FMLPreInitializationEvent event)
    {
        FMLInterModComms.sendRuntimeMessage(MOD_ID, "VersionChecker", "addVersionCheck", VERSIONCHECK_URL);
    }

    @EventHandler
    public void onFMLInitialization(FMLInitializationEvent event) { }

    @EventHandler
    public void onFMLPostInitialization(FMLPostInitializationEvent event) { }
}
