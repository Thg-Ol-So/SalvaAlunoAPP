package Tab_Atividades;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.example.oliveira.salvaaluno.Informacao;
import com.example.oliveira.salvaaluno.ListaAdapter;
import com.example.oliveira.salvaaluno.Listagem_Prof;
import com.example.oliveira.salvaaluno.R;
import com.example.oliveira.salvaaluno.Tab_Prof;

import java.util.List;

import DAO.AtividadeDAO;
import Modelo.AtividadeObj;
import Tab_Professores.Tab_Informacoes;

/**
 * Created by oliveira on 04/06/17.
 */

public class Tab_atividades extends Fragment implements AdapterView.OnItemClickListener, AdapterView.OnItemLongClickListener {
    List<AtividadeObj> atividades;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.activity_listagem, container, false);
        if(rootView!=null){

            AtividadeDAO pdao = new AtividadeDAO (getContext());
            pdao.open();
            atividades = pdao.getAtividades();
            pdao.close();
            ListAdapter adapter = new ListaAdapter(getContext(),atividades);
            ListView lv = (ListView) rootView.findViewById(R.id.listagem);
            lv.setAdapter(adapter);
            lv.setOnItemClickListener(this);
        }
        return rootView;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent i = new Intent(getContext(), Informacao.class);
        i.putExtra("tipo",atividades.get(position).getTipo() );
        i.putExtra("data",atividades.get(position).getData());
        i.putExtra("conteudo",atividades.get(position).getConteudo());
        startActivity(i);

    }

    @Override
    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
        return false;
    }
}
