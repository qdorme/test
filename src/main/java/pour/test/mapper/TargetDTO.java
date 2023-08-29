package pour.test.mapper;

public class TargetDTO {
    private int id;
    private long num;
    private String texte;

    public int getId() {
        return id;
    }

    public TargetDTO setId(int id) {
        this.id = id;
        return this;
    }

    public long getNum() {
        return num;
    }

    public TargetDTO setNum(long num) {
        this.num = num;
        return this;
    }

    public String getTexte() {
        return texte;
    }

    public TargetDTO setTexte(String texte) {
        this.texte = texte;
        return this;
    }
}
