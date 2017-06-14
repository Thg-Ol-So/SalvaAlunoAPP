package Atividades;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.example.oliveira.salvaaluno.ListaAdapter;
import com.example.oliveira.salvaaluno.R;

import java.util.List;

import DAO.AtividadeDAO;
import Modelo.AtividadeObj;

/**
 * Created by oliveira on 04/06/17.
 */

public class Tab_provas extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.activity_listagem, container, false);
        if(rootView!=null){
            List<AtividadeObj> atividades;
            AtividadeDAO pdao = new AtividadeDAO (getContext());
            pdao.open();
            atividades = pdao.getProvas();

            pdao.close();
            ListAdapter adapter = new ListaAdapter(getContext(),atividades);
            ListView lv = (ListView) rootView.findViewById(R.id.listagem);
            lv.setAdapter(adapter);
        }
        return rootView;
    }
}
