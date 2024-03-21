package org.virtualkeyboard;

import com.github.kwhat.jnativehook.keyboard.NativeKeyEvent;

import javax.swing.*;
import javax.swing.plaf.FontUIResource;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

/**
 * @author zhengziyang
 * @date 2024/3/20 17:11
 */
public class ButtonManager {

    private static final Map<Integer, JButton> BUTTON_MAP = new HashMap<>(16);
    private static final JButton buttonQ = new MyButton("Q", 30, 30);
    private static final JButton buttonW = new MyButton("W", 65, 30);
    private static final JButton buttonE = new MyButton("E", 100, 30);
    private static final JButton buttonR = new MyButton("R", 135, 30);
    private static final JButton buttonA = new MyButton("A", 45, 65);
    private static final JButton buttonS = new MyButton("S", 80, 65);
    private static final JButton buttonD = new MyButton("D", 115, 65);
    private static final JButton buttonF = new MyButton("F", 150, 65);
    private static final JButton buttonZ = new MyButton("Z", 60, 100);
    private static final JButton buttonX = new MyButton("X", 95, 100);
    private static final JButton buttonC = new MyButton("C", 130, 100);

    static {
        BUTTON_MAP.put(NativeKeyEvent.VC_Q, buttonQ);
        BUTTON_MAP.put(NativeKeyEvent.VC_W, buttonW);
        BUTTON_MAP.put(NativeKeyEvent.VC_E, buttonE);
        BUTTON_MAP.put(NativeKeyEvent.VC_R, buttonR);
        BUTTON_MAP.put(NativeKeyEvent.VC_A, buttonA);
        BUTTON_MAP.put(NativeKeyEvent.VC_S, buttonS);
        BUTTON_MAP.put(NativeKeyEvent.VC_D, buttonD);
        BUTTON_MAP.put(NativeKeyEvent.VC_F, buttonF);
        BUTTON_MAP.put(NativeKeyEvent.VC_Z, buttonZ);
        BUTTON_MAP.put(NativeKeyEvent.VC_X, buttonX);
        BUTTON_MAP.put(NativeKeyEvent.VC_C, buttonC);
    }

    public static MyButton getButton(Integer button) {
        JButton jButton = BUTTON_MAP.get(button);
        return jButton == null ? null : (MyButton) jButton;
    }

    public static Map<Integer, JButton> getButtonMap() {
        return BUTTON_MAP;
    }

    public static class MyButton extends JButton {

        private Color pressedColor = ColorManager.COLOR_PRESSED;

        private Color releasedColor = ColorManager.COLOR_RELEASED;

        private Color nowColor = releasedColor;

        public MyButton() {

        }

        public MyButton(String text) {
            super(text);
            setOpaque(false);
            setMargin(new Insets(0, 0, 0, 0));
            setBorder(BorderFactory.createLineBorder(ColorManager.COLOR_RELEASED));
            setContentAreaFilled(false);
            setBackground(ColorManager.COLOR_RELEASED);
            setForeground(Color.WHITE);
        }

        public MyButton(String text, Integer x, Integer y) {
            super(text);
            setOpaque(false);
            setMargin(new Insets(0, 0, 0, 0));
            setBorder(BorderFactory.createLineBorder(ColorManager.COLOR_RELEASED, 0));
            setContentAreaFilled(false);
            setBackground(ColorManager.COLOR_RELEASED);
            setBounds(x, y, 30, 30);
            setForeground(Color.white);
        }

        public void changeColor() {
            if (nowColor == releasedColor) {
                nowColor = pressedColor;
                setOpaque(true);
            } else {
                nowColor = releasedColor;
                setOpaque(false);
            }
            setBackground(nowColor);
        }
    }
}
