package com.escbooks.changepassword;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        LoginFragment loginFragment = new LoginFragment();

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_container, loginFragment, null);
        transaction.addToBackStack(null);
        transaction.commitAllowingStateLoss();

        loginFragment.setListener(new LoginFragment.LoginFragmentListener() {
            @Override
            public void onChangePasswordButtonClicked() {
                launchChangePasswordFragment();
            }
        });

    }

    void launchChangePasswordFragment() {

        ChangePasswordFragment fragment = new ChangePasswordFragment();

        fragment.setListener(new ChangePasswordFragment.ChangePasswordFragmentListener() {
            @Override
            public void onPasswordChanged(String newPassword) {
                // password changed to:
                Toast.makeText(LoginActivity.this, "Password changed to: ".concat(newPassword), Toast.LENGTH_LONG).show();
                getSupportFragmentManager().popBackStack();
            }
        });

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_container, fragment, null);
        transaction.addToBackStack(null);
        transaction.commitAllowingStateLoss();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_login, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
