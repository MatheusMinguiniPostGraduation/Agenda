package br.edu.ifspsaocarlos.agenda.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.List;

import br.edu.ifspsaocarlos.agenda.R;
import br.edu.ifspsaocarlos.agenda.adapter.ContatoFavoritoAdapter;
import br.edu.ifspsaocarlos.agenda.data.ContatoDAO;
import br.edu.ifspsaocarlos.agenda.model.Contato;


public class FiltroFavoritosActivity  extends AppCompatActivity {

    private List<Contato> contatosFavoritados;
    ListView contatosFavoritosListView;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.filtro_favoritos);

        contatosFavoritados = new ContatoDAO(this).buscaTodosContatos(Boolean.TRUE);
        ContatoFavoritoAdapter contatosFavoritosAdapter = new ContatoFavoritoAdapter(this, contatosFavoritados);

        contatosFavoritosListView = findViewById(R.id.lista_favoritos_view);

        contatosFavoritosListView.setAdapter(contatosFavoritosAdapter);
    }
}
