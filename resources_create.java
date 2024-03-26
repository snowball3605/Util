package snow.main.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.annotations.JsonAdapter;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class resources_create {
    public static boolean write_and_create(String path, JSONObject json_content) {
        try {
            JSONArray jsonArray = read(path);
            Path path1 = Paths.get(path);

            if (path1.toFile().exists()) {
                jsonArray.put(json_content);

                try (BufferedWriter fileWriter = new BufferedWriter(new FileWriter(path))){
                    fileWriter.write(jsonArray.toString());
                    return true;
                }
            }
            Files.createFile(path1);
            try (FileWriter file_writer = new FileWriter(path1.toFile())) {
                file_writer.write(json_content.toString());
                return true;
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static JSONArray read(String Path) {
        File file = new File(Path);

        if (!file.exists()) {
            return new JSONArray();
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(file))){
            StringBuilder content = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line);
            }
            if (!content.toString().trim().startsWith("[")) {
                content.insert(0, "[");
                content.append("]");
            }

            return new JSONArray(content.toString());

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static int count(String path) {

        JSONArray jsonArray = new JSONArray(read(path));
        return jsonArray.length();
    }

    public static String json_all(String path, String Key) throws IOException {
        String fileContent = new String(Files.readAllBytes(Paths.get(path)));

        JSONArray jsonArray = new JSONArray(fileContent);
        JSONObject desiredObject = null;

        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject jsonObject = jsonArray.getJSONObject(i);
            if (jsonObject.has(Key)) {
                Object value = jsonObject.get(Key);
                if (value instanceof JSONObject) {
                    desiredObject = (JSONObject) value;
                } else if (value instanceof String) {
                    // Handle if value is a string
                    return value.toString();
                }
                break;
            }
        }

        if (desiredObject != null) {
            return desiredObject.toString();
        } else {
            return "ERROR";
        }
    }

    public static void main(String[] args) throws IOException {
        System.out.println(json_all(Get_Config.Yaml("config.yml", "backup_path", false) + "11.json", "20242603153950"));
    }
}
