package com.example.bellezza;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

//import com.example.bellezza.R;

public class Login extends AppCompatActivity {

    EditText UsernameEditText, PasswordEditText;
    Button LoginButton;
    // TextView forgotPassword;
    //FirebaseDatabase mFirebaseAuth;
    FirebaseDatabase database = FirebaseDatabase.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //mFirebaseAuth=FirebaseDatabase.getInstance();

        UsernameEditText = findViewById(R.id.editTextTextUsername);
        PasswordEditText = findViewById(R.id.editTextTextPassword);
        LoginButton = findViewById(R.id.LoginBtn);



        LoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String NIC = UsernameEditText.getText().toString();
                String Password = PasswordEditText.getText().toString();


                if (TextUtils.isEmpty(NIC) || TextUtils.isEmpty(Password)) {

                    Toast toast = Toast.makeText(getApplicationContext(), "Username or Password  can't be empty", Toast.LENGTH_SHORT);
                    toast.show();

                } else {

                    checkUserType(NIC, Password);

                }


                Intent i = new Intent(Login.this, UserPortal.class);

                startActivity(i);

            }


        });

    }

    public void checkUserType(final String NIC, final String Password) {

        final DatabaseReference userIsACustomer = database.getReference("customer").child(NIC);
        //final DatabaseReference userIsASupplier = database.getReference("suppliers").child(username);

        userIsACustomer.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                if (dataSnapshot.exists()) {

                    String correctPassword = dataSnapshot.child("Password").getValue(String.class);
                    String userType = "customer";
                    assert correctPassword != null;
                    validateLogin(correctPassword, NIC, Password, userType);

                } else {
                    Toast toast = Toast.makeText(Login.this, "There is no existing user", Toast.LENGTH_SHORT);
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

            Toast toast = Toast.makeText(Login.this, "Logged as " + userType, Toast.LENGTH_SHORT);
            toast.show();

            loadPortal(userType, enteredNIC);


        } else {
            Toast toast = Toast.makeText(Login.this, "Please check again", Toast.LENGTH_SHORT);
            toast.show();

        }

    }

    private void loadPortal(String userType, String enteredUsername) {

        GlobalClass global = ((GlobalClass)  getApplicationContext());

        switch (userType) {
            case "customer":
                startActivity(new Intent(getApplicationContext(),UserPortal.class));
                global.setLoggedCustomerNIC(enteredUsername);
                break;

        }
    }
}






