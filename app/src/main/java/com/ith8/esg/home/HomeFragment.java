package com.ith8.esg.home;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.ith8.esg.MainActivity;
import com.ith8.esg.R;
import com.ith8.esg.about.AboutFragment;
import com.ith8.esg.home_page.HomeStudioFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeFragment extends Fragment implements View.OnClickListener {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    @BindView(R.id.img_home)
    ImageView imgHome;
    @BindView(R.id.img)
    ImageView img;
    @BindView(R.id.rl_home)
    RelativeLayout rlHome;
    @BindView(R.id.img_course)
    ImageView imgCourse;
    @BindView(R.id.rl_course)
    RelativeLayout rlCourse;
    @BindView(R.id.img_service)
    ImageView imgService;
    @BindView(R.id.service)
    RelativeLayout service;
    @BindView(R.id.img_about)
    ImageView imgAbout;
    @BindView(R.id.rl_about)
    RelativeLayout rlAbout;
    @BindView(R.id.img_contact)
    ImageView imgContact;
    @BindView(R.id.rl_contact)
    RelativeLayout rlContact;
    Unbinder unbinder;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    public HomeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HomeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        unbinder = ButterKnife.bind(this, view);
        initView();
        return view;
    }

    private void initView() {
        rlHome.setOnClickListener(this);
        rlAbout.setOnClickListener(this);
        rlContact.setOnClickListener(this);
        rlCourse.setOnClickListener(this);
        service.setOnClickListener(this);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void onClick(View v) {
        Fragment fragment =null;
        switch (v.getId()){
            case R.id.rl_about:
                fragment= AboutFragment.newInstance("","");
                break;
                case R.id.rl_contact:
                fragment= AboutFragment.newInstance("","");
                break;
                case R.id.rl_course:
                fragment= AboutFragment.newInstance("","");
                break;
                case R.id.rl_home:
                fragment= HomeStudioFragment.newInstance("","");
                break;
                case R.id.service:
                fragment= AboutFragment.newInstance("","");
                break;

        }
        if(getActivity()!=null)
         ((MainActivity)getActivity()).startFragment(fragment);


    }
}
