package com.unit.test.command;

import android.support.test.uiautomator.UiDevice;

import java.util.Random;

/**
 * Created by zhenwei on 2017/6/22.
 */

public class ClickCom implements ICommand {

    private int clickCount;

    public ClickCom(int clickCount){
        this.clickCount = clickCount;
    }
    /**
     *
     * @param uiDevice
     */
    @Override
    public void execute(UiDevice uiDevice) {

        Random widthRandom = new Random(System.currentTimeMillis());
        Random heightRandom = new Random(System.currentTimeMillis());

        int screenWidth = uiDevice.getDisplayWidth();
        int screenHeight = uiDevice.getDisplayHeight();

        int i= 0;
        while (clickCount >= 0) {
            uiDevice.click(widthRandom.nextInt(screenWidth), heightRandom.nextInt(screenHeight));
            clickCount--;
            System.out.println("click=" + i++);
        }
    }
}
