package fr.lernejo.umlgrapher;
import java.util.ArrayList;
import java.util.List;
public class InternalGraphRepresentation {
    private final Class aClass;
    public InternalGraphRepresentation(Class aClass) {
        this.aClass = aClass;
    }
    public List<Class> rechercheRecursive(List<Class> R_list,Class... bClass){
        for(Class  cClass : bClass ){
            if(R_list.contains(cClass)==false){
                R_list.add(cClass);
                R_list = rechercheRecursive(R_list,cClass.getInterfaces());
            }
        }
        return R_list;
    }
    public List<Class> liason(){
        List<Class> liasonList =new ArrayList<Class>();
        liasonList = rechercheRecursive(liasonList,aClass);
        return liasonList;
    }
}
