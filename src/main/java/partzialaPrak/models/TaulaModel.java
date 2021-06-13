package partzialaPrak.models;

public class TaulaModel {
    private String url;
    private String md5;
    private String version;

    public TaulaModel(String pUrl, String pMd5, String pVersion){
        this.url= pUrl;
        this.md5=pMd5;
        this.version=pVersion;
    }

    public String getUrl() {
        return url;
    }

    public String getMd5() {
        return md5;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }
}
