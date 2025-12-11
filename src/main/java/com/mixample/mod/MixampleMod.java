package com.mixample.mod;

import net.minecraftforge.fml.common.Mod;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod("mixample")
public class MixampleMod {

    public static final String MOD_ID = "mixample";
    public static final Logger LOGGER = LogManager.getLogger(MOD_ID);

    public MixampleMod() {
        LOGGER.info("Potfix (Cataclysm Patch) loaded!");
    }
}
