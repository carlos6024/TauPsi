package com.asutaupsi.taupsi.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.asutaupsi.taupsi.R;
import com.asutaupsi.taupsi.entities.Brother;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import butterknife.Bind;
import butterknife.ButterKnife;

public class BrotherDetailsFragment extends BaseFragment {
    private Brother brother;
    private static final String BROTHER_EXTRA_INFO = "BROTHER_EXTRA_INFO";


    @Bind(R.id.fragment_brother_details_ImageView)
    ImageView brotherPicture;


    @Bind(R.id.fragment_brother_details__whyJoined)
    TextView brotherWhyTauPsi;

    @Bind(R.id.fragment_brother_details_brotherName)
    TextView brotherName;

    @Bind(R.id.fragment_brother_details_progressBar)
    ProgressBar brotherProgressBar;


    @Bind(R.id.fragment_brother_details_brotherMajor)
    TextView brotherMajor;


    @Bind(R.id.fragment_brother_details_crossFunFact)
    TextView brotherFunFact;


    @Bind(R.id.fragment_brother_details_crossDate)
    TextView brotherCrossSemester;




    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        brother = getArguments().getParcelable(BROTHER_EXTRA_INFO);
    }

    public static BrotherDetailsFragment newInstance(Brother brother) {
        Bundle args = new Bundle();
        args.putParcelable(BROTHER_EXTRA_INFO, brother);
        BrotherDetailsFragment brotherDetailsFragment = new BrotherDetailsFragment();
        brotherDetailsFragment.setArguments(args);
        return brotherDetailsFragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_meet_a_brother_details, container, false);
        ButterKnife.bind(this, rootView);

        brotherProgressBar.setVisibility(View.VISIBLE);
        brotherName.setText(brother.getBrotherName());


        brotherCrossSemester.setText(getString(R.string.crossed_intro, brother.getBrotherCrossSemester()));
        brotherFunFact.setText(getString(R.string.fun_fact_intro,brother.getBrotherFunFact()));
        brotherMajor.setText(getString(R.string.major_intro, brother.getBrotherMajor()));
        brotherWhyTauPsi.setText(brother.getBrotherWhyJoin());

        Picasso.with(getActivity()).load(brother.getBrotherPicture())
                .fit()
                .centerCrop()
                .into(brotherPicture, new Callback() {
                    @Override
                    public void onSuccess() {
                        brotherProgressBar.setVisibility(View.INVISIBLE);
                    }

                    @Override
                    public void onError() {

                    }
                });

        return rootView;
    }

}

