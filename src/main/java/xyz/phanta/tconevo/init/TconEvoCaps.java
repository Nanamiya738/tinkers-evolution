package xyz.phanta.tconevo.init;

import io.github.phantamanta44.libnine.InitMe;
import io.github.phantamanta44.libnine.capability.StatelessCapabilitySerializer;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.CapabilityManager;
import xyz.phanta.tconevo.capability.AstralAttunable;
import xyz.phanta.tconevo.capability.EnergyShield;

@SuppressWarnings("NotNullFieldNotInitialized")
public class TconEvoCaps {

    @CapabilityInject(EnergyShield.class)
    public static Capability<EnergyShield> ENERGY_SHIELD;
    @CapabilityInject(AstralAttunable.class)
    public static Capability<AstralAttunable> ASTRAL_ATTUNABLE;

    @InitMe
    public static void init() {
        CapabilityManager.INSTANCE.register(EnergyShield.class, new StatelessCapabilitySerializer<>(), EnergyShield.Noop::new);
        CapabilityManager.INSTANCE.register(AstralAttunable.class, new StatelessCapabilitySerializer<>(), AstralAttunable.Noop::new);
    }

}
