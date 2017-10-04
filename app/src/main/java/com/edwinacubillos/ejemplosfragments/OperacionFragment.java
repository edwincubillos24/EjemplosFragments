package com.edwinacubillos.ejemplosfragments;


import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
public class OperacionFragment extends Fragment implements View.OnClickListener {

    OpInterface opInterface;
    Button bCalcular;
    private String info = "Hola datos";

    public OperacionFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_operacion, container, false);

        bCalcular = (Button) view.findViewById(R.id.bCalcular);
        bCalcular.setOnClickListener(this);
        return view;
    }


    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try{
            opInterface = (OpInterface) activity;
        } catch (ClassCastException e){
            throw new ClassCastException(getActivity().toString()+"must implemented comunicator");
        }
    }


    @Override
    public void onClick(View view) {
        opInterface.openDataFragment(info);
    }
}
