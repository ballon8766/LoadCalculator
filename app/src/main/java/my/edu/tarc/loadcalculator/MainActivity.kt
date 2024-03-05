// my github token : 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

package my.edu.tarc.loadcalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val editTextCarPrice: EditText = findViewById(R.id.editTextCarPrice);
        val editTextDownPayment: EditText = findViewById(R.id.editTextDownPayment);
        val editTextLoanPeriod: EditText = findViewById(R.id.editTextNumberLoadPeriod);
        val editTextInterestRate: EditText = findViewById(R.id.editTextInterestRate);

        val textViewInterest: TextView = findViewById(R.id.textViewInterest);
        val textViewCarLoan: TextView = findViewById(R.id.textViewCarLoan);
        val textViewMonthlyPayment: TextView = findViewById(R.id.textViewMonthlyRepayment);

        val buttonCalculate: Button = findViewById(R.id.buttonCalculate);
        val buttonReset: Button = findViewById(R.id.buttonReset);

        buttonCalculate.setOnClickListener{
            val carPrice: Float = editTextCarPrice.text.toString().toFloat();
            val downPayment: Float = editTextDownPayment.text.toString().toFloat();
            val loanPeriod: Int = editTextLoanPeriod.text.toString().toInt();
            val interestRate: Float = editTextLoanPeriod.text.toString().toFloat();

//            var carLoan: Float = 0.0f;
//            var interest: Float = 0.0f;
//            var monthlyPayment: Float = 0.0f;

            var carLoan = carPrice - downPayment;
            var interest = (carLoan  * interestRate) * loanPeriod;
            var monthlyPayment = (carLoan + interest) / loanPeriod / 12;

            textViewCarLoan.text = String.format("%s %.2f", getString(R.string.car_loan),carLoan);
            textViewInterest.text = String.format("%s %.2f", getString(R.string.interest),interest);
            textViewMonthlyPayment.text = String.format("%s %.2f", getString(R.string.monthly_repayment),monthlyPayment);
            //        textViewCarLoan = editTextCarPrice - editTextDownPayment;
            //        textViewInterest =  editTextLoanPeriod * editTextInterestRate * editTextLoanPeriod
            //        textViewMonthlyPayment = (textViewCarLoan + editTextInterestRate) / editTextLoanPeriod / 12
        }

        buttonReset.setOnClickListener{
            editTextCarPrice.text.clear();
            textViewCarLoan.text = "";
        }



    }
}