package com.example.formnavhost.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.activity.OnBackPressedCallback;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.formnavhost.R;
import com.example.formnavhost.databinding.FormEntryBinding;

public class EmailFragment extends Fragment {

    private FormEntryBinding binding;

    public EmailFragment() {

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

        if(binding.formEditText != null ){
            binding.continueButton.setBackgroundColor(requireActivity().getColor(R.color.continue_button_background_color));
        }

        binding.formTextView.setText(R.string.my_email);
        binding.formHint.setText(R.string.my_email_hint);
        binding.editTextHint.setText("Enter your E");


        binding.continueButton.setOnClickListener(v -> {
            Bundle schoolNameFragmentArgs = new SchoolNameFragmentArgs.Builder().setName(requireArguments()
                    .get("name").toString()).setEmail(binding.formEditText.getEditText().getText().toString()).build().toBundle();
            NavHostFragment.findNavController(this).navigate(R.id.destination_school_name_fragment, schoolNameFragmentArgs);
        });

        requireActivity().getOnBackPressedDispatcher().addCallback(getViewLifecycleOwner(), new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {
                returnToNameFragment();
            }
        });
    }

    private void returnToNameFragment() {
        NavHostFragment.findNavController(this).navigate(R.id.action_email_fragment_pop);
    }
}
