package dev.titanlabs.mpt.mc.common.configs;

import org.yaml.snakeyaml.DumperOptions;
import org.yaml.snakeyaml.LoaderOptions;
import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.SafeConstructor;
import org.yaml.snakeyaml.representer.Representer;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
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

    // taken from bukkit
    private InputStream getResource() throws IOException {
        /*URL url = getClassLoader().getResource(this.name);
        if (url == null) {
            return null;
        }
        URLConnection connection = url.openConnection();
        connection.setUseCaches(false);
        return connection.getInputStream();*/
        return null;
    }

    // taken from bukkit
    private void saveResource() {
        /*InputStream in = getResource(resourcePath);
        if (in == null) {
            throw new IllegalArgumentException("The embedded resource '" + resourcePath + "' cannot be found in " + file);
        }

        File outFile = new File(dataFolder, resourcePath);
        int lastIndex = resourcePath.lastIndexOf('/');
        File outDir = new File(dataFolder, resourcePath.substring(0, lastIndex >= 0 ? lastIndex : 0));

        if (!outDir.exists()) {
            outDir.mkdirs();
        }

        try {
            if (!outFile.exists() || replace) {
                OutputStream out = new FileOutputStream(outFile);
                byte[] buf = new byte[1024];
                int len;
                while ((len = in.read(buf)) > 0) {
                    out.write(buf, 0, len);
                }
                out.close();
                in.close();
            } else {
                logger.log(Level.WARNING, "Could not save " + outFile.getName() + " to " + outFile + " because " + outFile.getName() + " already exists.");
            }
        } catch (IOException ex) {
            logger.log(Level.SEVERE, "Could not save " + outFile.getName() + " to " + outFile, ex);
        }*/
    }
}
