package com.epsontest; // replace com.your-app-name with your app’s name

import com.epson.epos2.Epos2Exception;
import com.epson.epos2.printer.Printer;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.Callback;
import java.util.Map;
import java.util.HashMap;
import android.util.Log;

public class CalendarModule extends ReactContextBaseJavaModule {
    Printer printer = null;

    CalendarModule(ReactApplicationContext context) {
        super(context);
    }

    @Override
    public String getName() {
        return "CalendarModule";
    }

    @ReactMethod
    public void initializePrinter(Callback callback) {
        try {
            printer = new Printer(Printer.TM_T88, Printer.MODEL_ANK, getReactApplicationContext());
        } catch (Epos2Exception e) {
            // Displays error messages
            callback.invoke("init failed");
        }
        printer.setReceiveEventListener(this);
        callback.invoke("init success");
    }

    @ReactMethod
    public void createCalendarEvent(String name, String location, Callback callback) {
        Log.d("CalendarModule", "Create event called with name: " + name + " and location: " + location);
        callback.invoke("callback passed this arguments" + name + " " + location);
    }
}