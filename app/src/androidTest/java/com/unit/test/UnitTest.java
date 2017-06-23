package com.unit.test;

import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import android.support.test.uiautomator.UiDevice;

import com.unit.test.command.ICommand;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * Created by zhenwei on 2017/6/21.
 */
@RunWith(AndroidJUnit4.class)
public class UnitTest {
    private UiDevice uiDevice;

    private Property property;

    @Before
    public void setUp() {
        System.out.println("setUp=============");

        property = new Property();
        uiDevice = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation());
    }

    @Test
    public void testDemo() {
        System.out.println("testDemo=============");
        uiDevice.pressHome();
        excuteAction();
    }

    private void excuteAction(){
        if (property.actions != null){
            for (ICommand command : property.actions){
                if (command != null) {
                    command.execute(uiDevice);
                }
            }
        }
    }

}
