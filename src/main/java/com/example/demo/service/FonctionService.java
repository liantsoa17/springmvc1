package com.example.demo.service;

import com.example.demo.model.*;
import com.example.demo.repository.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FonctionService {
    private final InfoChiffreRepo infoChiffreRepo;
    private final InfoLettreRepo infoLettreRepo;
    private final RechercherChiffreRepo rechercherChiffreRepo;
    private final RechercherLettreRepo rechercherLettreRepo;

    private final UserRepo userRepo;

    public FonctionService(InfoChiffreRepo infoChiffreRepo, InfoLettreRepo infoLettreRepo, RechercherChiffreRepo rechercherChiffreRepo, RechercherLettreRepo rechercherLettreRepo, UserRepo userRepo) {
        this.infoChiffreRepo = infoChiffreRepo;
        this.infoLettreRepo = infoLettreRepo;
        this.rechercherChiffreRepo = rechercherChiffreRepo;
        this.rechercherLettreRepo = rechercherLettreRepo;
        this.userRepo = userRepo;
    }

    public double note(User one,User two){
        double rep=0.0;

        List<RechercherChiffre> rc=rechercherChiffreRepo.findByIdUser(two.getId());
        List<RechercherLettre> rl=rechercherLettreRepo.findByIdUser(two.getId());

        List<InfoChiffre> ic=infoChiffreRepo.findByIdUser(one.getId());
        List<InfoLettre> il=infoLettreRepo.findByIdUser(one.getId());
        double coeff=0.0;
        for(int i=0;i<rc.size();i++){
            if(ic.get(i).getValeur()>=rc.get(i).getMin()&&ic.get(i).getValeur()<=rc.get(i).getMax()){
                rep+=(rc.get(i).getCoefficient()*20);
            }
            coeff+=rc.get(i).getCoefficient();
        }
        for(int i=0;i<rl.size();i++){
            if(il.get(i).getIdValeurCritere()==rl.get(i).getIdValeurCritere()){
                rep+=(rc.get(i).getCoefficient()*20);
            }
            coeff+=rl.get(i).getCoefficient();
        }
        rep=rep/coeff;
        return rep;
    }

    public double notes(User one,User two){
        double rep=0.0;

        List<RechercherChiffre> rc=rechercherChiffreRepo.findByIdUser(two.getId());
        List<RechercherLettre> rl=rechercherLettreRepo.findByIdUser(two.getId());

        List<InfoChiffre> ic=infoChiffreRepo.findByIdUser(one.getId());
        List<InfoLettre> il=infoLettreRepo.findByIdUser(one.getId());
        for(int i=0;i<rc.size();i++){
            if(ic.get(i).getValeur()>=rc.get(i).getMin()&&ic.get(i).getValeur()<=rc.get(i).getMax()){
                rep+=rc.get(i).getCoefficient();
            }
        }
        for(int i=0;i<rl.size();i++){
            if(il.get(i).getIdValeurCritere()==rl.get(i).getIdValeurCritere())
                rep+=rc.get(i).getCoefficient();

        }
        return rep;
    }
    public List<User> compatible(User one){
        List<User> rep=new ArrayList<>();
        int sexe=0;
        if(one.getSexe()==0){
            sexe=1;
        }
        List<User> user=userRepo.findOpposite(sexe);
        double note1=0.0;
        double note2=0.0;
        for(int i=0;i<user.size();i++){
            note1=note(one,user.get(i));
            note2=note(user.get(i),one);
            if(note1>one.getNote()&&note2>user.get(i).getNote()){
                rep.add(user.get(i));
            }
        }
        return rep;
    }
    public boolean isNegative(String mot,List<ValeurMot> val){
        boolean rep=false;
        for(int i=0;i<val.size();i++){
            if(mot.equalsIgnoreCase(val.get(i).getMot())){
                if(val.get(i).getValeur()<0){
                    rep=true;
                }
            }
            /*if(mot.equals(val.get(i).getMot())){
                if(val.get(i).getValeur()<0){
                    rep=true;
                }
            }*/
        }
        return rep;
    }
    public boolean isExist(String mot,List<ValeurMot> val){
        boolean rep=false;
        for(int i=0;i<val.size();i++){
            if(mot.equalsIgnoreCase(val.get(i).getMot())){
                //if(val.get(i).getValeur()<0){
                System.out.println("voici mon mot "+mot);
                    rep=true;
                //}
            }
        }
        return rep;
    }

    public double nombreMot(String discours,List<ValeurMot> val){
        int cart=discours.length();
        System.out.println("mon caract"+cart);
        int point=0;
        double rep=0;
        if(cart<100){
            point--;
            //point+=-1;
        }
        else if(cart>100&&cart<200){
            point+=2;
        }
        else{
            point+=3;
        }

        String[] p={",",".","!",":",";","?","(",")","[","]","{","}"};
        for(int i=0;i<p.length;i++){
            discours= discours.replace(p[i]," ");
        }
        String[] word=discours.split(" ");
        for(int i=0;i<word.length;i++){
            System.out.println("point ooo"+point);
           if(isNegative(word[i],val)&&isExist(word[i],val)){
                if(isNegative(word[i+1],val)==false&&isExist(word[i+1],val)){
                    point-=2;
                    i++;
                    System.out.println("-2 "+point+" "+word[i]);
                }
                else{
                    point--;
                    System.out.println("-1 "+point+" "+word[i]);
                }
            }
            /* else if(isNegative(word[i],val)&&isExist(word[i],val)){
                point--;
                 System.out.println("-1 "+point+" "+word[i]);
            }*/
            else if(isNegative(word[i],val)==false&&isExist(word[i],val)){
                point++;
                 System.out.println("+1 "+point+" "+word[i]);
            }

        }
        if(point>=9){
            rep=20.0;
        }
        else{
            rep=((double)point*20)/9;
        }
        System.out.println("ito ilay point "+point);
        System.out.println("ito ilay rep "+rep);
        return  rep;
    }
}
