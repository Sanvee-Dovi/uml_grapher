package fr.lernejo.umlgrapher;

public class UmlGraph {
     final Class  aClass;

    public UmlGraph(Class aClass, Class... bClass) {
        this.aClass = aClass;
    }
    public final String as(GraphType graphType) {
        String message = "";
        if(graphType==GraphType.Mermaid) {
              message = "" + "classDiagram\n" +
                this.aClass.getClass().getSimpleName().toLowerCase() + " " +  this.aClass.getSimpleName() + " {\n" +
                "    <<interface>>\n" +
                "}\n" +
                "";
        }
        return message;
    }
}
