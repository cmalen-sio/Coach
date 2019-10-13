package org.sio2.coach.modele;

import java.io.Serializable;

/**
 *
 */
public class Profil implements Serializable {
    // constantes
    private static final Integer MIN_FEMME = 15; // maigre si en-dessous
    private static final Integer MAX_FEMME = 30; // gros si au-dessus
    private static final Integer MIN_HOMME = 10; // maigre si en-dessous
    private static final Integer MAX_HOMME = 25; // gros si au-dessus

    // propriétés
    private Integer poids;
    private Integer taille;
    private Integer age;
    private Integer sexe;
    private float img;
    private String message;

    public Profil(Integer poids, Integer taille, Integer age, Integer sexe) {
        this.poids = poids;
        this.taille = taille;
        this.age = age;
        this.sexe = sexe;
        this.calculIMG();
        this.resultIMG();
    }

    public Integer getPoids() {
        return poids;
    }

    public Integer getTaille() {
        return taille;
    }

    public Integer getAge() {
        return age;
    }

    public Integer getSexe() {
        return sexe;
    }

    public float getImg() {
        return img;
    }

    public String getMessage() {
        return message;
    }

    private void calculIMG(){
        float tailleM = ((float) taille)/100;
        this.img = (float) ((1.2 * poids) / (tailleM * tailleM) + (0.23 * age) - (10.83 * sexe) - 5.4);
    }

    private void resultIMG(){
        Integer min;
        Integer max;
        if(sexe==0) { // femme
            min = MIN_FEMME;
            max = MAX_FEMME;
        } else {      // Homme
            min = MIN_HOMME;
            max = MAX_HOMME;
        }
        // message correspondant
        message = "normal";
        if(img < min) {
            message = "trop faible";
        } else if (img > max) {
            message = "trop élevé";
        }
    }
}