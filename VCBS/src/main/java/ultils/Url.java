package ultils;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

public class Url {

    private static final String JSON_FILE = System.getProperty("user.dir").concat("/src/main/java/resources/testing-urls.json");

    public static String currentTestUrl(String testPage) {
        ObjectMapper objectMapper = new ObjectMapper();
        String finalTestingUrl;

        try {
            FileInputStream fileInputStream = new FileInputStream(JSON_FILE);
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, StandardCharsets.UTF_8);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

            Map<String, HashMap> testingUrlData = objectMapper.readValue(bufferedReader, HashMap.class);
//            String sitePath = testingUrlData.get(testPage).get("url").toString();
//            finalTestingUrl = System.getenv("testingUrl").concat(sitePath);
            finalTestingUrl = testingUrlData.get(testPage).get("url").toString();

            // Close after interacting with the file
            bufferedReader.close();
            inputStreamReader.close();
            bufferedReader.close();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("ERR | issue when reading the testing url data json file!");
        }

        return finalTestingUrl;
    }

}
