package com.unit.test.command;

import android.support.test.uiautomator.UiDevice;

/**
 * Created by zhenwei on 2017/6/22.
 */

public class PressHomeCom implements ICommand {
    @Override
    public void execute(UiDevice uiDevice) {
        uiDevice.pressHome();
    }
}
