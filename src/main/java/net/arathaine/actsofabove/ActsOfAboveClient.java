package net.arathaine.actsofabove;

import net.arathaine.actsofabove.init.AOAItems;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.model.ModelLoadingRegistry;
import net.minecraft.client.util.ModelIdentifier;

public class ActsOfAboveClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {

        ModelLoadingRegistry
                .INSTANCE.registerModelProvider((resources, out) -> out
                        .accept(new ModelIdentifier("actsofabove", "the_watcher_gui", "inventory")));

        //MialeeMiscClient.registerInventoryItem(AOAItems.THE_WATCHER);
    }
}