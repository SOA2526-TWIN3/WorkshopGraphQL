package graphql;

import com.coxautodev.graphql.tools.SchemaParser;
import graphql.schema.GraphQLSchema;
import graphql.servlet.SimpleGraphQLServlet;
import repository.ModuleBusiness;

import javax.servlet.annotation.WebServlet;

@WebServlet(urlPatterns = "/graphql")
public class GraphQLEndPoint extends SimpleGraphQLServlet {
    public GraphQLEndPoint() {
        super(buildSchema());
    }
    private static GraphQLSchema buildSchema() {
        ModuleBusiness mb= new ModuleBusiness();
        return SchemaParser.newParser()
                .file("schema.graphql")
                .resolvers(new Queries(mb))
                .build()
                .makeExecutableSchema();

    }

}
