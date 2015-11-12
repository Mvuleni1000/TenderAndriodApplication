package com.example.smnisi.myapplication.views;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.smnisi.myapplication.R;
import com.example.smnisi.myapplication.model.User;
import com.example.smnisi.myapplication.services.Impl.UserImpl;
import com.example.smnisi.myapplication.services.UserServices;

/**
 * Created by smnisi on 2015/09/17.
 */
public class CreateUser extends Activity {

    private Button signUp;
    private EditText firstName;
    private EditText lastname;
    private EditText account;
    private EditText company ;
    private EditText contact;

    private String UserExist = "";





    public void onBack(View view)
    {
        Intent i = new Intent(this,MainActivity.class);
        startActivity(i);
    }



    public void exit(View view)
    {
        android.os.Process.killProcess(android.os.Process.myPid());
    }






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_new_user);

        signUp    = (Button) findViewById(R.id.button4);
        firstName =(EditText)findViewById(R.id.nameTxt);
        lastname  = (EditText)findViewById(R.id.surnameTxt);
        company   = (EditText)findViewById(R.id.companyTxt);
        contact   = (EditText)findViewById(R.id.contactTxt);
        account   = (EditText)findViewById(R.id.accountTxt);



        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(firstName.getText().toString().equals("")){
                    firstName.requestFocus();
                    firstName.setError("Cannot be empty");
                }else if(lastname.getText().toString().equals("")){
                    lastname.requestFocus();
                    lastname.setError("Cannot be empty");
                }else if(lastname.getText().toString().equals(""))
                {
                    company.requestFocus();
                    company.setError("Cannot be empty");
                }

                else if(account.getText().toString().equals(""))
                {
                    account.requestFocus();
                    account.setError("Cannot be empty");
                }

                else if(contact.getText().toString().equals(""))
                {
                    contact.requestFocus();
                    contact.setError("Cannot be empty");
                }else {
                    if (contact.getText().toString().equals("")) {
                        contact.requestFocus();
                        contact.setError("Cannot be empty");
                    } else {
                        //Creates new Thread
                        Thread thread = new Thread(new Runnable() {
                            @Override
                            public void run() {
                                UserServices service = new UserImpl();

                                User users = new User();
                                users.setName(firstName.getText().toString());
                                users.setSurname(lastname.getText().toString());
                                users.setAccount(account.getText().toString());
                                users.setCompany(company.getText().toString());
                                users.setContactDetails(contact.getText().toString());


                                UserExist = service.saveUser(users);

                            }
                        });
                        thread.start();

                        try {
                            //RUNS THE THREAD
                            thread.join();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                    }
                    if (UserExist==null) {
                        Toast.makeText(getApplicationContext(), "User Saved Succesfully!",
                                Toast.LENGTH_LONG).show();
                        Intent openStep = new Intent(CreateUser.this, ViewDetails.class);
                        openStep.putExtra("User", contact.getText().toString());
                        startActivity(openStep);
                    } else {
                        contact.requestFocus();
                        contact.setError("User name already exists.");
                    }
                }
            }
        });
    }


}

