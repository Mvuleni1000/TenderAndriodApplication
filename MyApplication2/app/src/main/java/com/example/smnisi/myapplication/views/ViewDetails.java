package com.example.smnisi.myapplication.views;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.smnisi.myapplication.R;
import com.example.smnisi.myapplication.model.User;
import com.example.smnisi.myapplication.services.Impl.UserImpl;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by smnisi on 2015/09/23.
 */
public class ViewDetails extends Activity {

    private List<User> userList;
    private ArrayList<String> strUserList;
    private ListView userView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_registered_users);
        viewProducts();
    }



    public void exit(View view)
    {
        android.os.Process.killProcess(android.os.Process.myPid());
    }

    public void viewProducts() {

        userView = (ListView) findViewById(R.id.listViewHardware);

        Thread thread = new Thread (new Runnable() {

            @Override
            public void run() {

                UserImpl service = new UserImpl();

                userList = service.getAllUser();
                strUserList = new ArrayList<>();

                for (User product : userList) {

                    strUserList.add("ID: " + product.getUserID() + "\nUser account: " + product.getAccount() + "\nUser Contact Details: " + product.getContactDetails());
                }
            }
        });

        thread.start();

        try {

            thread.join();
        }
        catch (Exception ex){

            ex.printStackTrace();
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(ViewDetails.this, android.R.layout.simple_list_item_1, android.R.id.text1, strUserList);
        userView.setAdapter(adapter);
    }

}


