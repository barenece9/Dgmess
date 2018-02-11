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

public class MainScreen extends Activity {

    Button getmealcharge,getecrate,savenext;
    EditText etnexpenditure,etntotalec,etntotalmeal,etntotalguest;
    String totalexpenditure,totalec,totalguest,totalmeal;
    int mealcharge,ecrate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main_screen);
        getmealcharge=(Button)findViewById(R.id.btnmealcharge);
        getecrate=(Button)findViewById(R.id.btnecrate);
        savenext=(Button)findViewById(R.id.btnsavenext);
        etnexpenditure=(EditText)findViewById(R.id.etnexpen);
        etntotalec=(EditText)findViewById(R.id.etnec);
        etntotalmeal=(EditText)findViewById(R.id.etnmeal);
        etntotalguest=(EditText)findViewById(R.id.etnguest);
        getmealcharge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                totalexpenditure=etnexpenditure.getText().toString().trim();
                totalec=etntotalec.getText().toString().trim();
                totalmeal=etntotalmeal.getText().toString().trim();
                totalguest=etntotalguest.getText().toString().trim();

                if(TextUtils.isEmpty(totalexpenditure)) {
                    etnexpenditure.setError("Enter Total Expenditure");
                    return;
                }
                else if (TextUtils.isEmpty(totalec)) {
                    etntotalec.setError("Enter Total EC");
                    return;
                }
                else if (TextUtils.isEmpty(totalguest)) {
                    etntotalguest.setError("Enter Total Guest");
                    return;
                }
                else if (TextUtils.isEmpty(totalmeal)) {
                    etntotalmeal.setError("Enter Total Meal");
                    return;
                }
                else{
                    //calculate meal charge
                    mealcharge=(Integer.valueOf(totalexpenditure)-Integer.valueOf(totalguest))/Integer.valueOf(totalmeal);
                    getmealcharge.setText("Meal Charge : "+mealcharge+"/-");
                }


            }
        });
        getecrate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                totalexpenditure=etnexpenditure.getText().toString().trim();
                totalec=etntotalec.getText().toString().trim();
                totalmeal=etntotalmeal.getText().toString().trim();
                totalguest=etntotalguest.getText().toString().trim();

                if (TextUtils.isEmpty(totalec)) {
                    etntotalec.setError("Enter Total EC");
                    return;
                }
                else{
                    //calculate meal charge
                    ecrate=Integer.valueOf(totalec)/8;
                    getecrate.setText("EC Rate : "+ecrate+"/-");
                }


            }
        });
        savenext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                totalexpenditure=etnexpenditure.getText().toString().trim();
                totalec=etntotalec.getText().toString().trim();
                totalmeal=etntotalmeal.getText().toString().trim();
                totalguest=etntotalguest.getText().toString().trim();

                if(TextUtils.isEmpty(totalexpenditure)) {
                    etnexpenditure.setError("Enter Total Expenditure");
                    return;
                }
                else if (TextUtils.isEmpty(totalec)) {
                    etntotalec.setError("Enter Total EC");
                    return;
                }
                else if (TextUtils.isEmpty(totalguest)) {
                    etntotalguest.setError("Enter Total Guest");
                    return;
                }
                else if (TextUtils.isEmpty(totalmeal)) {
                    etntotalmeal.setError("Enter Total Meal");
                    return;
                }
                else{
                    //calculate meal charge
                    Intent intent=new Intent(MainScreen.this,IndivisualScreen.class);
                    intent.putExtra("TotalExpenditure",totalexpenditure);
                    intent.putExtra("TotalEC",totalec);
                    intent.putExtra("TotalMeal",totalmeal);
                    intent.putExtra("TotalGuest",totalguest);
                    startActivity(intent);
                }


            }
        });
    }
}
