package com.appium.driver;

import com.appium.helper.Config;
import com.appium.helper.Project;

import java.util.concurrent.TimeUnit;

public class Emulator {
    private static Emulator instance = null;
    private Process adb, emulator;

    private Emulator() {
    }

    // static method to create instance of Singleton class
    public static Emulator getInstance() {
        if (instance == null)
            instance = new Emulator();

        return instance;
    }

    public void startEmulatorDevice() throws Exception {
        stopEmulatorDevice();

        String emulator_path = Project.ROOT + "/src/test/resources/device";
        String android_home = Config.Instance().getAndroidHome();

        adb = Runtime.getRuntime().exec(emulator_path + "/start-adb-server " + android_home + "/platform-tools");
        adb.waitFor(20, TimeUnit.SECONDS);

        emulator = Runtime.getRuntime().exec(emulator_path + "/start-emulator " + android_home + "/tools " + Config.Instance().getDeviceName());
        emulator.waitFor(50, TimeUnit.SECONDS);
    }

    public void stopEmulatorDevice() throws Exception {
        String emulator_path = Project.ROOT + "/src/test/resources/device";

        emulator = Runtime.getRuntime().exec(emulator_path + "/stop-emulator");
        emulator.waitFor(50, TimeUnit.SECONDS);

        adb = Runtime.getRuntime().exec(emulator_path + "/stop-adb-server");
        adb.waitFor(20, TimeUnit.SECONDS);
    }
}
