package com.example.agenda;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity4 extends AppCompatActivity {
        private TextView resultTextView;
        private String input = "";
        private String operator = "";
        private double operand1 = 0.0;
        private double operand2 = 0.0;
        private boolean newOperation = true;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main4);

            resultTextView = findViewById(R.id.resultTextView);

            setUpButtonListeners();
        }

        private void setUpButtonListeners() {
            int[] buttonIds = {
                    R.id.button0, R.id.button1, R.id.button2, R.id.button3, R.id.button4,
                    R.id.button5, R.id.button6, R.id.button7, R.id.button8, R.id.button9,
                    R.id.buttonDot, R.id.buttonPlus, R.id.buttonMinus, R.id.buttonMultiply,
                    R.id.buttonDivide, R.id.buttonClear, R.id.buttonEquals
            };

            for (int id : buttonIds) {
                Button button = findViewById(id);
                button.setOnClickListener(this::onButtonClick);
            }
        }

        private void onButtonClick(View view) {
            Button button = (Button) view;
            String buttonText = button.getText().toString();

            switch (buttonText) {
                case "C":
                    clear();
                    break;
                case "=":
                    calculateResult();
                    break;
                case "+":
                case "-":
                case "*":
                case "/":
                    setOperator(buttonText);
                    break;
                default:
                    appendInput(buttonText);
                    break;
            }
        }

        private void clear() {
            input = "";
            resultTextView.setText("0");
            operator = "";
            operand1 = 0.0;
            operand2 = 0.0;
            newOperation = true;
        }

        private void appendInput(String text) {
            if (newOperation) {
                input = "";
                newOperation = false;
            }
            input += text;
            resultTextView.setText(input);
        }

        private void setOperator(String op) {
            if (!input.isEmpty()) {
                operand1 = Double.parseDouble(input);
                operator = op;
                input = "";
            }
        }

        private void calculateResult() {
            if (!input.isEmpty()) {
                operand2 = Double.parseDouble(input);
                double result = 0.0;

                switch (operator) {
                    case "+":
                        result = operand1 + operand2;
                        break;
                    case "-":
                        result = operand1 - operand2;
                        break;
                    case "*":
                        result = operand1 * operand2;
                        break;
                    case "/":
                        if (operand2 != 0) {
                            result = operand1 / operand2;
                        } else {
                            resultTextView.setText("Error");
                            return;
                        }
                        break;
                }

                resultTextView.setText(String.valueOf(result));
                input = String.valueOf(result);
                operator = "";
                newOperation = true;
            }
        }
        public void volver(View view){
            finish();
        }
    }
