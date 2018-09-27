package com.viettelpost.remoteconfig.remotefirebase.app.model;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.viettelpost.remoteconfig.remotefirebase.R;
import com.viettelpost.remoteconfig.remotefirebase.app.view.HomeActivity;
import com.viettelpost.remoteconfig.remotefirebase.app.view.MainActivity;

public class EvenActivityMain {
    private FirebaseAuth mAuth;
    private Activity Activity;
    private static EvenActivityMain evenActivityMain;

    private EvenActivityMain(Activity a) {
        this.Activity = a;
    }

    public static EvenActivityMain getFind(Activity a) {
        if (evenActivityMain == null) {
            evenActivityMain = new EvenActivityMain(a);
        }
        return evenActivityMain;
    }

    public void getAuth() {
        mAuth = FirebaseAuth.getInstance();
        FirebaseUser user = mAuth.getCurrentUser();
        updateUI(user);
    }

    private void updateUI(FirebaseUser currentUser) {
        if (currentUser != null) {
            Intent returnBtn = new Intent(Activity, HomeActivity.class);
            returnBtn.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            Activity.startActivity(returnBtn);
        }
    }

    public void singUp(final EditText email, final EditText pass, Button b) {
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mAuth.createUserWithEmailAndPassword(email.getText().toString(), pass.getText().toString())
                        .addOnCompleteListener(Activity, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    // Sign in success, update UI with the signed-in user's information
                                    Log.e("show---", "createUserWithEmail:success");
                                    FirebaseUser user = mAuth.getCurrentUser();
                                    updateUI(user);
                                } else {
                                    // If sign in fails, display a message to the user.
                                    Log.e("show---", "createUserWithEmail:failure", task.getException());
                                    Toast.makeText(Activity, "Authentication failed.",
                                            Toast.LENGTH_SHORT).show();
                                    updateUI(null);
                                }
                            }
                        });
            }
        });

    }

    public void getLogOut(Button b) {
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                Toast.makeText(Activity, "Đăng xuất thành công", Toast.LENGTH_SHORT).show();
                Intent returnBtn = new Intent(Activity, MainActivity.class);
                returnBtn.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                Activity.startActivity(returnBtn);

            }
        });

    }

    public void getLogin(Button b, final EditText email, final EditText pass, ProgressDialog dialog, Context context) {
        final ProgressDialog finalDialog = dialog;
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finalDialog.setMessage("Registering Please Wait...");
                finalDialog.show();
                finalDialog.setCanceledOnTouchOutside(false);
                mAuth.signInWithEmailAndPassword(email.getText().toString(), pass.getText().toString())
                        .addOnCompleteListener(Activity, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {

                                if (task.isSuccessful()) {
                                    Toast.makeText(Activity, "Đăng nhập thành công",
                                            Toast.LENGTH_SHORT).show();
                                    FirebaseUser user = mAuth.getCurrentUser();
                                    updateUI(user);
                                } else {
                                    Log.e("Error: ", "signInWithEmail:failure", task.getException());
                                    email.setError("");
                                    pass.setError("");
                                    Toast.makeText(Activity, "Đăng nhập thất bại",
                                            Toast.LENGTH_SHORT).show();
                                    Toast.makeText(Activity, "Email hoặc mật khẩu không đúng",
                                            Toast.LENGTH_SHORT).show();
                                    updateUI(null);
                                }

                            }
                        });
            }
        });
        finalDialog.dismiss();
    }

    public void OverLoad(Button button, final Context context) {

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Activity.recreate();
            }
        });

    }

}
