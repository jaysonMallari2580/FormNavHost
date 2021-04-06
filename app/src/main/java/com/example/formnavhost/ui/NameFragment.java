package com.example.formnavhost.ui;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.formnavhost.R;
import com.example.formnavhost.databinding.FormEntryBinding;

public class NameFragment extends Fragment {

    private FormEntryBinding binding;

    public NameFragment() {

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        binding = FormEntryBinding.inflate(getLayoutInflater());
        return binding.getRoot();
    }

    @SuppressLint("ResourceAsColor")
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        if(binding.formEditText != null ){
            binding.continueButton.setBackgroundColor(R.color.continue_button_background_color);
        }

        binding.formTextView.setText(R.string.my_first_name);
        binding.formHint.setText(R.string.my_first_name_hint);
        binding.editTextHint.setHint("Enter your First Name . . .");

        binding.continueButton.setOnClickListener(v -> {
            Bundle emailFragmentArgs = new EmailFragmentArgs.Builder().setName(binding.formEditText.getEditText().getText().toString()).build().toBundle();
            NavHostFragment.findNavController(this).navigate(R.id.destination_email_fragment, emailFragmentArgs);
        });
    }
}
