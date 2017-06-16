package Tab_Professores;

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

public class Tab_Disciplinas extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.activity_listagem, container, false);

        return rootView;
    }
}
