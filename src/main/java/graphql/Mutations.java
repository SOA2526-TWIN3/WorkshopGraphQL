package graphql;

import com.coxautodev.graphql.tools.GraphQLRootResolver;
import entities.Module;
import entities.UniteEnseignement;
import repository.ModuleBusiness;
import repository.UniteEnseignementBusiness;

public class Mutations implements GraphQLRootResolver {
    public static UniteEnseignementBusiness ueb;
    public static ModuleBusiness mb;

    public Mutations(UniteEnseignementBusiness ueb, ModuleBusiness m) {
        this.ueb=ueb;
        this.mb=m;
    }

    public  Boolean addModule(String matricule, String libelle, int coef,
                              int volumeHorraire, int codeUE, Module.TypeModule type) {
        UniteEnseignement ue= ueb.getUEByCode(codeUE);
        Module m = new Module(matricule,libelle,coef,volumeHorraire,type,ue);
        return  mb.addModule(m);
    }

    public Module updateModule(String matricule,String libelle, int coef,
                               int volumeHorraire, Module.TypeModule type, int codeUE) {
        UniteEnseignement ue= ueb.getUEByCode(codeUE);
        Module updatedModule = new Module(matricule,libelle,coef,volumeHorraire,type,ue);
        mb.updateModule(matricule,updatedModule);
        return updatedModule;
    }
    public String deleteModule(String matricule){
        if(mb.deleteModule(matricule))
            return " delete with success";
            return "failed delete";
    }
    public boolean addUniteEnseignement(int code, String domaine, String responsable, int credits, int semestre) {
        UniteEnseignement ue = new UniteEnseignement(code, domaine, responsable, credits, semestre);
        return ueb.addUniteEnseignement(ue);
    }


    public boolean updateUniteEnseignement(int code, String domaine, String responsable, int credits, int semestre) {
        UniteEnseignement updatedUE = new UniteEnseignement(code, domaine, responsable, credits, semestre);
        return ueb.updateUniteEnseignement(code, updatedUE);
    }


    public boolean deleteUniteEnseignement(int code) {
        return ueb.deleteUniteEnseignement(code);
    }
}



