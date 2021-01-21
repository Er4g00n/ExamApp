package promotion;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import notification.GestionNotification;

public class GestionPromotion {
    private static ObservableList<Promotion> promotions = FXCollections.observableArrayList();

    /*
    * Creer une Promotion*/
    public static void ajouterPromotion(String name, String fil){
        for (Promotion element : promotions) {
            if (element.getIdFiliere().equals(name)){
                GestionNotification.notification("Cette Promotion existe déjà", "INFORMATION", 1.0);
                return;
            }
        }
        Promotion promotion = new Promotion(name, fil);
        promotions.add(promotion);
    }


    public static ObservableList<Promotion> getPromotions() {
        return promotions;
    }

    public static void setPromotions(ObservableList<Promotion> promotions) {
        GestionPromotion.promotions = promotions;
    }
}
