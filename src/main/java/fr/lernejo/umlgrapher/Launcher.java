package fr.lernejo.umlgrapher;
import picocli.CommandLine;
import java.util.concurrent.Callable;
public class Launcher implements Callable<Integer> {
    @CommandLine.Option(names = { "-c", "--classes" } ,required = true, description = "allows you to fill in the classes from which to start the analysis")
    private Class<?> aClass;
    @CommandLine.Option(names = { "-g", "--graph-type" }  ,description = "allows you to select the type of graph you want to output")
    private GraphType Graph = GraphType.Mermaid;

    @Override
    public Integer call() throws Exception {
        UmlGraph umlGraph = new UmlGraph(aClass);
        System.out.println(umlGraph.as(Graph));
        return null;
    }
    public static void main(String... args) {
        int exitCode = new CommandLine(new Launcher()).execute(args);
        System.exit(exitCode);
    }
}
