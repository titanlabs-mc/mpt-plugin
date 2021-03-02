package dev.titanlabs.mpt.mc.common.extensions;

public interface ExtensionController {

    void load(String name);

    void disable(String name);

    default void reload(String name) {
        this.disable(name);
        this.load(name);
    }
}
