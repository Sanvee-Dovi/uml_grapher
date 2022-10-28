package fr.lernejo;

import fr.lernejo.umlgrapher.GraphType;
import fr.lernejo.umlgrapher.Liaison;
import fr.lernejo.umlgrapher.UmlGraph;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class UmlParentTest {
    @Test
    void empty_interface_with_no_relation() {
        Class<?>[] classes = {fr.lernejo.Living.Animal.Ant.class,fr.lernejo.Living.Animal.Cat.class,fr.lernejo.Living.Plant.Tree.Alder.class};
        UmlGraph graph = new UmlGraph(classes);
        String output = graph.as(GraphType.Mermaid);

        Assertions.assertThat(output).isEqualTo("""
            classDiagram
            class Alder
            class Animal {
                <<interface>>
            }
            class Ant
            class Cat
            class Living {
                <<interface>>
            }
            class Plant {
                <<interface>>
            }
            class Tree {
                <<interface>>
            }
            Tree <|.. Alder : implements
            Living <|-- Animal : extends
            Animal <|.. Ant : implements
            Animal <|.. Cat : implements
            Living <|-- Plant : extends
            Plant <|-- Tree : extends            
            """);
    }
    @Test
    void liason_test(){
        String message = "class";
        Liaison liaison = new Liaison(fr.lernejo.Living.Animal.Ant.class,fr.lernejo.Living.Animal.class,message);
        String a = liaison.getParent();
        String b = liaison.getEnfant();
        String c = liaison.getMsg();

        Assertions.assertThat(a).isEqualTo("Animal");
        Assertions.assertThat(b).isEqualTo("Ant");
        Assertions.assertThat(c).isEqualTo("class");

    }
}
