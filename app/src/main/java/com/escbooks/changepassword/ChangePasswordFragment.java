package com.escbooks.changepassword;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;


/**
 * A simple {@link Fragment} subclass.
 */
public class ChangePasswordFragment extends Fragment {

    private ChangePasswordFragmentListener listener;

    public ChangePasswordFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_change_password, container, false);

        final EditText newPasswordView = (EditText) v.findViewById(R.id.new_password_view);

        v.findViewById(R.id.done_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (listener != null)
                    listener.onPasswordChanged(newPasswordView.getText().toString());
            }
        });
        return v;
    }

    public void setListener(ChangePasswordFragmentListener listener) {
        this.listener = listener;
    }

    public interface ChangePasswordFragmentListener {
        void onPasswordChanged(String newPassword);
    }
}
