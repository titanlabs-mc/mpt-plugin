package dev.titanlabs.mpt.mc.common.configs;

import dev.titanlabs.mpt.mc.common.MptPlatform;
import org.yaml.snakeyaml.Yaml;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;

public class Config {
    private final String name;
    private final File file;
    private final Yaml yaml;
    private final Map<String, Object> map = new HashMap<>();

    public Config(String name, File file) throws IOException {
        this.name = name;
        this.file = file;
        this.yaml = new Yaml();
        this.saveResource();
        this.load();
    }

    public static Config create(MptPlatform platform, String name, UnaryOperator<Path> path) {
        try {
            return new Config(name, path.apply(platform.getDataFolder()).resolve(name).toFile());
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public String getName() {
        return this.name;
    }

    public Object get(String key) {
        return this.map.get(key);
    }

    public CompletableFuture<Void> reload(MptPlatform platform) {
        return platform.scheduler().runAsync(() -> {
            try {
                this.load();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }).exceptionally((ex) -> {
            ex.printStackTrace();
            return null;
        });
    }

    private void load() throws IOException {
        FileInputStream inputStream = new FileInputStream(this.file);
        InputStreamReader streamReader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
        BufferedReader bufferedReader = new BufferedReader(streamReader);
        String content = this.concatContent(bufferedReader);
        Map<?, ?> input = this.yaml.load(content);
        this.writeContentToMemory(input);
    }

    private String concatContent(BufferedReader reader) throws IOException {
        try {
            return reader.lines().map((line) -> line.concat("\n")).collect(Collectors.joining());
        } finally {
            reader.close();
        }
    }

    private void writeContentToMemory(Map<?, ?> input) {
        this.map.clear();
        for (Map.Entry<?, ?> entry : input.entrySet()) {
            String key = entry.getKey().toString();
            Object value = entry.getValue();
            this.map.put(key, value);
        }
    }

    private void saveResource() {
        InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream(this.name);
        if (inputStream == null) {
            // TODO: log
        } else {
            try {
                byte[] bytes = new byte[inputStream.available()];
                inputStream.read(bytes);
                Files.write(this.file.toPath(), bytes, StandardOpenOption.CREATE);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
