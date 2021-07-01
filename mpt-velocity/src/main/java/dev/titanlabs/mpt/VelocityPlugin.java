package dev.titanlabs.mpt;

import com.google.inject.Inject;
import com.velocitypowered.api.event.proxy.ProxyInitializeEvent;
import com.velocitypowered.api.event.Subscribe;
import com.velocitypowered.api.plugin.Plugin;
import org.slf4j.Logger;

@Plugin(
        id = "mpt-velocity",
        name = "MPT",
        version = "@version@",
        description = "change me :)",
        authors = {"Zak", "Hyfe"}
)
public class VelocityPlugin {

    @Inject
    private Logger logger;

    @Subscribe
    public void onProxyInitialization(ProxyInitializeEvent event) {
    }
}
