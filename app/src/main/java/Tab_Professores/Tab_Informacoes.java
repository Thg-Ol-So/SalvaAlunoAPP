package Tab_Professores;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.NotificationCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.oliveira.salvaaluno.ListaAdapter;
import com.example.oliveira.salvaaluno.R;

import java.util.List;

import DAO.AtividadeDAO;
import Modelo.AtividadeObj;

/**
 * Created by oliveira on 04/06/17.
 */

public class Tab_Informacoes extends Fragment {
    private String nome_tv;
    private String email_tv;
    private String telefone_tv;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.activity_informacao, container, false);
        if(rootView!=null){
            TextView nome_prof = (TextView) rootView.findViewById(R.id.nome_professor);
            TextView tele = (TextView) rootView.findViewById(R.id.num_telefone);
            TextView email = (TextView) rootView.findViewById(R.id.email);
            nome_prof.setText(getNome_tv());
            email.setText(getEmail_tv());
            tele.setText(getTelefone_tv());
        }
        return rootView;
    }
    public void valores(String nome, String email, String telefone){
            setNome_tv(nome);
            setEmail_tv(email);
            setTelefone_tv(telefone);
    }
    public String getNome_tv() {
        return nome_tv;
    }

    public void setNome_tv(String nome_tv) {
        this.nome_tv = nome_tv;
    }

    public String getEmail_tv() {
        return email_tv;
    }

    public void setEmail_tv(String email_tv) {
        this.email_tv = email_tv;
    }

    public String getTelefone_tv() {
        return telefone_tv;
    }

    public void setTelefone_tv(String telefone_tv) {
        this.telefone_tv = telefone_tv;
    }

}
