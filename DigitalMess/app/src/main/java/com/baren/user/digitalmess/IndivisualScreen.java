package com.baren.user.digitalmess;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class IndivisualScreen extends Activity {

    EditText etnmembername,etndeposit,etnmeal,etnguest,etnec;
    Button bill,save;
    TextView tvbill;
    String name,deposit,meal,guest,ec;
    String TotalExpenditure,TotalEC,TotalMeal,TotalGuest;
    int mealcharge,amount,eccharge;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_indivisual_screen);
        Intent intent=getIntent();
        TotalExpenditure=intent.getStringExtra("TotalExpenditure");
        TotalEC=intent.getStringExtra("TotalEC");
        TotalGuest=intent.getStringExtra("TotalGuest");
        TotalMeal=intent.getStringExtra("TotalMeal");
        bill=(Button)findViewById(R.id.btngetbill);
        save=(Button)findViewById(R.id.btnsave);
        etnmembername=(EditText)findViewById(R.id.etnmember);
        etndeposit=(EditText)findViewById(R.id.etndiposit);
        etnmeal=(EditText)findViewById(R.id.etnmeal);
        etnguest=(EditText)findViewById(R.id.etnguest);
        etnec=(EditText)findViewById(R.id.etnec);
        tvbill=(TextView)findViewById(R.id.tvbill);
        eccharge=Integer.valueOf(TotalEC)/8;
        etnec.setText(eccharge);
        bill.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                name=etnmembername.getText().toString().trim();
                deposit=etndeposit.getText().toString().trim();
                meal=etnmeal.getText().toString().trim();
                guest=etnguest.getText().toString().trim();
                ec=etnec.getText().toString().trim();
                if(TextUtils.isEmpty(name)) {
                    etnmembername.setError("Enter Member Name");
                    return;
                }
                if(TextUtils.isEmpty(deposit)) {
                    etndeposit.setError("Enter Your Deposit Amount");
                    return;
                }
                else if (TextUtils.isEmpty(meal)) {
                    etnmeal.setError("Enter Your total Meal");
                    return;
                }
                else if (TextUtils.isEmpty(guest)) {
                    etnguest.setError("Enter Your Total Guest Charge");
                    return;
                }
                else{
                    //calculate meal charge
                   mealcharge=(Integer.valueOf(TotalExpenditure)-Integer.valueOf(TotalGuest))/Integer.valueOf(TotalMeal);
                   amount=mealcharge*Integer.valueOf(meal)+Integer.valueOf(guest)+Integer.valueOf(ec);
                    if (amount>Integer.valueOf(deposit))
                        tvbill.setText("You have to pay : "+(amount-Integer.valueOf(deposit))+"/-");
                    else
                        tvbill.setText("You will get : "+(Integer.valueOf(deposit)-amount)+"/-");
                }


            }
        });
    }
}
