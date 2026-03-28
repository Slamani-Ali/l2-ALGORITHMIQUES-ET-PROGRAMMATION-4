import java.io.FileWriter;
import java.io.IOException;

public class TestsDesTris {
        
    public static void testerAlgorithme(String nomFichier, String nomTri, int[] tailles, int nbTests) {
        try (FileWriter writer = new FileWriter(nomFichier)) {
            writer.write("Taille;TempsMoyen(ms);ComparaisonsMoy;AffectationsMoy\n");
            System.out.println("\n--- Tests en cours : " + nomTri + " ---");
            
            for (int taille : tailles) {
                long tempsTotal = 0, compTotal = 0, affTotal = 0;
                
                for (int i = 0; i < nbTests; i++) {
                    tabElement tableau = new tabElement(taille);
                    long startTime = System.nanoTime();
                    
                    if (nomTri.equals("Denombrement")) tableau.triDenombrement();
                    else if (nomTri.equals("InsertionClassique")) tableau.triInsertionClassique();
                    else if (nomTri.equals("InsertionDicho")) tableau.triInsertionDichotomique();
                    else if (nomTri.equals("Fusion")) tableau.triFusion();
                    
                    long endTime = System.nanoTime();
                    
                    tempsTotal += (endTime - startTime);
                    compTotal += tableau.nbComparaisons;
                    affTotal += tableau.nbAffectations;
                }
                
                long tempsMoyenMs = (tempsTotal / nbTests) / 1_000_000;
                writer.write(taille + ";" + tempsMoyenMs + ";" + (compTotal/nbTests) + ";" + (affTotal/nbTests) + "\n");
                System.out.println("Taille : " + taille + " | Temps moy : " + tempsMoyenMs + " ms");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        int[] taillesInsertion = {10, 100, 1000, 5000, 10000, 30000, 50000}; 
        int[] taillesRapides = {10, 100, 1000, 10000, 100000, 500000, 1000000}; 
        int nbTests = 5; 
        
        testerAlgorithme("resultats_denombrement.csv", "Denombrement", taillesRapides, nbTests);
        testerAlgorithme("resultats_fusion.csv", "Fusion", taillesRapides, nbTests);
        testerAlgorithme("resultats_insertion_classique.csv", "InsertionClassique", taillesInsertion, nbTests);
        testerAlgorithme("resultats_insertion_dicho.csv", "InsertionDicho", taillesInsertion, nbTests);
        
        
    }
}