package fr.lernejo.umlgrapher;

public class Liaison {
    private final String Enfant;
    private final String Parent;
    private final String msg;

    public Liaison(Class enfant, Class parent, String msg) {
        Enfant = enfant.getSimpleName();
        Parent = parent.getSimpleName();
        this.msg = msg;
    }
    public String getEnfant() {
        return Enfant;
    }
    public String getMsg() {
        return msg;
    }
    public String getParent() {
        return Parent;
    }
}
