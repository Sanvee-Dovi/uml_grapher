package fr.lernejo.umlgrapher;
import java.util.Iterator;
import java.util.Set;
public class UmlRelation {
    private final Set<UmlType> types;
    public UmlRelation(Set<UmlType> types) {

        this.types = types;
    }
    public String UmlFormat(){
        Class [] classes;
        String message ="";
        for (UmlType umlType : types){
            classes = umlType.getaClass().getInterfaces();
            Iterator it = types.iterator();
            for(Class aClass : classes ){
                if(umlType.getaClass().getSuperclass()!=null){
                    message += aClass.getSimpleName() +" <|.. " + umlType.getaClass().getSimpleName() +" : implements\n";
                }else {
                    message += aClass.getSimpleName() +" <|-- " + umlType.getaClass().getSimpleName() +" : extends\n";
                }
            }
        }
        return message;
    }
}
