package hcmute.lecongthuong_19110058.tranvanthien_19110136.foody;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ForgotActivity extends AppCompatActivity {
    EditText etUserN, etPassW;
    Button btChanges;
    DataBaseHelper db;
    private View.OnClickListener changeListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            String name = etUserN.getText().toString();
            String pass = etPassW.getText().toString();
            if (name.equals("")) {
                Toast.makeText(ForgotActivity.this, "Please input your username", Toast.LENGTH_SHORT).show();
            } else if (pass.equals("")) {
                Toast.makeText(ForgotActivity.this, "Please input your new password", Toast.LENGTH_SHORT).show();
            } else {
                boolean isUpdate = db.updateOne(name, pass);
                if (isUpdate == true) {
                    Toast.makeText(ForgotActivity.this, "Password Updated", Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(ForgotActivity.this,CustomerActivity.class);
                    startActivity(i);
                } else {
                    Toast.makeText(ForgotActivity.this, "Password Not Updated", Toast.LENGTH_SHORT).show();
                }
            }
            db.close();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot);
        etUserN = this.findViewById(R.id.etUserN);
        etPassW = this.findViewById(R.id.etPassW);
        btChanges = this.findViewById(R.id.btChanges);
        db = new DataBaseHelper(ForgotActivity.this);
        btChanges.setOnClickListener(changeListener);
    }
}