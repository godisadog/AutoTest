package com.unit.test.command;

import android.support.test.uiautomator.UiDevice;

import java.util.concurrent.TimeUnit;

/**
 * Created by zhenwei on 2017/6/22.
 */

public class WaitCom implements ICommand {
    private long milliseconds;
    public WaitCom(long time, TimeUnit unit){
        milliseconds = unit.toMillis(time);
    }

    @Override
    public void execute(UiDevice uiDevice) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
