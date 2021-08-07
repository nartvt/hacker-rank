import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static String decryptMessage(String encryptedMessage) {
        String[] arr = encryptedMessage.split("");
        Pattern p = Pattern.compile("\\d+");
        StringBuilder builder = new StringBuilder();

        StringBuilder word = new StringBuilder();
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i].equalsIgnoreCase(" ")) {
                builder.append(word.reverse());
                builder.append(arr[i]);
                word.setLength(0);
            } else {
                Matcher m = p.matcher(arr[i]);
                if (m.matches()) {
                    int value = Integer.parseInt(arr[i]);
                    String before = arr[i - 1];
                    for (int c = 1; c < value; c++) {
                        word.append(before);
                    }
                } else {
                    word.append(arr[i]);
                }

            }
            if(i==0){
                builder.append(word.reverse());
                word.setLength(0);
            }

        }
        return builder.toString().trim();
    }

    public static void main(String[] args) {
        System.out.println(decryptMessage("a3b4q2i abcd2 abc"));
    }
}
