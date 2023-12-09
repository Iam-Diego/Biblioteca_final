package com.example.BibliotecaAlumnos;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;

import android.widget.ImageButton;

import android.widget.SearchView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;



import java.util.ArrayList;


public class LibrosActivity extends AppCompatActivity {

    private RecyclerView recyclerView;

    private int categoriaId;

    private ArrayList<Libro> libroArrayListByCategoria;
    private LibroAdapter libroAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_libros);

        recyclerView = findViewById(R.id.recyclerViewLibros);

        // Configurar el GridLayoutManager
        updateLayoutManager();

        ArrayList<Libro> libroArrayList = Libro.LIBROS;

        // Recibe la información pasada desde MainActivity
        Intent intent = getIntent();
        if (intent != null && intent.hasExtra("CategoriaId")) {
            categoriaId = intent.getIntExtra("CategoriaId", -1);
        }


        libroAdapter.setOnItemClickListener(position -> {
            Intent intent2 = new Intent(LibrosActivity.this, PdfViewerLibro.class);
            intent2.putExtra("LibroId", libroArrayListByCategoria.get(position).getId());
            startActivity(intent2);
        });

        recyclerView.setAdapter(libroAdapter);





    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        updateLayoutManager();
    }

    private void updateLayoutManager() {
        int orientation = getResources().getConfiguration().orientation;
        int spanCount = (orientation == Configuration.ORIENTATION_PORTRAIT) ? 2 : 3;

        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, spanCount, GridLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(gridLayoutManager);
    }

    public ArrayList<Libro> filtrarPorCategoria(ArrayList<Libro> listaLibros, int categoriaDeseada) {
        ArrayList<Libro> librosFiltrados = new ArrayList<>();

        for (Libro libro : listaLibros) {
            if (libro.getCategoria() == categoriaDeseada) {
                librosFiltrados.add(libro);
            }
        }

        return librosFiltrados;
    }

    private void filtrarPorTexto(String texto) {
        List<Libro> librosFiltrados = new ArrayList<>();

        for (Libro libro : libroArrayListByCategoria) {
            if (libro.getNombreLibro().toLowerCase().contains(texto.toLowerCase())) {
                librosFiltrados.add(libro);
            }
        }

        libroAdapter.setLibros(librosFiltrados);
    }
}


class Libro {
    private int id;
    private int imagen;
    private int categoria;
    private String nombreLibro;
    private String autor;
    private String isbn;
    private int pdfResource;

    public static final ArrayList<Libro> LIBROS = new ArrayList<Libro>() {{
        // CRIMINALISTICA
        add(new Libro(1, R.drawable.libro1, 1, R.raw.pdf1, "", "", ""));
        add(new Libro(2, R.drawable.libro2, 2, R.raw.pdf2, "", "", ""));
        add(new Libro(3, R.drawable.libro3, 3, R.raw.pdf3, "", "", ""));
        add(new Libro(4, R.drawable.libro4, 4, R.raw.pdf4, "", "", ""));
        add(new Libro(5, R.drawable.libro5, 5, R.raw.pdf5, "", "", ""));
        add(new Libro(6, R.drawable.libro6, 6, R.raw.pdf6, "", "", ""));
        add(new Libro(7, R.drawable.libro7, 7, R.raw.pdf7, "", "", ""));
        add(new Libro(8, R.drawable.libro8, 8, R.raw.pdf8, "", "", ""));
        add(new Libro(9, R.drawable.libro9, 9, R.raw.pdf9, "", "", ""));
        add(new Libro(10, R.drawable.libro10, 10, R.raw.pdf10, "", "", ""));
        add(new Libro(11, R.drawable.libro11, 11, R.raw.pdf11, "", "", ""));
        add(new Libro(12, R.drawable.libro12, 12, R.raw.pdf12, "", "", ""));
        add(new Libro(13, R.drawable.libro13, 13, R.raw.pdf13, "", "", ""));
        add(new Libro(14, R.drawable.libro14, 14, R.raw.pdf14, "", "", ""));
        add(new Libro(15, R.drawable.libro15, 15, R.raw.pdf15, "", "", ""));
        add(new Libro(16, R.drawable.libro16, 16, R.raw.pdf16, "", "", ""));
        add(new Libro(17, R.drawable.libro17, 17, R.raw.pdf17, "", "", ""));
        add(new Libro(18, R.drawable.libro18, 18, R.raw.pdf18, "", "", ""));
        add(new Libro(19, R.drawable.libro19, 19, R.raw.pdf19, "", "", ""));
        add(new Libro(20, R.drawable.libro20, 20, R.raw.pdf20, "", "", ""));
        add(new Libro(21, R.drawable.libro21, 21, R.raw.pdf21, "", "", ""));
        add(new Libro(22, R.drawable.libro22, 22, R.raw.pdf22, "", "", ""));
        add(new Libro(23, R.drawable.libro23, 23, R.raw.pdf23, "", "", ""));
        add(new Libro(24, R.drawable.libro24, 24, R.raw.pdf24, "", "", ""));
        add(new Libro(25, R.drawable.libro25, 25, R.raw.pdf25, "", "", ""));
        add(new Libro(26, R.drawable.libro26, 26, R.raw.pdf26, "", "", ""));
        add(new Libro(27, R.drawable.libro27, 27, R.raw.pdf27, "", "", ""));
        add(new Libro(28, R.drawable.libro28, 28, R.raw.pdf28, "", "", ""));
        add(new Libro(29, R.drawable.libro29, 29, R.raw.pdf29, "", "", ""));
        add(new Libro(30, R.drawable.libro30, 30, R.raw.pdf30, "", "", ""));

    }};

    public Libro(int id, int imagen, int categoria, int pdfResource, String nombreLibro, String autor, String isbn) {
        this.id = id;
        this.imagen = imagen;
        this.categoria = categoria;
        this.nombreLibro = nombreLibro;
        this.autor = autor;
        this.isbn = isbn;
        this.pdfResource = pdfResource;
    }

    public int getId() {
        return id;
    }

    public int getImagen() {
        return imagen;
    }

    public int getCategoria() {
        return categoria;
    }

    public String getNombreLibro() {
        return nombreLibro;
    }

    public String getAutor() {
        return autor;
    }

    public String getIsbn() {
        return isbn;
    }

    public int getPdfResource() {
        return pdfResource;
    }
}



class LibroAdapter extends RecyclerView.Adapter<LibroAdapter.LibroViewHolder> {

    private List<Libro> item;
    private Context context;
    private OnItemClickListener onItemClickListener;

    public LibroAdapter(List<Libro> item, Context context) {
        this.item = item;
        this.context = context;
    }

    public void setLibros(List<Libro> libros) {
        this.item = libros;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public LibroViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_libro, parent, false);
        return new LibroViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull LibroViewHolder holder, int position) {
        holder.id = item.get(position).getId();
        holder.categoria = item.get(position).getCategoria();
        holder.imagen.setImageResource(item.get(position).getImagen());
        holder.nombreLibro.setText(item.get(position).getNombreLibro());
        holder.autor.setText(item.get(position).getAutor());
        holder.isbn.setText(item.get(position).getIsbn());

        holder.itemView.setOnClickListener(view -> {
            if (onItemClickListener != null) {
                onItemClickListener.onItemClick(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return item.size();
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public class LibroViewHolder extends RecyclerView.ViewHolder {

        private int id;
        private int categoria;
        private ImageView imagen;
        private TextView nombreLibro;
        private TextView autor;
        private TextView isbn;

        public LibroViewHolder(@NonNull View itemView) {
            super(itemView);

            nombreLibro = itemView.findViewById(R.id.libroNombre);
            autor = itemView.findViewById(R.id.libroAutor);
            isbn = itemView.findViewById(R.id.libroISBN);
        }
    }
}

