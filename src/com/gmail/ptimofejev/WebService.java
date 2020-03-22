package com.gmail.ptimofejev;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Map;

public class WebService {

	public static Map<String, List<String>> getHeadersFromURL(String spec) throws IOException {
		URL url = new URL(spec);
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		return connection.getHeaderFields();
	}
}
