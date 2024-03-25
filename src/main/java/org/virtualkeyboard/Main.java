package org.virtualkeyboard;

import com.github.kwhat.jnativehook.GlobalScreen;
import com.github.kwhat.jnativehook.NativeHookException;

import javax.swing.*;

/**
 * @author zhengziyang
 * @date 2024/3/20 18:43
 */
public class Main {
    public static void main(String[] args) {
        try {
            GlobalScreen.registerNativeHook();
        } catch (NativeHookException e) {
            throw new RuntimeException(e);
        }
        GlobalScreen.addNativeKeyListener(new KeyboardListener());
        VirtualKeyboard frame = new VirtualKeyboard();
        frame.setVisible(true);
    }
}