package com.gb.lesson_6;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ContentPane extends JFrame {
    private static int NUMBER_1;
    private static int NUMBER_2;
    private static String MATH_OPERATION;

    public ContentPane() {
        super("Калькулятор");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(400, 400);
        setMinimumSize(new Dimension(300, 300));
        setVisible(true);
        JPanel grid = new JPanel();
        Container container = getContentPane();
        JTextField textField = new JTextField(20);
        container.add(textField, BorderLayout.NORTH);
        grid.setLayout(new GridLayout(4, 4, 10, 10));

        JButton button_0 = new JButton("0");
        JButton button_1 = new JButton("1");
        JButton button_2 = new JButton("2");
        JButton button_3 = new JButton("3");
        JButton button_4 = new JButton("4");
        JButton button_5 = new JButton("5");
        JButton button_6 = new JButton("6");
        JButton button_7 = new JButton("7");
        JButton button_8 = new JButton("8");
        JButton button_9 = new JButton("9");
        JButton buttonPlus = new JButton("+");
        JButton buttonMinus = new JButton("-");
        JButton button_C = new JButton("C");
        JButton buttonMultiply = new JButton("*");
        JButton buttonDivision = new JButton("/");
        JButton buttonEqual = new JButton("=");

        grid.add(button_7);
        grid.add(button_8);
        grid.add(button_9);
        grid.add(buttonPlus);
        grid.add(button_4);
        grid.add(button_5);
        grid.add(button_6);
        grid.add(buttonMinus);
        grid.add(button_1);
        grid.add(button_2);
        grid.add(button_3);
        grid.add(buttonMultiply);
        grid.add(button_C);
        grid.add(button_0);
        grid.add(buttonEqual);
        grid.add(buttonDivision);

        container.add((grid), BorderLayout.CENTER);

        buttonNumbersAction(button_1, textField);
        buttonNumbersAction(button_2, textField);
        buttonNumbersAction(button_3, textField);
        buttonNumbersAction(button_4, textField);
        buttonNumbersAction(button_5, textField);
        buttonNumbersAction(button_6, textField);
        buttonNumbersAction(button_7, textField);
        buttonNumbersAction(button_8, textField);
        buttonNumbersAction(button_9, textField);
        buttonNumbersAction(button_0, textField);

        buttonCAction(button_C, textField);

        buttonEqualAction(buttonEqual, textField);

        buttonMathAction(buttonMinus, textField);
        buttonMathAction(buttonPlus, textField);
        buttonMathAction(buttonMultiply, textField);
        buttonMathAction(buttonDivision, textField);

        setContentPane(container);
        pack();
    }

    public void buttonNumbersAction(JButton button, JTextField textField) {
        ActionListener button_Action = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (textField.getText().equals("+") || textField.getText().equals("-") || textField.getText().equals("*") || textField.getText().equals("/")) {
                    textField.setText("");
                }
                textField.replaceSelection(button.getActionCommand());
            }
        };
        button.addActionListener(button_Action);
    }

    public void buttonCAction(JButton button, JTextField textField) {
        ActionListener button_Action = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                NUMBER_1 = 0;
                NUMBER_2 = 0;
                textField.setText("");
            }
        };
        button.addActionListener(button_Action);
    }

    public void buttonMathAction(JButton button, JTextField textField) {
        ActionListener button_Action = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                NUMBER_1 = Integer.parseInt(textField.getText());
                textField.setText("");
                textField.replaceSelection(button.getActionCommand());
                MATH_OPERATION = textField.getText();
            }
        };
        button.addActionListener(button_Action);
    }

    public void buttonEqualAction(JButton button, JTextField textField) {
        ActionListener button_Action = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                NUMBER_2 = Integer.parseInt(textField.getText());
                switch (MATH_OPERATION) {
                    case ("+"):
                        textField.setText(String.valueOf(NUMBER_1 + NUMBER_2));
                        break;
                    case ("-"):
                        textField.setText(String.valueOf(NUMBER_1 - NUMBER_2));
                        break;
                    case ("*"):
                        textField.setText(String.valueOf(NUMBER_1 * NUMBER_2));
                        break;
                    case ("/"):
                        textField.setText(String.valueOf(NUMBER_1 / NUMBER_2));
                        break;
                }
            }
        };
        button.addActionListener(button_Action);
    }
}
