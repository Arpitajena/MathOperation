package cordova.plugin.mathcalculator;

import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CallbackContext;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * This class echoes a string called from JavaScript.
 */
public class MathCalculator extends CordovaPlugin {

    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        if (action.equals("add")) {
           
            this.add(args, callbackContext);
            return true;
        }else if (action.equals("sub")) {
          this.sub(args, callbackContext);
          return true;

        }
        return false;
    }

    private void add(JSONArray args, CallbackContext callback) {
        if (args != null) {
            try {
                 int a = Integer.parseInt(args.getJSONObject(0).getString("param1"));
                int b = Integer.parseInt(args.getJSONObject(0).getString("param2"));
                callback.success("" + (a + b));
            } catch (Exception ex) {
                callback.error("Something went wrong" + ex);
            }
        } else {
            callback.error("Please don't pass null value");
        }
    }

      private void sub(JSONArray args, CallbackContext callback) {
        if (args != null) {
            try {
                 int a = Integer.parseInt(args.getJSONObject(0).getString("param1"));
                int b = Integer.parseInt(args.getJSONObject(0).getString("param2"));
                callback.success("" + (a -b));
            } catch (Exception ex) {
                callback.error("Something went wrong" + ex);
            }
        } else {
            callback.error("Please don't pass null value");
        }
    }
}
