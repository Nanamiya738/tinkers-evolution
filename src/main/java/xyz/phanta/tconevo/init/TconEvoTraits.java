package xyz.phanta.tconevo.init;

import com.google.common.collect.Sets;
import net.minecraft.item.ItemStack;
import slimeknights.tconstruct.library.modifiers.Modifier;
import slimeknights.tconstruct.library.traits.AbstractTrait;
import xyz.phanta.tconevo.TconEvoConfig;
import xyz.phanta.tconevo.integration.actuallyadditions.ActuallyHooks;
import xyz.phanta.tconevo.integration.astralsorcery.AstralConstellation;
import xyz.phanta.tconevo.integration.draconicevolution.DraconicHooks;
import xyz.phanta.tconevo.integration.mekanism.MekanismHooks;
import xyz.phanta.tconevo.integration.thermal.ThermalHooks;
import xyz.phanta.tconevo.trait.*;
import xyz.phanta.tconevo.trait.astralsorcery.ModifierAttuned;
import xyz.phanta.tconevo.trait.astralsorcery.TraitAstral;
import xyz.phanta.tconevo.trait.bloodmagic.TraitBloodbound;
import xyz.phanta.tconevo.trait.bloodmagic.TraitCrystalys;
import xyz.phanta.tconevo.trait.bloodmagic.TraitSentient;
import xyz.phanta.tconevo.trait.bloodmagic.TraitWillful;
import xyz.phanta.tconevo.trait.botania.TraitAuraSiphon;
import xyz.phanta.tconevo.trait.botania.TraitFaeVoice;
import xyz.phanta.tconevo.trait.botania.TraitGaiaWrath;
import xyz.phanta.tconevo.trait.botania.TraitManaInfused;
import xyz.phanta.tconevo.trait.draconicevolution.*;
import xyz.phanta.tconevo.trait.industrialforegoing.TraitSlimeyPink;
import xyz.phanta.tconevo.trait.projecte.TraitEternalDensity;
import xyz.phanta.tconevo.trait.thaumcraft.TraitWarping;

import java.util.*;
import java.util.function.Supplier;

public class TconEvoTraits {

    private static final Set<String> blacklisted = Sets.newHashSet(TconEvoConfig.disabledModifiers);

    public static boolean isModifierEnabled(Modifier mod) {
        return !blacklisted.contains(
                mod instanceof AbstractTrait ? ((AbstractTrait)mod).getModifierIdentifier() : mod.identifier);
    }

    public static final TraitAftershock[] TRAIT_AFTERSHOCK = {
            new TraitAftershock(1), new TraitAftershock(2), new TraitAftershock(3)
    };
    public static final TraitBattleFuror TRAIT_BATTLE_FUROR = new TraitBattleFuror();
    public static final TraitBlasting TRAIT_BLASTING = new TraitBlasting();
    public static final TraitCascading TRAIT_CASCADING = new TraitCascading();
    public static final TraitChainLightning TRAIT_CHAIN_LIGHTNING = new TraitChainLightning();
    public static final TraitCorrupting TRAIT_CORRUPTING = new TraitCorrupting();
    public static final TraitCrystalline TRAIT_CRYSTALLINE = new TraitCrystalline();
    public static final TraitCulling TRAIT_CULLING = new TraitCulling();
    public static final TraitDeadlyPrecision TRAIT_DEADLY_PRECISION = new TraitDeadlyPrecision();
    public static final TraitExecutor TRAIT_EXECUTOR = new TraitExecutor();
    public static final TraitFootFleet TRAIT_FOOT_FLEET = new TraitFootFleet();
    public static final TraitImpactForce TRAIT_IMPACT_FORCE = new TraitImpactForce();
    public static final TraitJuggernaut TRAIT_JUGGERNAUT = new TraitJuggernaut();
    public static final TraitLuminiferous TRAIT_LUMINIFEROUS = new TraitLuminiferous();
    public static final TraitMortalWounds TRAIT_MORTAL_WOUNDS = new TraitMortalWounds();
    public static final TraitOpportunist TRAIT_OPPORTUNIST = new TraitOpportunist();
    public static final TraitOverwhelm TRAIT_OVERWHELM = new TraitOverwhelm();
    public static final TraitPiezoelectric TRAIT_PIEZOELECTRIC = new TraitPiezoelectric();
    public static final TraitRejuvenating TRAIT_REJUVENATING = new TraitRejuvenating();
    public static final TraitRelentless TRAIT_RELENTLESS = new TraitRelentless();
    public static final TraitRuination TRAIT_RUINATION = new TraitRuination();
    public static final TraitSundering TRAIT_SUNDERING = new TraitSundering();
    public static final TraitStaggering TRAIT_STAGGERING = new TraitStaggering();
    public static final TraitVampiric TRAIT_VAMPIRIC = new TraitVampiric();
    public static final ModifierFluxed MOD_FLUXED = new ModifierFluxed();

    // astral sorcery
    public static final TraitAstral TRAIT_ASTRAL = new TraitAstral();
    public static final Map<AstralConstellation, ModifierAttuned> MOD_ATTUNED = new EnumMap<>(AstralConstellation.class);

    static {
        for (ModifierAttuned mod : Arrays.asList(
                new ModifierAttuned.Aevitas(), new ModifierAttuned.Armara(), new ModifierAttuned.Discidia(),
                new ModifierAttuned.Evorsio(), new ModifierAttuned.Vicio(), new ModifierAttuned.Bootes(),
                new ModifierAttuned.Fornax(), new ModifierAttuned.Horologium(), new ModifierAttuned.Lucerna(),
                new ModifierAttuned.Mineralis(), new ModifierAttuned.Octans(), new ModifierAttuned.Pelotrio())) {
            MOD_ATTUNED.put(mod.getConstellation(), mod);
        }
    }

    // blood magic
    public static final TraitCrystalys TRAIT_CRYSTALYS = new TraitCrystalys();
    public static final TraitBloodbound TRAIT_BLOODBOUND = new TraitBloodbound();
    public static final TraitSentient TRAIT_SENTIENT = new TraitSentient();
    public static final TraitWillful TRAIT_WILLFUL = new TraitWillful();

    // botania
    public static final TraitManaInfused TRAIT_MANA_INFUSED = new TraitManaInfused();
    public static final TraitAuraSiphon TRAIT_AURA_SIPHON = new TraitAuraSiphon();
    public static final TraitFaeVoice TRAIT_FAE_VOICE = new TraitFaeVoice();
    public static final TraitGaiaWrath TRAIT_GAIA_WRATH = new TraitGaiaWrath();

    // draconic evolution
    public static final TraitSoulRend[] TRAIT_SOUL_REND = {
            new TraitSoulRend(1), new TraitSoulRend(2), new TraitSoulRend(3)
    };
    public static final TraitEvolved TRAIT_EVOLVED = new TraitEvolved();
    public static final ModifierDraconic MOD_DRACONIC_ENERGY = new ModifierDraconicEnergy();
    public static final ModifierDraconic MOD_DRACONIC_DIG_SPEED = new ModifierDraconicDigSpeed();
    public static final ModifierDraconic MOD_DRACONIC_DIG_AOE = new ModifierDraconicDigAoe();
    public static final ModifierDraconic MOD_DRACONIC_ATTACK_DAMAGE = new ModifierDraconicAttackDamage();
    public static final ModifierDraconic MOD_DRACONIC_ATTACK_AOE = new ModifierDraconicAttackAoe();
    public static final ModifierDraconic MOD_DRACONIC_ARROW_DAMAGE = new ModifierDraconicArrowDamage();
    public static final ModifierDraconic MOD_DRACONIC_DRAW_SPEED = new ModifierDraconicDrawSpeed();
    public static final ModifierDraconic MOD_DRACONIC_ARROW_SPEED = new ModifierDraconicArrowSpeed();
    public static final ModifierReaping MOD_REAPING = new ModifierReaping();
    public static final ModifierEntropic MOD_ENTROPIC = new ModifierEntropic();
    public static final ModifierFluxBurn MOD_FLUX_BURN = new ModifierFluxBurn();
    public static final ModifierPrimordial MOD_PRIMORDIAL = new ModifierPrimordial();

    // industrial foregoing
    public static final TraitSlimeyPink TRAIT_SLIMEY_PINK = new TraitSlimeyPink();

    // project: e
    public static final TraitEternalDensity[] TRAIT_ETERNAL_DENSITY = {
            new TraitEternalDensity(1), new TraitEternalDensity(2)
    };

    // thaumcraft
    public static final TraitWarping TRAIT_WARPING = new TraitWarping();

    public static final List<Modifier> MODIFIERS = Arrays.asList(
            MOD_FLUXED,
            MOD_REAPING, MOD_ENTROPIC, MOD_FLUX_BURN, MOD_PRIMORDIAL);

    public static void initModifierMaterials() {
        // actually additions
        addModItemOpt(MOD_FLUXED, ActuallyHooks.INSTANCE::getItemBatterySingle);
        addModItemOpt(MOD_FLUXED, ActuallyHooks.INSTANCE::getItemBatteryDouble);
        addModItemOpt(MOD_FLUXED, ActuallyHooks.INSTANCE::getItemBatteryTriple);
        addModItemOpt(MOD_FLUXED, ActuallyHooks.INSTANCE::getItemBatteryQuadra);
        addModItemOpt(MOD_FLUXED, ActuallyHooks.INSTANCE::getItemBatteryPenta);

        // draconic evolution
        addModItemOpt(MOD_REAPING, DraconicHooks.INSTANCE::getItemEnderEnergyManipulator);
        addModItemOpt(MOD_ENTROPIC, DraconicHooks.INSTANCE::getItemDraconicEnergyCore);
        addModItemOpt(MOD_FLUX_BURN, DraconicHooks.INSTANCE::getItemWyvernEnergyCore);
        addModItemOpt(MOD_PRIMORDIAL, DraconicHooks.INSTANCE::getItemChaosShard);
        addModItemOpt(MOD_FLUXED, DraconicHooks.INSTANCE::getItemWyvernCapacitor);
        addModItemOpt(MOD_FLUXED, DraconicHooks.INSTANCE::getItemDraconicCapacitor);

        // mekanism
        addModItemOpt(MOD_FLUXED, MekanismHooks.INSTANCE::getItemEnergyTablet);

        // thermal series
        for (int i = 0; i < 5; i++) { // basic, hardened, redstone, signalum, resonant
            final int tier = i; // closure bindings!
            addModItemOpt(MOD_FLUXED, () -> ThermalHooks.INSTANCE.getItemFluxCapacitor(tier));
        }
    }

    private static void addModItemOpt(Modifier mod, Supplier<Optional<ItemStack>> materialGetter) {
        if (isModifierEnabled(mod)) {
            materialGetter.get().ifPresent(s -> mod.addItem(s, 1, 1));
        }
    }

}
