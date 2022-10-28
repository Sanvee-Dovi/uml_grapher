package fr.lernejo.umlgrapher;

public class UmlType {
    private final String Package;
    private final String name;
    private final Class aClass;
    public UmlType(Class aClass) {
        this.Package = aClass.getPackageName();
        this.name = aClass.getSimpleName();
        this.aClass = aClass;
    }
    public Class getaClass() {
        return aClass;
    }

    public String getName() {
        return name;
    }
    public String getPackage() {
        return Package;
    }

}
