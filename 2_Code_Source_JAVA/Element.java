public class Element {
    private int cle;
    private String contenu; 
    
    public Element(int a, String b) {
        this.cle = a;
        this.contenu = b;   
    }

    public int getCle() { return cle; }
    public String getContenu() { return contenu; }
    public void setCle(int cle) { this.cle = cle; }
    public void setContenu(String contenu) { this.contenu = contenu; }
}