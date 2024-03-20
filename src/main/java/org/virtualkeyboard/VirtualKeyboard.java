package org.yy;

import com.github.kwhat.jnativehook.GlobalScreen;
import com.github.kwhat.jnativehook.NativeHookException;
import com.github.kwhat.jnativehook.keyboard.NativeKeyEvent;
import com.github.kwhat.jnativehook.keyboard.NativeKeyListener;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.*;
import java.util.Map;

/**
 * @author zhengziyang
 * @date 2024/3/20 14:54
 */
public class VirtualKeyboard extends JFrame {
    private JPanel contentPanel;    //内容面板

    public VirtualKeyboard() {
        setTitle("VirtualKeyboard");    //设置窗体的标题
        setUndecorated(true);
        setBackground(new Color(0, 0, 0, 0));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);    //设置窗体退出时操作
        setBounds(100, 100, 300, 250);    //设置窗体位置和大小
//        addKeyListener(new MyListener());
        Point point = new Point();
        // 窗体移动
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                point.x = e.getX();
                point.y = e.getY();
            }
        });
        addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                Point p = getLocation();
                setLocation(p.x + e.getX() - point.x, p.y + e.getY() - point.y);
            }
        });
    }

    {
        contentPanel = new JPanel();    //创建内容面板
        contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));    //设置面板的边框
        contentPanel.setLayout(new BorderLayout(0, 0));    //设置内容面板为边界布局
        contentPanel.setBackground(new Color(0, 0, 0, 0));
        setContentPane(contentPanel);    //应用内容面板
        JPanel panel = new JPanel();    //新建面板用于保存按钮
        panel.setBackground(new Color(0, 0, 0, 0));
        panel.setLayout(null);
        contentPanel.add(panel, BorderLayout.CENTER);    //将面板放置在边界布局的中央
        panel.setFocusable(true);
        Map<Integer, JButton> buttonMap = ButtonManager.getButtonMap();
        buttonMap.forEach((k, v) -> {
            panel.add(v);
        });
    }

    public static void main(String[] args) {
        try {
            GlobalScreen.registerNativeHook();
        } catch (NativeHookException e) {
            throw new RuntimeException(e);
        }
        GlobalScreen.addNativeKeyListener(new MyListener());
        VirtualKeyboard frame = new VirtualKeyboard();
        frame.setVisible(true);
    }

    public static class MyListener implements NativeKeyListener {

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

}
