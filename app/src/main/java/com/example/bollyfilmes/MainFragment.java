package com.example.bollyfilmes;
import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainFragment extends Fragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);

        }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_main, container, false);

        ListView list = view.findViewById(R.id.list_filmes);

        final ArrayList<ItemFilme> arrayList = new ArrayList<>();
        arrayList.add(new ItemFilme("Homem Aranha", "Filme de heroi picado por uma aranha", "27/10/2021", 4));
        arrayList.add(new ItemFilme("Homem Cobra", "Filme de heroi picado por uma cobra", "29/10/2021", 2));
        arrayList.add(new ItemFilme("Homem Javali", "Filme de heroi mordido por uma javali", "31/10/2021", 3));
        arrayList.add(new ItemFilme("Homem Passaro", "Filme de heroi picado por uma passaro", "23/11/2021", 5));
        arrayList.add(new ItemFilme("Homem Cachorro", "Filme de heroi mordido por uma cachorro", "22/12/2021", 3.5f));
        arrayList.add(new ItemFilme("Homem Gato", "Filme de heroi mordido por uma gato", "25/01/2022", 2.5f));

        FilmesAdapter adapter = new FilmesAdapter(getContext(), arrayList);

        list.setAdapter(adapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ItemFilme itemFilme = arrayList.get(position);
                Intent intent = new Intent(getContext(), FilmeDetalheActivity.class);
                intent.putExtra(MainActivity.KEY_FILME, itemFilme);
                startActivity(intent);
            }
        });


        return view;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case R.id.menu_atualizar:
                Toast.makeText(getContext(), "Atualizando os Filmes...", Toast.LENGTH_LONG).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);

        }
    }
}