package com.example.design.Fragment;

import android.os.Bundle;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.design.R;

import java.util.Objects;

public class AccFragment extends Fragment {


    private TextView general, personal_info, fav, acc_status, language, captions, notifications, about;
    private ConstraintLayout acc_frag, sign_out_layout;
    private LinearLayout text_layout;

    private Button openFirstFragment, secondFragment;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_acc, container, false);

        openFirstFragment = view.findViewById(R.id.openFirstFragment);
        secondFragment = view.findViewById(R.id.secondFragment);

        NavController navController = NavHostFragment.findNavController(this);
        final String[] appBarTitle = {""};
        final String[] tag = {"test"};

        openFirstFragment.setOnClickListener(v -> {
            FragmentTransaction fragmentTransaction = requireActivity().getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.account, new TestPersonalFormation());
            fragmentTransaction.addToBackStack(AccFragment.class.getName());
            fragmentTransaction.commit();

          /*  appBarTitle[0] = "Personal Information";
            Objects.requireNonNull(((AppCompatActivity) requireActivity()).getSupportActionBar()).setTitle(appBarTitle[0]);
            Objects.requireNonNull(((AppCompatActivity) requireActivity()).getSupportActionBar()).setHomeAsUpIndicator(R.drawable.ic_baseline_arrow_back_24);
            openFirstFragment.setVisibility(View.INVISIBLE);
            secondFragment.setVisibility(View.INVISIBLE);*/

        });

        secondFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*TestAccountStatus testAccountStatus = new TestAccountStatus();
                FragmentManager fragManagers = requireActivity().getSupportFragmentManager();
                FragmentTransaction fragTransaction = fragManagers.beginTransaction();
                fragTransaction.replace(R.id.container, testAccountStatus, null);
                fragTransaction.addToBackStack(null);
                fragTransaction.commit();

                appBarTitle[0] = "Status";
                Objects.requireNonNull(((AppCompatActivity) requireActivity()).getSupportActionBar()).setTitle(appBarTitle[0]);
                Objects.requireNonNull(((AppCompatActivity) requireActivity()).getSupportActionBar()).setHomeAsUpIndicator(R.drawable.ic_baseline_arrow_back_24);
                openFirstFragment.setVisibility(View.INVISIBLE);
                secondFragment.setVisibility(View.INVISIBLE);*/

                addFragments("first");
                replaceFragments("second");
            }
        });

        return view;
    /*    //Information layout. Initialize the elements
        personal_info = view.findViewById(R.id.personal_info);
        fav = view.findViewById(R.id.fav);
        acc_status = view.findViewById(R.id.acc_status);
        language = view.findViewById(R.id.language);
        captions = view.findViewById(R.id.captions);
        notifications = view.findViewById(R.id.notifications);
        about = view.findViewById(R.id.about);

        //For the button layout and if the user tap the Sign-out
        sign_out_layout = view.findViewById(R.id.sign_out_layout);
        sign_out_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), MainActivity.class);
                startActivity(intent);
            }
        });

        //If the user tap the Personal Information field
        personal_info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayFragment(0);
            }
        });

        //If the user tap the Favorites field
        fav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayFragment(1);
            }
        });

        //If the user tap Account Status field
        acc_status.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayFragment(2);

            }
        });

        //If the user tap the Language field
        language.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View v) {
                displayFragment(3);
            }
        });

        //If the user tap the Captions field
        captions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayFragment(4);
            }
        });

        //If the user tap the Notification field
        notifications.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayFragment(5);
            }
        });

        //If the user tap the About field
        about.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayFragment(6);
            }
        });

        NavController navController = NavHostFragment.findNavController(this);*/

    }

    public void addFragments(String tag) {
        FragmentManager fma = requireActivity().getSupportFragmentManager();
        FragmentTransaction ftt = fma.beginTransaction();

        TestAccountStatus acStatus = new TestAccountStatus();

        ftt.add(R.id.container, acStatus, "first");
        ftt.commit();
    }

    public void replaceFragments(String id) {
        FragmentManager fm = requireActivity().getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();

        TestAccountStatus acStatus = new TestAccountStatus();

        ft.replace(R.id.container, acStatus, "second");
        ft.commit();
    }

    /*public void displayFragment(int position) {

        Fragment fragment = null;
        String actionBarTitle = "";

        switch (position) {
            case 0:
                fragment = new AccountPersonalFragment();
                actionBarTitle = "Personal Information";
                break;

            case 1:
                fragment = new FavoritesFragment();
                actionBarTitle = "Favorites";
                break;

            case 2:
                fragment = new AccountStatusFragment();
                actionBarTitle = "Account Status";
                break;

            case 3:
                fragment = new LanguageTest();
                actionBarTitle = "Language";
                break;

            case 4:
                fragment = new CaptionsFragment();
                actionBarTitle = "Captions";
                break;

            case 5:
                fragment = new AccountNotificationFragment();
                actionBarTitle = "Notifications";
                break;

            case 6:
                fragment = new AboutFragment();
                actionBarTitle = "About";
                break;

            default:
                break;
        }

        if (fragment !=null) {
            requireActivity().getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, fragment)
                    .commit();
            ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle(actionBarTitle);
            ((AppCompatActivity)getActivity()).getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_baseline_arrow_back_24);
        }
    }*/
}