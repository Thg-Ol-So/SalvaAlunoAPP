package Tab_Professores;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.example.oliveira.salvaaluno.R;

import java.util.List;

import DAO.Professor_DAO;

public class Listagem_Prof extends AppCompatActivity {
    List<Modelo.Professor> professores;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listagem);
        Professor_DAO pdao = new Professor_DAO (this);
        pdao.open();
        professores = pdao.getAll();

        pdao.close();
        ListaAdapter_Prof adapter = new ListaAdapter_Prof(this, professores);
        ListView lv = (ListView) findViewById(R.id.listagem);
        lv.setAdapter(adapter);
    }
}
