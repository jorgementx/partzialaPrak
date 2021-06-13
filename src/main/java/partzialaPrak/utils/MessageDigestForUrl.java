package partzialaPrak.utils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.UnknownHostException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.apache.commons.codec.binary.Hex;

public class MessageDigestForUrl {

    private static final MessageDigestForUrl nireMessageDigestForUrl = new MessageDigestForUrl();

    private MessageDigestForUrl(){}

    public static MessageDigestForUrl getInstance(){
        return nireMessageDigestForUrl;
    }

    public  String getMd5(String pUrl) throws NoSuchAlgorithmException, FileNotFoundException, IOException {

        String digest = "";
        try {
            URL url = new URL(pUrl + "/README");
            InputStream is = url.openStream();
            MessageDigest md = MessageDigest.getInstance("MD5");
            digest = getDigest(is, md, 2048);
        } catch (UnknownHostException | MalformedURLException e) {
            return "";
        } catch (IOException | NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return digest;

    }

    public static String getDigest(InputStream is, MessageDigest md, int byteArraySize)
            throws NoSuchAlgorithmException, IOException {

        md.reset();
        byte[] bytes = new byte[byteArraySize];
        int numBytes;
        while ((numBytes = is.read(bytes)) != -1) {
            md.update(bytes, 0, numBytes);
        }
        byte[] digest = md.digest();
        String result = new String(Hex.encodeHex(digest));
        return result;
    }

}