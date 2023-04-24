package br.com.alura.loja.orcamento;

import br.com.alura.loja.http.HttpAdapter;

import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Map;

public class JavaHttpClient implements HttpAdapter {

    @Override
    public void post(String url, Map<String, Object> dados) {
        try {
            URL urlDaApi = new URL(url);
            URLConnection openConnection = urlDaApi.openConnection();
            openConnection.connect();
        } catch (Exception e) {
            throw new RuntimeException("Erro ao enviar requisiçao HTTP");
        }

    }
}
