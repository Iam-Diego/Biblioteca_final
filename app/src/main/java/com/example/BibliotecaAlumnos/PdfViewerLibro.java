package com.example.BibliotecaAlumnos;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.github.barteksc.pdfviewer.PDFView;
import com.github.barteksc.pdfviewer.listener.OnLoadCompleteListener;
import com.github.barteksc.pdfviewer.listener.OnPageChangeListener;
import com.github.barteksc.pdfviewer.scroll.DefaultScrollHandle;
import com.shockwave.pdfium.PdfDocument;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class PdfViewerLibro extends AppCompatActivity implements OnPageChangeListener, OnLoadCompleteListener {

    private PDFView pdfView;
    private Integer pageNumber = 0;
    private String pdfFileName;

    private int positionLibro;
    private Libro libro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Configurar un diseño vacío directamente en el código
        pdfView = new PDFView(this, null);
        setContentView(pdfView);

        ArrayList<Libro> libroArrayList = Libro.LIBROS;

        Intent intent = getIntent();
        if (intent != null && intent.hasExtra("LibroId")) {
            positionLibro = intent.getIntExtra("LibroId", -1);
        }

        libro = libroArrayList.stream().filter(libro1 -> libro1.getId() == positionLibro).findFirst().get();

        // Establecer límites de zoom
        pdfView.setMinZoom(1f);
        pdfView.setMaxZoom(5f);

        // Carga y muestra el PDF
        InputStream inputStream = getResources().openRawResource(libro.getPdfResource());
        displayFromStream(inputStream);

        // Botón de retroceso
        ImageButton backButton = new ImageButton(this);
        backButton.setImageResource(android.R.drawable.ic_media_previous);
        backButton.setOnClickListener(view -> finish());

        TextView tituloLibro = new TextView(this);
        tituloLibro.setSelected(true);
        tituloLibro.setText(libro.getNombreLibro());

        
        getSupportActionBar().hide();

        // Ocultar los botones de zoom (puedes personalizar según tus necesidades)
        ImageButton zoomInButton = new ImageButton(this);
        ImageButton zoomOutButton = new ImageButton(this);

        zoomInButton.setVisibility(View.GONE);
        zoomOutButton.setVisibility(View.GONE);

        // Añadir vistas al diseño
        // Puedes personalizar el diseño según tus necesidades
        setContentView(pdfView);
        addContentView(backButton, new ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT));
        addContentView(tituloLibro, new ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT));
        addContentView(zoomInButton, new ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT));
        addContentView(zoomOutButton, new ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT));
    }

    @Override
    public void loadComplete(int nbPages) {
        PdfDocument.Meta meta = pdfView.getDocumentMeta();
        printBookmarksTree(pdfView.getTableOfContents(), "-");
    }

    @Override
    public void onPageChanged(int page, int pageCount) {
        pageNumber = page;

        // Elimina esta línea para evitar que aparezca el contador en la parte superior
        // setTitle(String.format("%s %s / %s", pdfFileName, page + 1, pageCount));
    }

    private void displayFromStream(InputStream inputStream) {
        pdfView.fromStream(inputStream)
                .defaultPage(pageNumber)
                .enableSwipe(true)
                .swipeHorizontal(true)  // Establece el desplazamiento horizontal
                .onPageChange(this)
                .enableAnnotationRendering(true)
                .onLoad(this)
                .scrollHandle(new DefaultScrollHandle(this))
                .load();
    }

    public void printBookmarksTree(List<PdfDocument.Bookmark> tree, String sep) {
        for (PdfDocument.Bookmark b : tree) {
            
            if (b.hasChildren()) {
                printBookmarksTree(b.getChildren(), sep + "-");
            }
        }
    }
}
