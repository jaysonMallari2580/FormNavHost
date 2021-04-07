package com.example.formnavhost.ui;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.OnBackPressedCallback;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.fragment.NavHostFragment;

import com.example.formnavhost.R;
import com.example.formnavhost.databinding.FormEntryBinding;

public class SchoolNameFragment extends Fragment {

    private FormEntryBinding binding;

    public SchoolNameFragment() {

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

        binding.formTextView.setText(R.string.my_school);
        binding.formHint.setText(R.string.school_name_hint);
        binding.editTextHint.setHint("Enter your school name . . ");

        binding.continueButton.setOnClickListener(v -> {
            Bundle profileFragmentArgs = new ProfileFragmentArgs.Builder().setName(requireArguments()
                    .get("name").toString()).setEmail(requireArguments().get("email").toString())
                    .setSchoolName(binding.formEditText.getEditText().getText().toString()).build().toBundle();
            NavHostFragment.findNavController(this).navigate(R.id.destination_profile_fragment, profileFragmentArgs);
        });

        requireActivity().getOnBackPressedDispatcher().addCallback(getViewLifecycleOwner(), new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {
                returnToEmailFragment();
            }
        });
    }

    private void returnToEmailFragment() {
        NavHostFragment.findNavController(this).navigate(R.id.action_school_name_fragment_pop);
    }
}
