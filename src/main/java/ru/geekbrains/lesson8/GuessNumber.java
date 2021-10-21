package ru.geekbrains.lesson8;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GuessNumber extends JFrame {
    private int randomNumber;

    private JTextField textField;


    public GuessNumber() {
            randomNumber = (int) (Math.random() * 10) + 1;

            setTitle("Guess the number");
            setBounds(600, 300, 600, 150);
            setDefaultCloseOperation(EXIT_ON_CLOSE);
            setResizable(false);

            textField = new JTextField();
            add(textField, BorderLayout.NORTH);

            textField.setText("Программа загадала число от 1 до 10");
            textField.setEditable(false);
            textField.setHorizontalAlignment(SwingConstants.CENTER);

            Font font = new Font("Arial", Font.PLAIN, 18);
            textField.setFont(font);

            JPanel buttonsPanel = new JPanel(new GridLayout(1, 10));
            buttonsPanel.setSize(1, 1);
            add(buttonsPanel, BorderLayout.CENTER);

            JButton button1 = new JButton("Restart");
            add(button1, BorderLayout.SOUTH);
            button1.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    restartGame();
                }
            });

            for (int i = 1; i <= 10; i++) {
                JButton button = new JButton(String.valueOf(i));
                button.setFont(font);
                buttonsPanel.add(button);
                int buttonIndex = i;
                button.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        tryToAnswer(buttonIndex, button);
                    }
                });
            }

            setVisible(true);
        }

        public void tryToAnswer ( int answer, JButton button){
            if (answer == randomNumber) {
                textField.setText("Вы угадали! Ответ:" + randomNumber);
            } else if (answer > randomNumber) {
                textField.setText("Не угадали! Загадонное число меньше");
            } else {
                textField.setText("Не угадали! Загадонное число больше");
            }
        }

        public void restartGame(){

        }

    }


