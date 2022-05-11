package services;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

public class UrlBox {
    private String urlboxKey;
    private  String urlboxSecret;

    public UrlBox(String urlboxKey, String urlboxSecret) {
        this.urlboxKey = urlboxKey;
        this.urlboxSecret = urlboxSecret;
    }

    public String generateUrl(String url, Map<String, Object> options) throws UnsupportedEncodingException {

        String encodedUrl = URLEncoder.encode(url, "UTF-8");
        String queryString = String.format("url=%s", encodedUrl);

        for (Map.Entry<String, Object> entry : options.entrySet()) {
            String queryParam = "&" + entry.getKey() + "=" + entry.getValue();
            queryString += queryParam;
        }

        String token = generateToken(queryString, this.urlboxSecret);

        String result = String.format("https://api.urlbox.io/v1/%s/%s/png?%s", this.urlboxKey, token, queryString);

        //System.out.println(result);

        return result;
    }

    private String generateToken(String input, String key) {
        StringBuilder lSignature = new StringBuilder();
        try {
            final Mac lMac = Mac.getInstance("HmacSHA1");
            final SecretKeySpec lSecret = new SecretKeySpec(key.getBytes(), "HmacSHA1");
            lMac.init(lSecret);
            final byte[] lDigest = lMac.doFinal(input.getBytes());
            // final StringBuilder lSignatureBuilder = new StringBuilder();
            for (byte b : lDigest) {
                lSignature.append(String.format("%02x", b));
            }
            return lSignature.toString().toLowerCase();
        } catch (NoSuchAlgorithmException lEx) {
            throw new RuntimeException("Problems calculating HMAC", lEx);
        } catch (InvalidKeyException lEx) {
            throw new RuntimeException("Problems calculating HMAC", lEx);
        }
    }
};




