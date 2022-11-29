package coffee.amo.veil;

import dev.kosmx.playerAnim.api.layered.IAnimation;
import dev.kosmx.playerAnim.api.layered.ModifierLayer;
import dev.kosmx.playerAnim.api.layered.modifier.SpeedModifier;
import dev.kosmx.playerAnim.minecraftApi.PlayerAnimationFactory;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.ai.attributes.Attributes;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Veil {
    public static final String MOD_ID = "veil";
    public static final Logger LOGGER = LogManager.getLogger();

    public static void init() {
        PlayerAnimationFactory.ANIMATION_DATA_FACTORY.registerFactory(new ResourceLocation(MOD_ID, "walk"), 42, (player) -> {
            if(player instanceof LocalPlayer){
                ModifierLayer<IAnimation> walkAnim = new ModifierLayer<>();
                walkAnim.addModifierBefore(new SpeedModifier((float) player.getAttribute(Attributes.MOVEMENT_SPEED).getValue()));
                return walkAnim;
            }
            return null;
        });
    }
}