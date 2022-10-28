package fr.lernejo.umlgrapher;

import java.lang.reflect.Modifier;
import java.util.Iterator;
import java.util.Set;

public class MermaidFormatter {
    private final Set<UmlType> types;
    public MermaidFormatter(Set<UmlType> types) {
        this.types = types;
    }
    public String mermaidFormat(){
        String message ="classDiagram\n";
        for (UmlType umlType : types) {
                message += "class "+ umlType.getName();
                if (Modifier.isInterface(umlType.getaClass().getModifiers())) {
                    message += " {\n    <<interface>>\n}";
                }
            message += "\n";
            }
        return message;
        }
    }

