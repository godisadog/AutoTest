package com.unit.test.command;

import android.support.test.uiautomator.UiDevice;

import java.util.Random;

/**
 * Created by zhenwei on 2017/6/22.
 */

public class SwipeCom implements ICommand {

    private ORIENTATION orientation;

    public SwipeCom(ORIENTATION orientation){
        this.orientation = orientation;
    }

    /**
     * @param uiDevice
     */
    @Override
    public void execute(UiDevice uiDevice) {
       /* //默认的方向
        ORIENTATION orientation = ORIENTATION.RIGHT;
        if (objs != null &&
                objs[0] instanceof ORIENTATION) {
            orientation = (ORIENTATION) objs[0];
        }*/
        int screenWidth = uiDevice.getDisplayWidth();
        int screenHeight = uiDevice.getDisplayHeight();

        Random random = new Random(System.currentTimeMillis());

        int startX = 0, startY = 0, endX = 0, endY = 0;
        switch (orientation) {
            case LEFT:
                startX = screenWidth - 20;
                startY = screenHeight / 2;
                endX = screenWidth - (random.nextInt(screenWidth / 2) + screenWidth / 3);
                endY = screenHeight / 2;
                break;
            case RIGHT:
                startX = 20;
                startY = screenHeight / 2;
                endX = random.nextInt(screenWidth / 2) + screenWidth / 3;
                endY = screenHeight / 2;
                break;
            case UP:
                startX = screenWidth / 2;
                startY = screenHeight - 20;
                endX = screenWidth / 2;
                endY = screenHeight - (random.nextInt(screenHeight / 2) + screenHeight / 3);
                break;
            case DOWN:
                startX = screenWidth / 2;
                startY = 20;
                endX = screenWidth / 2;
                endY = random.nextInt(screenHeight / 2) + screenHeight / 3;
                break;
        }
        uiDevice.swipe(startX, startY, endX, endY, 10);
    }

    public enum ORIENTATION {
        LEFT,
        RIGHT,
        UP,
        DOWN;
    }
}
