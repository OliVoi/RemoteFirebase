package com.viettelpost.remoteconfig.remotefirebase.app.view;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.jackandphantom.blurimage.BlurImage;
import com.viettelpost.remoteconfig.remotefirebase.R;
import com.viettelpost.remoteconfig.remotefirebase.app.model.EvenActivityMain;

//Main
public class MainActivity extends AppCompatActivity {
    private ImageView imgBack;
    private EditText mail, pass;
    private Button btnLogin, btnRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getFind();
        setBlur();

        final EvenActivityMain evenActivityMain = EvenActivityMain.getFind(this);
        evenActivityMain.getAuth();

        evenActivityMain.getLogin(btnLogin, mail, pass);
        evenActivityMain.singUp(mail, pass, btnRegister);
    }

    private void getFind() {
        imgBack = findViewById(R.id.imgBack);
        mail = findViewById(R.id.ediEmail);
        pass = findViewById(R.id.editPass);
        btnLogin = findViewById(R.id.btnLogin);
        btnRegister = findViewById(R.id.btnRegister);
    }

    private void setBlur() {
        BlurImage.with(getApplicationContext()).load(R.drawable.cytyy).intensity(8).Async(true).into(imgBack);
    }


}