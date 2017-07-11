package rp.edu.sg.c302.addressbook;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SignUpActivity extends AppCompatActivity {
    private static final String TAG = "SignUpActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        Button btnSignUp = (Button)findViewById(R.id.btnSignUp);

        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText etName = (EditText)findViewById(R.id.etSignUpName);
                EditText etPassword = (EditText)findViewById(R.id.etSignUpPassword);
                Log.d(TAG, "btn.SignUp.setOnClickListener");
                HttpRequest request = new HttpRequest("http://10.0.2.2/SecureCloudAddressBook/signUp.php");
                request.setMethod("POST");
                request.addData("UserName", etName.getText().toString());
                request.addData("Password", etPassword.getText().toString());
                request.execute();
                finish();
                try{
                    String jsonString = request.getResponse();
                    Log.d(TAG, "jsonString: " + jsonString);
                    finish();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
