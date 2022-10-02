package com.example.rajvivah;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.rajvivah.adapter.Biodatafetchadapter;
import com.example.rajvivah.modal.Biodatafetchmodel;
import com.example.rajvivah.webapi.Apiclient;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Biodatadisplayfragment extends Fragment {

    int count = 0;
    private ArrayList<Biodatafetchmodel> courseArrayList;
    private RecyclerView courseRV;
    private Biodatafetchadapter biodatafetchadapter;
    private ProgressBar loadingPB;
    private NestedScrollView nestedSV;
    int pagefrom = 1, pageto = 100;
    List<Biodatafetchmodel> biodatafetchmodelList;


    public Biodatadisplayfragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.biodatadisplay_fragment, container, false);

        courseRV = view.findViewById(R.id.idRVCourses);
        loadingPB = view.findViewById(R.id.idPBLoading);
        nestedSV = view.findViewById(R.id.idNestedSV);

        courseArrayList = new ArrayList<>();
        biodatafetchFunction();
        LinearLayoutManager manager = new LinearLayoutManager(getContext());
        courseRV.setLayoutManager(manager);
        nestedSV.setOnScrollChangeListener(new NestedScrollView.OnScrollChangeListener() {
            @Override
            public void onScrollChange(NestedScrollView v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {
                if (scrollY == v.getChildAt(0).getMeasuredHeight() - v.getMeasuredHeight()) {
                    count++;
                    loadingPB.setVisibility(View.VISIBLE);
                    if (count <= 100) {
                        pagefrom += 100;
                        pageto += 100;
                        biodatafetchFunction();
                    }
                }
            }
        });


        return view;
    }


    public static String removefirstChar(String str) {
        if (str == null || str.length() == 0) {
            return str;
        }
        return str.substring(1);
    }

    public void biodatafetchFunction() {
        try {
            courseRV.setVisibility(View.VISIBLE);
            Call<List<Biodatafetchmodel>> userList = Apiclient.getUserservice().fetchallbioData(pagefrom, pageto);
            userList.enqueue(new Callback<List<Biodatafetchmodel>>() {
                @Override
                public void onResponse(Call<List<Biodatafetchmodel>> call, Response<List<Biodatafetchmodel>> response) {
                    try {

                        biodatafetchmodelList = new ArrayList<Biodatafetchmodel>();
                        biodatafetchmodelList.addAll(response.body());
                        String[] profiledetails = new String[biodatafetchmodelList.size()];
                        if (response.isSuccessful()) {
                            for (int i = 0; i < biodatafetchmodelList.size(); i++) {
                                // profiledetails[i] = biodatafetchmodelList.get(i).getName();registeruser_id
                                String name, gender, candidatedob, candidatecast, candidategotra, candidatefather, candidatemother, candidatemobile , candidateaddress;
                                name ="# "+ biodatafetchmodelList.get(i).getRegisteruser_id()+" \nName : "+ biodatafetchmodelList.get(i).getName();
                                gender ="Gender : "+ biodatafetchmodelList.get(i).getGender_self();
                                //  candidatedob = biodatafetchmodelList.get(i).getFathername();
                                candidatecast ="Rajput : "+ biodatafetchmodelList.get(i).getCandidate_cast();
                                candidategotra ="Gotra : "+ biodatafetchmodelList.get(i).getCandidate_gotra();
                                candidatefather ="Fahter : "+ biodatafetchmodelList.get(i).getFathername();
                                candidatemother ="Mother : "+ biodatafetchmodelList.get(i).getMothername();
                                candidatemobile = "Mobile : " +biodatafetchmodelList.get(i).getCandidate_mob();
                                candidateaddress ="Address : " + biodatafetchmodelList.get(i).getCandidate_address()+" , "+
                                        biodatafetchmodelList.get(i).getCandidate_post()+" , "+  biodatafetchmodelList.get(i).getCandidate_teh()+
                                        " , "+ biodatafetchmodelList.get(i).getCandidate_dist()+" ,\n "+  biodatafetchmodelList.get(i).getCandidate_state();
                                String path = "https://dahejvirodhi.com" + (removefirstChar(biodatafetchmodelList.get(i).getPath()));

                              /*  courseArrayList.add(new Biodatafetchmodel(
                                        name,name , name,
                                        name, name,  name, name, name, path,name));
*/


                                courseArrayList.add(new Biodatafetchmodel(
                                        name,candidatefather , candidatemother,
                                        candidatecast, candidategotra,  candidatemobile, candidatemobile, candidateaddress, path,gender));

                                biodatafetchadapter = new Biodatafetchadapter(getContext(), courseArrayList);
                                courseRV.setAdapter(biodatafetchadapter);

                                //System.out.println(removefirstChar(str));

                            }
                        }

                    } catch (Exception e) {

                    }


                }

                @Override
                public void onFailure(Call<List<Biodatafetchmodel>> call, Throwable t) {

                }
            });
        } catch (Exception e) {

        }


    }



}