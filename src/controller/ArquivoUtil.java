package controller;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ArquivoUtil<T> {
    private final String caminhoArquivo;

    public ArquivoUtil(String caminhoArquivo) {
        this.caminhoArquivo = caminhoArquivo;
    }

    public void salvar(List<T> lista) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(caminhoArquivo))) {
            oos.writeObject(lista);
        }
    }

    public List<T> carregar() throws IOException, ClassNotFoundException {
        File arquivo = new File(caminhoArquivo);
        if (!arquivo.exists()) return new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(caminhoArquivo))) {
            return (List<T>) ois.readObject();
        }
    }
}

