package org.virtualkeyboard;

import com.github.kwhat.jnativehook.keyboard.NativeKeyEvent;
import com.github.kwhat.jnativehook.keyboard.NativeKeyListener;

/**
 * @author zhengziyang
 * @date 2024/3/21 09:34
 */
public class KeyboardListener implements NativeKeyListener {

    @Override
    public void nativeKeyPressed(NativeKeyEvent e) {
        ButtonManager.MyButton button = ButtonManager.getButton(e.getKeyCode());
        if (button != null) {
            button.changeColor();
        }
    }
    @Override
    public void nativeKeyReleased(NativeKeyEvent e) {
        ButtonManager.MyButton button = ButtonManager.getButton(e.getKeyCode());
        if (button != null) {
            button.changeColor();
        }
    }
}
