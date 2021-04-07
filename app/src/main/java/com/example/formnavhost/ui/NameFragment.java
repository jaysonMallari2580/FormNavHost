package com.example.formnavhost.ui;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

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

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.formEditText.getEditText().addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(binding.formEditText.getEditText().toString().length() > 0 || binding.formEditText.getEditText() == null){
                    binding.continueButton.setBackgroundColor(requireActivity().getColor(R.color.continue_button_background_color));
                    binding.continueButton.setEnabled(true);
                }else{
                    binding.continueButton.setBackgroundColor(requireActivity().getColor(R.color.continue_button_background_color_start));
                }

            }

            @Override
            public void afterTextChanged(Editable s) {
               if(binding.formEditText.getEditText().toString().length() > 0 || binding.formEditText.getEditText() == null){
                   binding.continueButton.setBackgroundColor(requireActivity().getColor(R.color.continue_button_background_color));
                   binding.continueButton.setEnabled(true);
               }else{
                   binding.continueButton.setBackgroundColor(requireActivity().getColor(R.color.continue_button_background_color_start));
               }
            }
        });

        binding.formTextView.setText(R.string.my_first_name);
        binding.formHint.setText(R.string.my_first_name_hint);
        binding.editTextHint.setHint("Enter your First Name . . .");

        binding.continueButton.setOnClickListener(v -> {
            Bundle emailFragmentArgs = new EmailFragmentArgs.Builder().setName(binding.formEditText.getEditText().getText().toString()).build().toBundle();
            NavHostFragment.findNavController(this).navigate(R.id.destination_email_fragment, emailFragmentArgs);
        });
    }


}
