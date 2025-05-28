package com.example.dinhmaithu_k224111464_411c;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.KeyEvent;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.dinhmaithu_k224111464_411c.models.Account;
import com.example.dinhmaithu_k224111464_411c.models.SampleData;

import java.util.ArrayList;

public class LoginActivity extends AppCompatActivity {
    EditText edtUserName, edtPassword;
    CheckBox chkSaveLoginInfo;
    ArrayList<Account> accountList;
    private boolean doubleBackToExitPressedOnce = false;
    private static final long DOUBLE_BACK_PRESS_THRESHOLD = 1200;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        addViews();
        accountList= SampleData.getAccounts();
    }

    private void addViews() {
        edtUserName = findViewById(R.id.edtUserName);
        edtPassword = findViewById(R.id.edtPassword);
        chkSaveLoginInfo = findViewById(R.id.chkSaveLoginInfo);

    }
    public void do_login(android.view.View view) {
        String usr = edtUserName.getText().toString();
        String pwd = edtPassword.getText().toString();

        for (Account acc : accountList) {
            if (acc.getUsername().equals(usr) && acc.getPassword().equals(pwd)) {
                saveLoginInformation();
                Intent intent = new Intent(this, ProductListActivity.class); // Q4
                startActivity(intent);
                return;
            }
        }

        Toast.makeText(this, "Login failed - check your credentials!", Toast.LENGTH_LONG).show();
    }

    public void do_exit(android.view.View view) {
        new AlertDialog.Builder(this)
                .setTitle("Confirm Exit")
                .setMessage("Are you sure you want to quit?")
                .setIcon(android.R.drawable.ic_dialog_alert)
                .setPositiveButton("Yes", (dialog, which) -> finish())
                .setNegativeButton("No", null)
                .show();
    }

    private void saveLoginInformation() {
        SharedPreferences preferences = getSharedPreferences("LOGIN_INFORMATION", MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("USERNAME", edtUserName.getText().toString());
        editor.putString("PASSWORD", edtPassword.getText().toString());
        editor.putBoolean("SAVED", chkSaveLoginInfo.isChecked());
        editor.commit();
    }

    private void restoreLoginInformation() {
        SharedPreferences preferences = getSharedPreferences("LOGIN_INFORMATION", MODE_PRIVATE);
        String usr = preferences.getString("USERNAME", "");
        String pwd = preferences.getString("PASSWORD", "");
        boolean isSave = preferences.getBoolean("SAVED", false);
        if (isSave) {
            edtUserName.setText(usr);
            edtPassword.setText(pwd);
            chkSaveLoginInfo.setChecked(true);
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        saveLoginInformation();
    }

    @Override
    protected void onResume() {
        super.onResume();
        restoreLoginInformation();
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            if (doubleBackToExitPressedOnce) {
                finish();
                return true;
            }
            this.doubleBackToExitPressedOnce = true;
            Toast.makeText(this, "Please click BACK again to exit", Toast.LENGTH_SHORT).show();
            new Handler().postDelayed(() -> doubleBackToExitPressedOnce = false, DOUBLE_BACK_PRESS_THRESHOLD);
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

}