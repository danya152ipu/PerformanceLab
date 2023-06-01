import java.io.*;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ContainerFactory;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Main2 {
    public static void main(String[] args) {
        JSONParser jsonParser = new JSONParser();
        try (FileReader reader = new FileReader(args[0]))
        {
            Object obj = jsonParser.parse(reader);
            JSONObject tests = (JSONObject) obj;
            JSONArray testsArray = (JSONArray) tests.get("tests");
            JSONParser parser = new JSONParser();
            try (FileReader reader2 = new FileReader(args[1]))
            {
                Object obj2 = parser.parse(reader2);
                JSONObject values = (JSONObject) obj2;
                JSONArray valuesArray = (JSONArray) values.get("values");
                add_values_to_tests(testsArray, valuesArray);
                try (FileWriter file = new FileWriter("report.json")) {
                    file.write(testsArray.toJSONString());
                    file.flush();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } catch (IOException | ParseException e) {
                e.printStackTrace();
            }

        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
    }
    public static void add_values_to_tests (JSONArray testsArray, JSONArray valuesArray) {
        for (int i=0; i<testsArray.size(); i++) {
            JSONObject obj_from_tests = (JSONObject) testsArray.get(i);
            for (int j = 0; j < valuesArray.size(); j++) {
                JSONObject obj_from_values = (JSONObject) valuesArray.get(j);
                if (obj_from_tests.get("id").equals(obj_from_values.get("id"))) {
                    obj_from_tests.put("value", obj_from_values.get("value"));
                    break;
                }
            }
            if (obj_from_tests.get("values")!= null) {
                JSONArray values_arr_from_obj_tests = (JSONArray) obj_from_tests.get("values");
                add_values_to_tests(values_arr_from_obj_tests, valuesArray);
                obj_from_tests.put("values", values_arr_from_obj_tests);
            }
            testsArray.set(i, obj_from_tests);
        }
    }
}
