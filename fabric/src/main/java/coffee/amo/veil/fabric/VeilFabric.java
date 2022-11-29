package coffee.amo.veil.fabric;

import coffee.amo.veil.Veil;
import net.fabricmc.api.ModInitializer;

public class VeilFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        Veil.init();
    }
}