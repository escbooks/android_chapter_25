package com.escbooks.changepassword;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * A simple {@link Fragment} subclass.
 */
public class LoginFragment extends Fragment {

    private LoginFragmentListener listener;

    public LoginFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_login, container, false);

        v.findViewById(R.id.change_password_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (listener != null) listener.onChangePasswordButtonClicked();
            }
        });

        return v;
    }

    public void setListener(LoginFragmentListener listener) {
        this.listener = listener;
    }

    public interface LoginFragmentListener {
        void onChangePasswordButtonClicked();
    }

}
