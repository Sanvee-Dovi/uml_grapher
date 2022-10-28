package fr.lernejo.umlgrapher;
import java.util.*;

public class UmlGraph {
    final Class[] bClass;

    public UmlGraph( Class... bClass) {
        this.bClass = bClass;
    }
    private final Set<UmlType> types = new TreeSet<>(Comparator
        .<UmlType, String>comparing(t->t.getName())
        .thenComparing(t->t.getPackage()));

    private final Set<Liaison> relations = new TreeSet<>(Comparator
        .<Liaison, String>comparing(t->t.getEnfant())
        .thenComparing(t->t.getParent()));

    public final String as(GraphType graphType) {
        String message = "";
        List<Class> list = null;
        for(Class cl : bClass) {
            if (graphType == GraphType.Mermaid) {
                list = new InternalGraphRepresentation(cl).liason();
                for(Class dClass: list){
                    types.add(new UmlType(dClass));
                }
            }
        }
        return new MermaidFormatter(types).mermaidFormat() + new UmlRelation(types).UmlFormat();
    }
}
