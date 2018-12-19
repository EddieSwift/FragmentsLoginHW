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

public class EmailFragment extends Fragment implements View.OnClickListener {

    private TextView emailTxt;
    private Button okBtn, backBtn;
    private Callback callback;

    public interface Callback {

        void inputEmail(String email);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.email_fragment, container, false);

        emailTxt = view.findViewById(R.id.input_email);
        okBtn = view.findViewById(R.id.ok_btn);
        okBtn.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {

        if (v.getId() == R.id.ok_btn) {

            if (callback != null) {

                String email = emailTxt.getText().toString();
                callback.inputEmail(email);
            }

        }
    }

    public void setCallback(Callback callback) {

        this.callback = callback;
    }

}
