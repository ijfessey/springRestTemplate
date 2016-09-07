import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by ian.fessey on 23/06/2016.
 */
public class JsonUnMarshallString {


    public static void main(String[] args) {

        String jsonStr = "[{\"No\":\"1\",\"Name\":\"ABC\"},{\"No\":\"2\",\"Name\":\"PQR\"},{\"No\":\"3\",\"Name\":\"XYZ\"}]";

        JSONArray array = new JSONArray(jsonStr);

        for(int i=0; i<array.length(); i++){
            JSONObject jsonObj  = array.getJSONObject(i);
            System.out.println(jsonObj.getString("No"));
            System.out.println(jsonObj.getString("Name"));
        }


// {"sku":"ZZZ","review_count":2,"average_score":"10.0"}

//        JSONArray jsonArray = new JSONArray();
//        final String mobile = "mobile";
//        final String desktop = "desktop";
//        final String isFull360 = "isfull360";
//        try {
//            if (exterior360ComponentBean.getMobileExteriorImages().getImagePaths() != null) {
//                jsonObject.put(mobile, exterior360ComponentBean.getMobileExteriorImages().getImagePaths());
//            } else {
//                jsonObject.put(mobile, jsonArray);
//            }
//
//            if (exterior360ComponentBean.getDesktopExteriorImages().getImagePaths() != null) {
//                jsonObject.put(desktop, exterior360ComponentBean.getDesktopExteriorImages().getImagePaths());
//            } else {
//                jsonObject.put(desktop, jsonArray);
//            }
//
//            jsonObject.put(isFull360, exterior360ComponentBean.isFull360());
//        } catch (JSONException e) {
//            LOGGER.error("Exception in Json representation of Exterior 360 Component", e);
//        }
//        exterior360ComponentBean.setJsonRepresentation(jsonObject.toString());

    }
}
