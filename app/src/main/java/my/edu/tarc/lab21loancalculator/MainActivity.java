package my.edu.tarc.lab21loancalculator;

import android.content.Intent;
import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    public static final String LOAN_PAYMENT = "payment";
    public static final String LOAN_STATUS = "status";

    public EditText editTextPrice, editTextDownpayment, editTextRepayment, editTextInterestRate, editTextSalary;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextPrice = (EditText)findViewById(R.id.editTextPrice);
        editTextDownpayment = (EditText)findViewById(R.id.editTextDownpayment);
        editTextRepayment = (EditText)findViewById(R.id.editTextRepayment);
        editTextInterestRate = (EditText)findViewById(R.id.editTextInterestRate);
        editTextSalary = (EditText)findViewById(R.id.editTextSalary);

    }

    public void calculateLoan(View view){
        //TODO: calculate repayment amount and determine the status of loan application
        String status;
        double vehiclePrice,downpayment, repayment, interestRate, salary, totalInterest, totalLoan, monthlyPayment;

        vehiclePrice = Double.parseDouble(editTextPrice.getText().toString());
        downpayment = Double.parseDouble(editTextDownpayment.getText().toString());
        repayment = Double.parseDouble(editTextRepayment.getText().toString());
        interestRate = Double.parseDouble(editTextInterestRate.getText().toString());
        salary = Double.parseDouble(editTextSalary.getText().toString());

        totalInterest = (vehiclePrice - downpayment) * (interestRate/100) * (repayment / 12);
        totalLoan = (vehiclePrice - downpayment) + totalInterest;
        monthlyPayment = totalLoan/repayment;

        if(monthlyPayment > (0.3*salary))
            status = "Reject";
        else
            status = "Approve";


        //Define an Intent object
        //This is an Expicit Intent
        Intent intent = new Intent(this, ResultActivity.class);

        //Use the putExtra method to pass data
        //format: putExtra(TAG, value)
        intent.putExtra(LOAN_PAYMENT, monthlyPayment);
        intent.putExtra(LOAN_STATUS, status);

        startActivity(intent);
    }
}
