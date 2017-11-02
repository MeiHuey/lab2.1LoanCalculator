package my.edu.tarc.lab21loancalculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    public TextView textViewMonthlyPayment, textViewStatus;
    public ImageView imageViewStatus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        textViewMonthlyPayment = (TextView)findViewById(R.id.textViewMonthlyPayment);
        textViewStatus = (TextView)findViewById(R.id.textViewStatus);
        imageViewStatus = (ImageView)findViewById(R.id.imageViewStatus);

        //TO get the intent
        Intent intent = getIntent();    //Asking "who called me?"
        double payment=intent.getDoubleExtra(MainActivity.LOAN_PAYMENT, 0);
        String status=intent.getStringExtra(MainActivity.LOAN_STATUS);

        //TODO: display output
        textViewMonthlyPayment.setText("Your monthly payment is " + payment);
        textViewStatus.setText("Status = " + status);
        if(status.equals("Approve"))
            imageViewStatus.setImageResource(R.drawable.up);
        else
            imageViewStatus.setImageResource(R.drawable.down);

    }

    public void closeActivity(View view){
        //Terminate an activity
        finish();
    }
}
