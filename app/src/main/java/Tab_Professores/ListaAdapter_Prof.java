package Tab_Professores;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.oliveira.salvaaluno.R;

import java.util.List;

import Modelo.Professor;

/**
 * Created by oliveira on 04/04/17.
 */

public class ListaAdapter_Prof extends BaseAdapter{
    private Context ctx;
    private List<Professor> professores;


    public ListaAdapter_Prof(Context ctx, List<Professor> professores){
        this.ctx = ctx;
        this.professores = professores;
    }

    @Override
    public int getCount() {
        return professores.size();
    }

    @Override
    public Object getItem(int position) {
        return professores.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View visao = LayoutInflater.from(ctx).inflate(R.layout.linha_lista,parent,false);

        Professor p = professores.get(position);
        TextView tvnome = (TextView) visao.findViewById(R.id.tvnome);
        tvnome.setText(p.getNome());

        TextView tvmotivo = (TextView) visao.findViewById(R.id.tvcmotivo);
        tvmotivo.setText(p.getTelefone());

        return visao;
    }
}
