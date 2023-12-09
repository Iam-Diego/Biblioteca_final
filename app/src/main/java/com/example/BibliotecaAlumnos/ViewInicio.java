package com.example.BibliotecaAlumnos;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.example.BibliotecaAlumnos.R;

import java.util.ArrayList;
import java.util.List;

public class ViewInicio extends AppCompatActivity {

    private RecyclerView recyclerView;
    private TarjetaAdapter tarjetaAdapter;

    private List<Tarjeta> tarjetas;  // Lista original
    private List<Tarjeta> tarjetasFiltradas;  // Lista filtrada

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_inicio);

        recyclerView = findViewById(R.id.recyclerView);

        int spanCount = getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE ? 3 : 2;
        recyclerView.setLayoutManager(new GridLayoutManager(this, spanCount));

        // Crear lista original
        tarjetas = new ArrayList<>();

        tarjetas.add(new Tarjeta(R.drawable.libro1, "Concepto 1", "Descripción 1", 350, 600, 5));
        tarjetas.add(new Tarjeta(R.drawable.libro2, "Concepto 2", "Descripción 2", 350, 600, 5));
        tarjetas.add(new Tarjeta(R.drawable.libro3, "Concepto 1", "Descripción 1", 350, 600, 5));
        tarjetas.add(new Tarjeta(R.drawable.libro4, "Concepto 2", "Descripción 2", 350, 600, 5));
        tarjetas.add(new Tarjeta(R.drawable.libro5, "Concepto 1", "Descripción 1", 350, 600, 5));
        tarjetas.add(new Tarjeta(R.drawable.libro6, "Concepto 2", "Descripción 2", 350, 600, 5));
        tarjetas.add(new Tarjeta(R.drawable.libro7, "Concepto 1", "Descripción 1", 350, 600, 5));
        tarjetas.add(new Tarjeta(R.drawable.libro8, "Concepto 2", "Descripción 2", 350, 600, 5));
        tarjetas.add(new Tarjeta(R.drawable.libro9, "Concepto 1", "Descripción 1", 350, 600, 5));
        tarjetas.add(new Tarjeta(R.drawable.libro10, "Concepto 2", "Descripción 2", 350, 600, 5));
        tarjetas.add(new Tarjeta(R.drawable.libro11, "Concepto 1", "Descripción 1", 350, 600, 5));
        tarjetas.add(new Tarjeta(R.drawable.libro12, "Concepto 2", "Descripción 2", 350, 600, 5));
        tarjetas.add(new Tarjeta(R.drawable.libro13, "Concepto 1", "Descripción 1", 350, 600, 5));
        tarjetas.add(new Tarjeta(R.drawable.libro14, "Concepto 2", "Descripción 2", 350, 600, 5));
        tarjetas.add(new Tarjeta(R.drawable.libro15, "Concepto 1", "Descripción 1", 350, 600, 5));
        tarjetas.add(new Tarjeta(R.drawable.libro16, "Concepto 2", "Descripción 2", 350, 600, 5));
        tarjetas.add(new Tarjeta(R.drawable.libro17, "Concepto 1", "Descripción 1", 350, 600, 5));
        tarjetas.add(new Tarjeta(R.drawable.libro18, "Concepto 2", "Descripción 2", 350, 600, 5));
        tarjetas.add(new Tarjeta(R.drawable.libro19, "Concepto 1", "Descripción 1", 350, 600, 5));
        tarjetas.add(new Tarjeta(R.drawable.libro20, "Concepto 2", "Descripción 2", 350, 600, 5));
        tarjetas.add(new Tarjeta(R.drawable.libro21, "Concepto 1", "Descripción 1", 350, 600, 5));
        tarjetas.add(new Tarjeta(R.drawable.libro22, "Concepto 2", "Descripción 2", 350, 600, 5));
        tarjetas.add(new Tarjeta(R.drawable.libro23, "Concepto 1", "Descripción 1", 350, 600, 5));
        tarjetas.add(new Tarjeta(R.drawable.libro24, "Concepto 2", "Descripción 2", 350, 600, 5));
        tarjetas.add(new Tarjeta(R.drawable.libro25, "Concepto 1", "Descripción 1", 350, 600, 5));
        tarjetas.add(new Tarjeta(R.drawable.libro26, "Concepto 2", "Descripción 2", 350, 600, 5));
        tarjetas.add(new Tarjeta(R.drawable.libro27, "Concepto 1", "Descripción 1", 350, 600, 5));
        tarjetas.add(new Tarjeta(R.drawable.libro28, "Concepto 2", "Descripción 2", 350, 600, 5));
        tarjetas.add(new Tarjeta(R.drawable.libro29, "Concepto 1", "Descripción 1", 350, 600, 5));
        tarjetas.add(new Tarjeta(R.drawable.libro30, "Concepto 2", "Descripción 2", 350, 600, 5));

        // Inicializar lista filtrada con la lista original
        tarjetasFiltradas = new ArrayList<>(tarjetas);

        tarjetaAdapter = new TarjetaAdapter(tarjetasFiltradas);
        recyclerView.setAdapter(tarjetaAdapter);

        ActionBar actionBar = getSupportActionBar();

        // Habilita el ActionBar y muestra el título
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setTitle("Biblioteca Escolar");
            actionBar.setDisplayShowHomeEnabled(true);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_search, menu);

        // Obtén la referencia al SearchView
        MenuItem searchItem = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView) searchItem.getActionView();

        // Configura el listener para el cambio en el texto de búsqueda
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                // Aquí puedes realizar acciones cuando se envía la consulta
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                // Filtra los datos en el adaptador según el texto de búsqueda
                filterList(newText);
                return true;
            }
        });

        return super.onCreateOptionsMenu(menu);
    }

    private void filterList(String query) {
        // Limpiar la lista filtrada
        tarjetasFiltradas.clear();

        // Si el texto de búsqueda está vacío, mostrar todos los elementos
        if (query.isEmpty()) {
            tarjetasFiltradas.addAll(tarjetas);
        } else {
            // Filtrar la lista original en función del texto de búsqueda
            for (Tarjeta tarjeta : tarjetas) {
                if (tarjeta.getConcepto().toLowerCase().contains(query.toLowerCase()) ||
                        tarjeta.getDescripcion().toLowerCase().contains(query.toLowerCase())) {
                    tarjetasFiltradas.add(tarjeta);
                }
            }
        }

        // Notificar al adaptador que los datos han cambiado
        tarjetaAdapter.notifyDataSetChanged();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                // Manejar el clic en la flecha de retroceso
                finish();  // Cierra la actividad actual
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public static class Tarjeta {
        private int imagen;
        private String concepto;
        private String descripcion;
        private int tarjetaWidth;
        private int tarjetaHeight;
        private int espacioEntreTarjetas;

        public Tarjeta(int imagen, String concepto, String descripcion, int tarjetaWidth, int tarjetaHeight, int espacioEntreTarjetas) {
            this.imagen = imagen;
            this.concepto = concepto;
            this.descripcion = descripcion;
            this.tarjetaWidth = tarjetaWidth;
            this.tarjetaHeight = tarjetaHeight;
            this.espacioEntreTarjetas = espacioEntreTarjetas;
        }

        public int getImagen() {
            return imagen;
        }

        public String getConcepto() {
            return concepto;
        }

        public String getDescripcion() {
            return descripcion;
        }

        public int getTarjetaWidth() {
            return tarjetaWidth;
        }

        public int getTarjetaHeight() {
            return tarjetaHeight;
        }

        public int getEspacioEntreTarjetas() {
            return espacioEntreTarjetas;
        }
    }

    public class TarjetaAdapter extends RecyclerView.Adapter<TarjetaAdapter.TarjetaViewHolder> {

        private List<Tarjeta> tarjetas;

        public TarjetaAdapter(List<Tarjeta> tarjetas) {
            this.tarjetas = tarjetas;
        }

        @NonNull
        @Override
        public TarjetaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_item_tarjeta, parent, false);
            return new TarjetaViewHolder(view);
        }



        @Override
        public void onBindViewHolder(TarjetaViewHolder holder, int position) {
            Tarjeta tarjeta = tarjetas.get(position);
            ViewGroup.MarginLayoutParams layoutParams = (ViewGroup.MarginLayoutParams) holder.itemView.getLayoutParams();

            // Configura el tamaño de la tarjeta
            layoutParams.width = tarjeta.getTarjetaWidth();
            layoutParams.height = tarjeta.getTarjetaHeight();

            // Configura el espacio entre tarjetas
            layoutParams.setMargins(0, 0, 0, tarjeta.getEspacioEntreTarjetas());

            holder.imageView.setImageResource(tarjeta.getImagen());
            holder.textViewConcepto.setText(tarjeta.getConcepto());
            holder.textViewDescripcion.setText(tarjeta.getDescripcion());

            // Configura el clic en la tarjeta para abrir el PDF correspondiente
            holder.itemView.setOnClickListener(view -> {
                // Crea un Intent para abrir la actividad PdfViewerLibro
                Intent intent = new Intent(view.getContext(), PdfViewerLibro.class);
                // Pasa el ID del libro como extra
                intent.putExtra("LibroId", position + 1); // Suma 1 porque la posición en la lista comienza desde 0
                // Inicia la actividad PdfViewerLibro
                view.getContext().startActivity(intent);
            });
        }


        @Override
        public int getItemCount() {
            return tarjetas.size();
        }

        public class TarjetaViewHolder extends RecyclerView.ViewHolder {
            ImageView imageView;
            TextView textViewConcepto;
            TextView textViewDescripcion;

            public TarjetaViewHolder(View itemView) {
                super(itemView);
                imageView = itemView.findViewById(R.id.imageView);
                textViewConcepto = itemView.findViewById(R.id.textViewConcepto);
                textViewDescripcion = itemView.findViewById(R.id.textViewDescripcion);
            }
        }
    }
}
