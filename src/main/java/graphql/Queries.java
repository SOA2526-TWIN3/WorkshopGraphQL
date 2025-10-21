package graphql;

import com.coxautodev.graphql.tools.GraphQLRootResolver;
import entities.Module;
import entities.UniteEnseignement;
import repository.ModuleBusiness;
import repository.UniteEnseignementBusiness;

import java.util.List;

public class Queries implements GraphQLRootResolver {
    public static ModuleBusiness mb = new ModuleBusiness();

    public static UniteEnseignementBusiness ueb =new UniteEnseignementBusiness();
    public Queries(ModuleBusiness mb,UniteEnseignementBusiness ueb) {
        this.mb=mb;
        this.ueb= ueb;
    }

    public List<Module> getallModules(){
        return mb.getAllModules();
    }

    public List<Module> getModulesByType(Module.TypeModule typeM) {
        return mb.getModulesByType(typeM);
    }
    public List<UniteEnseignement> getAllUE() {
        return ueb.getListeUE();
    }


    public UniteEnseignement getUEByCode(int code) {
        return ueb.getUEByCode(code);
    }


    public List<UniteEnseignement> getUEByDomaine(String domaine) {
        return ueb.getUEByDomaine(domaine);
    }


    public List<UniteEnseignement> getUEBySemestre(int semestre) {
        return ueb.getUEBySemestre(semestre);
    }
}
