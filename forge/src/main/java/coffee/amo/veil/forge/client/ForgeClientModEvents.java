package coffee.amo.veil.forge.client;

import coffee.amo.veil.Veil;
import coffee.amo.veil.VeilClient;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, modid = Veil.MOD_ID, value = Dist.CLIENT)
public class ForgeClientModEvents {

    @SubscribeEvent
    public static void onClientSetup(FMLClientSetupEvent event){
        VeilClient.init();
    }
}
