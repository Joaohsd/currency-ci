package org.example.service.implementations;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import static java.time.temporal.ChronoUnit.SECONDS;
import java.util.ArrayList;

import org.example.service.interfaces.CurrencyService;
import org.example.utils.config.ConfigurationDAO;

public class CurrencyDAO implements CurrencyService{

    private ConfigurationDAO _configurationDAO;

    private URI _uri;
    private final String _apiVersion = "v1/";
    private final String _apiKey;

    private HttpRequest _httpRequest;
    private HttpClient _client;
    private HttpResponse<String> _response;

    public CurrencyDAO(){
        try{
            _uri = new URI("https://api.freecurrencyapi.com/");
        }catch (URISyntaxException e){
            e.printStackTrace();
        }

        _apiKey = System.getenv("CURRENCY_API_KEY");

        _client = HttpClient.newHttpClient();
    }

    @Override
    public String getLatest(String baseCurrency) {
        String uri = _uri.toString() + _apiVersion + "latest?apikey=" + _apiKey + "&base_currency=" + baseCurrency;

        try {
            _httpRequest = HttpRequest.newBuilder()
                        .uri(new URI(uri))
                        .timeout(Duration.of(10, SECONDS))
                        .header("Content-Type", "application/json")
                        .GET()
                        .build();
            _response = _client.send(_httpRequest, HttpResponse.BodyHandlers.ofString());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (URISyntaxException e){
            e.printStackTrace();
        }
        return _response.body();
    }

    @Override
    public String getLatest(String baseCurrency, String currency) {
        StringBuilder uriBuilder = new StringBuilder(_uri.toString())
                                        .append(_apiVersion)
                                        .append("latest?apikey=")
                                        .append(_apiKey)
                                        .append("&base_currency=")
                                        .append(baseCurrency)
                                        .append("&currencies=")
                                        .append(currency);
                                        

        try {
            _httpRequest = HttpRequest.newBuilder()
                        .uri(new URI(uriBuilder.toString()))
                        .timeout(Duration.of(10, SECONDS))
                        .header("Content-Type", "application/json")
                        .GET()
                        .build();
            _response = _client.send(_httpRequest, HttpResponse.BodyHandlers.ofString());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (URISyntaxException e){
            e.printStackTrace();
        }
        return _response.body();
    }

    @Override
    public String getLatest(String baseCurrency, ArrayList<String> currencies) {
        StringBuilder uriBuilder = new StringBuilder(_uri.toString())
                                        .append(_apiVersion)
                                        .append("latest?apikey=")
                                        .append(_apiKey)
                                        .append("&base_currency=")
                                        .append(baseCurrency)
                                        .append("&currencies=");
        
        for (String currency : currencies) {
            uriBuilder.append(currency);
            uriBuilder.append(",");
        }

        if(uriBuilder.length() > 0 && uriBuilder.charAt(uriBuilder.length() - 1) == ','){
            uriBuilder.deleteCharAt(uriBuilder.length() - 1);
        }

        try {
            _httpRequest = HttpRequest.newBuilder()
                        .uri(new URI(uriBuilder.toString()))
                        .timeout(Duration.of(10, SECONDS))
                        .header("Content-Type", "application/json")
                        .GET()
                        .build();
            _response = _client.send(_httpRequest, HttpResponse.BodyHandlers.ofString());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (URISyntaxException e){
            e.printStackTrace();
        }
        return _response.body();
    }

    @Override
    public String getCurrencies() {
        String uri = _uri.toString() + _apiVersion + "currencies?apikey=" + _apiKey;

        try {
            _httpRequest = HttpRequest.newBuilder()
                        .uri(new URI(uri))
                        .timeout(Duration.of(10, SECONDS))
                        .header("Content-Type", "application/json")
                        .GET()
                        .build();
            _response = _client.send(_httpRequest, HttpResponse.BodyHandlers.ofString());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (URISyntaxException e){
            e.printStackTrace();
        }
        return _response.body();
    }
    
}
