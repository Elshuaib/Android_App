package com.example.androidapp;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


import com.example.androidapp.R;
import com.google.android.material.snackbar.Snackbar;

import java.text.NumberFormat;

import androidx.appcompat.app.AppCompatActivity;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {

    Button button;
    int quantity = 0;
    int price = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button=findViewById(R.id.reset_button_id);

        button.setOnClickListener(new View.OnClickListener() {
            //@Override
            public void onClick(View view){
                resetQuantity(view);
                Snackbar snackbar = Snackbar.make(findViewById(R.id.parentLayout), "Quantity has been reset",
                        Snackbar.LENGTH_LONG).setAction("Action",null);
                snackbar.show();
            }

        });


    }
    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view)
    {
        String priceMessage = "$" + (quantity * price);
        displayMessage(priceMessage);
    }

    /**
     * This method will increase the quantity of coffee ordered.
     */
    public void increment(View view){
        quantity++;
        display(quantity);
    }

    /**
     * This method decreases the quantity of coffee ordered.
     */
    public void decrement(View view){
        quantity--;
        if(quantity<0){
            quantity=0;
        }
        display(quantity);
    }


    /**
     * This method displays the given quantity value on the screen.
     */
    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(
                R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }

    /**
     * This method displays the given price on the screen.
     */
    private void displayPrice(int number) {
        TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
        priceTextView.setText(NumberFormat.getCurrencyInstance().format(number));
    }

    /**
     * This method displays the given text on the screen.
     */
    private void displayMessage(String message) {
        TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
        priceTextView.setText(message);
    }

    /**
     * This method resets the number of quantity
     */
    public void resetQuantity(View view) {
        quantity = 0;
        display(quantity);
    }

}