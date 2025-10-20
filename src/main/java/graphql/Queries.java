package graphql;

import com.coxautodev.graphql.tools.GraphQLRootResolver;
import entities.Module;
import repository.ModuleBusiness;

import java.util.List;

public class Queries implements GraphQLRootResolver {
    public static ModuleBusiness mb = new ModuleBusiness();

    public Queries(ModuleBusiness mb) {
        this.mb=mb;
    }

    public List<Module> getallModules(){
        return mb.getAllModules();
    }
}
