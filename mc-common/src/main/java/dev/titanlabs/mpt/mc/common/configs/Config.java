package dev.titanlabs.mpt.mc.common.configs;

import org.yaml.snakeyaml.DumperOptions;
import org.yaml.snakeyaml.LoaderOptions;
import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.SafeConstructor;
import org.yaml.snakeyaml.representer.Representer;
import sun.misc.IOUtils;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.HashMap;
import java.util.Map;
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
        this.yaml = this.createYaml();
        this.load();
    }

    public static Config create(String name, UnaryOperator<Path> path) {
        try {
            return new Config(name, path.apply(null).resolve(name).toFile());
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public Object get(String key) {
        return this.map.get(key);
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

    private Yaml createYaml() {
        return new Yaml(new SafeConstructor(), new Representer(), new DumperOptions(), new LoaderOptions());
    }

    private InputStream getResource() {
        return this.getClass().getClassLoader().getResourceAsStream(this.name);
    }

    private void saveResource() {
        InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream(this.name);
        if (inputStream == null) {
            // TODO: log
        } else {
            try {
                // TODO write parent directories, if necessary
                Files.write(this.file.toPath(), IOUtils.readAllBytes(inputStream), StandardOpenOption.CREATE);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
