package br.edu.ifpr.irati.util;

public class URLParser {

    private String entity;
    private String method;

    public URLParser(String url) throws Exception{
        try {
            System.out.println(url);
            String partesUrl[] = url.split("/");
            this.setEntity(partesUrl[1]);
            this.setMethod(partesUrl[2]);
        }catch (ArrayIndexOutOfBoundsException ae){
            throw new Exception("Invalid url");
        }
    }

    public String getEntity() {
        return entity;
    }

    public void setEntity(String entity) {
        this.entity = entity;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

}
