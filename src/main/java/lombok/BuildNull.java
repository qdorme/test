package lombok;

@Builder
@Data
@ToString
public class BuildNull {
    private String text;
    EmbedClass embedClass;

    public static void main(String[] args) {
        BuildNull build = BuildNull.builder().build();
        System.out.println(build);
    }
}
