package org.sio2.coach.controleur;

import android.content.Context;

import org.sio2.coach.modele.Profil;
import org.sio2.coach.outils.Serializer;

public final class Controle {
    private static Controle instance = null;
    private static Profil profil;
    private static String nomFic = "saveProfil";

    /** constructeur privé
    private Controle(){
        super();
    }

    /**
     * Création de l'instance
     * @return instance
     */
    public static final Controle getInstance(Context contexte){
        if (Controle.instance == null){
            Controle.instance = new Controle();
            recupSerialize(contexte);
        }
        return Controle.instance;
    }

    /**
     * Création du profil
     * @param poids
     * @param taille en cm
     * @param age
     * @param sexe 1 pour homme, 0 pour femme
     */
    public void creerProfil(Integer poids, Integer taille, Integer age, Integer sexe, Context contexte) {
        profil = new Profil (poids, taille, age, sexe);
        Serializer.serialize(nomFic, profil, contexte);
    }

    /**
     * Récupération img de profil
     * @return img
     */
    public float getImg(){
        return profil.getImg();
    }

    /**
     * Récupération message de profil
     * @return message
     */
    public String getMessage(){
        return profil.getMessage();
    }

    /**
     * récupération de l'objet sérialisé (le profil)
     * @param contexte
     */
    private static void recupSerialize(Context contexte){
        profil = (Profil) Serializer.deSerialize(nomFic, contexte);
    }

    public Integer getPoids(){
        if(profil == null){
            return null ;
        } else {
            return profil.getPoids();
        }
    }
    public Integer getTaille(){
        if(profil == null){
            return null;
        } else {
            return profil.getTaille();
        }
    }
    public Integer getAge(){
        if(profil == null){
            return null;
        } else {
            return profil.getAge();
        }
    }
    public Integer getSexe(){
        if(profil == null){
            return null;
        } else {
            return profil.getSexe();
        }
    }
}
