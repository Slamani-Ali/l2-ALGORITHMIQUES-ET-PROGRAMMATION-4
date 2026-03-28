import java.util.Random;

public class tabElement {
    
    Element[] tab;
    int taille;
    
    public long nbComparaisons = 0;
    public long nbAffectations = 0;

    public void resetCompteurs() {
        this.nbComparaisons = 0;
        this.nbAffectations = 0;
    }
    
    // Constructeur
    public tabElement(int n) {
        this.taille = n;
        this.tab = new Element[n];
        Random random = new Random();
        for(int i = 0; i < n; i++) {
            this.tab[i] = new Element(random.nextInt(100_000), "Val_" + i);
        }
    }
    
    
    // 1. TRI PAR INSERTION
    
    public void triInsertionClassique() {
        resetCompteurs();
        for (int i = 1; i < tab.length; i++) {
            Element cle = tab[i]; 
            nbAffectations++;
            int j = i - 1; 

            while (j >= 0 && tab[j].getCle() > cle.getCle()) {
                nbComparaisons++;
                tab[j + 1] = tab[j]; 
                nbAffectations++;
                j--; 
            }
            if (j >= 0) { nbComparaisons++; }

            tab[j + 1] = cle;
            nbAffectations++;
        }
    }

    
    // 2. TRI DICHOTOMIQUE 
    
    public void triInsertionDichotomique() {
        resetCompteurs();
        for (int i = 1; i < tab.length; i++) {
            Element cleActuelle = tab[i]; 
            nbAffectations++;
            
            int gauche = 0;
            int droite = i - 1;
            
            while (gauche <= droite) {
                int milieu = (gauche + droite) / 2;
                nbComparaisons++;
                if (cleActuelle.getCle() < tab[milieu].getCle()) {
                    droite = milieu - 1;
                } else {
                    gauche = milieu + 1;
                }
            }
            
            int j = i - 1;
            while (j >= gauche) {
                tab[j + 1] = tab[j]; 
                nbAffectations++;
                j--;
            }
            tab[gauche] = cleActuelle; 
            nbAffectations++;
        }
    }

    
    // 3. TRI FUSION
    
    public void triFusion() {
        resetCompteurs();
        if(tab.length > 0) {
            fusionRec(0, tab.length - 1);
        }
    }

    private void fusionRec(int gauche, int droite) {
        if (gauche < droite) {
            int milieu = (gauche + droite) / 2;
            fusionRec(gauche, milieu);
            fusionRec(milieu + 1, droite);

            Element[] temp = new Element[droite - gauche + 1]; 
            nbAffectations++;

            int i = gauche;
            int j = milieu + 1;
            int k = 0;

            while (i <= milieu && j <= droite) {
                nbComparaisons++;
                if (tab[i].getCle() <= tab[j].getCle()) {
                    temp[k++] = tab[i++];
                } else {
                    temp[k++] = tab[j++];
                }
                nbAffectations++;
            }

            while (i <= milieu) { temp[k++] = tab[i++]; nbAffectations++; }
            while (j <= droite) { temp[k++] = tab[j++]; nbAffectations++; }
            for (k = 0; k < temp.length; k++) {
                tab[gauche + k] = temp[k];
                nbAffectations++;
            }
        }
    }

    
    
    // 1. Tri Denombrement
    public void triDenombrement() {
        resetCompteurs();
        if (taille == 0) return;

        int max = tab[0].getCle();
        nbAffectations++;
        
        for (int i = 1; i < taille; i++) {
            nbComparaisons++;
            if (tab[i].getCle() > max) { 
                max = tab[i].getCle(); 
                nbAffectations++; 
            }
        }

        Element[] N = new Element[taille];  
        int[] occurrences = new int[max + 1];  

        for (int i = 0; i < taille; i++) { 
            occurrences[tab[i].getCle()]++; 
        }

        for (int i = 1; i <= max; i++) { 
            occurrences[i] += occurrences[i - 1]; 
        }

        for (int i = taille - 1; i >= 0; i--) { 
            occurrences[tab[i].getCle()]--;
            N[occurrences[tab[i].getCle()]] = tab[i];
            nbAffectations += 2; 
        }

        for (int i = 0; i < taille; i++) { 
            tab[i] = N[i]; 
            nbAffectations++; 
        }
    }
}