package de.petrofsky.nuclearsciencefix;

import com.mojang.logging.LogUtils;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import org.slf4j.Logger;

@Mod(NuclearScienceFix.MODID)
public class NuclearScienceFix {

    public static final String MODID = "nuclearsciencefix";
    private static final Logger LOGGER = LogUtils.getLogger();

    public NuclearScienceFix(IEventBus modEventBus, ModContainer modContainer) {
        LOGGER.info("Loading mod");
    }
}