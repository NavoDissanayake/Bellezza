package com.example.bellezza;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class AdminLogin extends AppCompatActivity {

    // EditText nic, pwd;
    //Button Go;
    // TextView forgotPassword;
    //FirebaseDatabase mFirebaseAuth;
    //FirebaseDatabase database = FirebaseDatabase.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adminlogin);

        //add activity
        Button butn = (Button)findViewById(R.id.butn);
        butn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent8 = new Intent(AdminLogin.this ,Admin.class);
                startActivity(intent8);

                //Add Toast
                Toast.makeText(AdminLogin.this, "Loading...", Toast.LENGTH_SHORT).show();
            }
        });

    }
}

        //mFirebaseAuth=FirebaseDatabase.getInstance();

    /*     nic = findViewById(R.id.nic);
        pwd= findViewById(R.id.pwd);
        Go = findViewById(R.id.Go);



        Go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String NIC = nic.getText().toString();
                String Password = pwd.getText().toString();


                if (TextUtils.isEmpty(NIC) || TextUtils.isEmpty(Password)) {

                    Toast toast = Toast.makeText(getApplicationContext(), "Username or Password  can't be empty", Toast.LENGTH_SHORT);
                    toast.show();

                } else
                    {




                }

                Intent i = new Intent(AdminLogin.this, Admin.class);

                startActivity(i);

            }


        });

    }

   public void checkUserType(final String NIC, final String Password) {

        final DatabaseReference userIsACustomer = database.getReference("Admin").child(NIC);
        //final DatabaseReference userIsASupplier = database.getReference("suppliers").child(username);

        userIsACustomer.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                if (dataSnapshot.exists()) {

                    String correctPassword = dataSnapshot.child("Password").getValue(String.class);
                    String userType = "Admin";
                    assert correctPassword != null;
                    validateLogin(correctPassword, NIC, Password, userType);

                } else {
                    Toast toast = Toast.makeText(AdminLogin.this, "There is no existing user", Toast.LENGTH_SHORT);
                    toast.show();
                }
            }



            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }

        });
    }

    public void validateLogin(String correctPassword, String enteredPassword, String enteredNIC, String userType) {

        if (correctPassword.equals(enteredPassword)) {



            loadPortal(userType, enteredNIC);


        } else {
            Toast toast = Toast.makeText(AdminLogin.this, "Please check again", Toast.LENGTH_SHORT);
            toast.show();

        }

    }

    private void loadPortal(String userType, String enteredUsername) {

        GlobalClass global = ((GlobalClass)  getApplicationContext());

        switch (userType) {
            case "Admin":
                startActivity(new Intent(getApplicationContext(),Admin.class));
                global.setLoggedCustomerNIC(enteredUsername);
                break;

        }
    }*/


