package coffee.amo.veil.forge;

import coffee.amo.veil.Veil;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(Veil.MOD_ID)
public class VeilForge {
    public VeilForge() {
        Veil.init();
    }
}