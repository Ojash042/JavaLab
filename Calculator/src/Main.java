// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.Console;
import java.util.EmptyStackException;
import java.util.Stack;
import javax.swing.JFrame;

public class Main extends JFrame{

    TextField tf;
    public void buttonPressed(String buttonString){
        tf.setText(tf.getText()+ (isOperator(buttonString) ?" ":"") +buttonString + (isOperator(buttonString)?" ": ""));
    }
    Main() {
        tf = new TextField();
        tf.setEditable(false);
        tf.setBackground(Color.WHITE);
        tf.setBounds(40,50,190,30);
        add(tf);
    String[] buttons = new String[]{"1","2","3","4","5","6","7","8","9","0","+","-"};
    for (int i=0;i<buttons.length;i++){
        Button b = new Button(String.format("%s",buttons[i]));
        b.setBounds(40+(i%3)*40,90+((int)(i/3))*39,40,39);
        b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buttonPressed(b.getLabel());
            }
        });
        add(b);
    }

    Button enterButton = new Button("=");
    enterButton.setBounds(160,90,70,156);
    enterButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println(tf.getText());
            tf.setText(String.format("%f",evaluate(tf.getText())));
        }
    });
    add(enterButton);
    Button multButton = new Button("*");
    multButton.setBounds(40,260,40,39);
    Button divButton = new Button("/");
    divButton.setBounds(80,260,40,39);
    multButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            buttonPressed("*");
        }
    });
    divButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            buttonPressed("/");
        }
    });
    add(divButton);
    add(multButton);


    setSize(300,300);
    setLayout(null);
    setVisible(true);
    }
    public double evaluate(String expression){
        String[] tokens = expression.split(" ");
        int counter=0;
        Stack<Double> operandStack = new Stack<>();
        Stack<String> operatorStack = new Stack<>();
        for (String token : tokens) {
            if (isNumeric(token)) {
                operandStack.push(Double.parseDouble(token));
            } else if (isOperator(token)) {
                // If the token is an operator, pop and process operators from the stack
                while (!operatorStack.isEmpty() && hasHigherPrecedence(operatorStack.peek(), token)) {
                    applyOperator(operandStack, operatorStack.pop());
                }
                operatorStack.push(token);
            }
        }
        while (!operatorStack.isEmpty()) {
            applyOperator(operandStack, operatorStack.pop());
        }
        if(operandStack.isEmpty()){
            JOptionPane.showMessageDialog(null,"Invalid Expression");
        }

        try {
            return operandStack.pop();
        }
        catch (EmptyStackException e){
            //JOptionPane.showMessageDialog(null, "");
            tf.setText("");
            return 0;

        }
    }

    public boolean isNumeric(String str){
        return str.matches("-?\\d+(\\.\\d+)?");
    }
    public  boolean isOperator(String t){
        return (t.equals("+")|| t.equals("-")|| t.equals("*")|| t.equals("/"));
    }

    private int getPrecedence(String operator) {
        switch (operator) {
            case "+":
            case "-":
                return 1;
            case "*":
            case "/":
                return 2;
            default:
                return 0;
        }
    }

    private boolean hasHigherPrecedence(String op1, String op2) {
        return getPrecedence(op1) >= getPrecedence(op2);
    }

    private void applyOperator(Stack<Double> operandStack, String operator) {
        double operand1 =1;
        double operand2 = 1;
        try {
            operand2 = operandStack.pop();
            operand1 = operandStack.pop();
        }

        catch (EmptyStackException e){
            JOptionPane.showMessageDialog(null, "Invalid Expression");
            tf.setText("");
            return;
        }

        switch (operator) {
            case "+":
                operandStack.push(operand1 + operand2);
                break;
            case "-":
                operandStack.push(operand1 - operand2);
                break;
            case "*":
                operandStack.push(operand1 * operand2);
                break;
            case "/":
                try {
                    operandStack.push(operand1 / operand2);
                }
                catch (Exception e){
                    JOptionPane.showMessageDialog(null,"Cannot divide by zero");
                }
                break;
        }
    }

    public static void main(String[] args){
        Main m = new Main();
    }
}
