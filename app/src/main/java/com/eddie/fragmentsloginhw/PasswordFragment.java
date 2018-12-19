package com.eddie.fragmentsloginhw;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class PasswordFragment extends Fragment implements View.OnClickListener {

    private TextView passwordTxt;
    private Button okBtn;
    private Callback callback;

    public interface Callback {

        void inputPassword(String password);
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.password_fragment, container, false);

        passwordTxt = view.findViewById(R.id.input_password);

        okBtn = view.findViewById(R.id.ok_btn_pass);
        okBtn.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {

        if (v.getId() == R.id.ok_btn_pass) {

            if (callback != null) {

                String password = passwordTxt.getText().toString();
                callback.inputPassword(password);
            }

        }
    }

    public void setCallback(Callback callback) {

        this.callback = callback;
    }
}
