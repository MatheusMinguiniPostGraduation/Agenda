package br.edu.ifspsaocarlos.agenda.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.RatingBar;
import android.widget.TextView;

import java.util.List;

import br.edu.ifspsaocarlos.agenda.R;
import br.edu.ifspsaocarlos.agenda.model.Contato;

public class ContatoFavoritoAdapter extends ArrayAdapter<Contato> {

    //Objeto responsável por transformar um xml em uma instância de um objeto
    private LayoutInflater layoutInflater;

    public ContatoFavoritoAdapter(@NonNull Context context, List<Contato> contatoList) {
        super(context, R.layout.contato_favorito_celula, contatoList);

        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        //Verificar se célula ainda não existe
        if(convertView == null){
            convertView = layoutInflater.inflate(R.layout.contato_favorito_celula, null);
        }

        TextView nomeContatoTextView =  convertView.findViewById(R.id.nomeContatoFavorito);
        RatingBar contatoRatingBar =  convertView.findViewById(R.id.ratingBarContatoFavorito);

        Contato contato = getItem(position);
        nomeContatoTextView.setText(contato.getNome());
        contatoRatingBar.setRating(contato.getFavorito());

        return convertView;
    }
}
