import java.util.Scanner;

public class ThreatDecoder {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("أدخل الرسالة لفحصها:");
        String message = input.nextLine().toLowerCase();

        // قائمة كلمات خبيثة باللغة العربية
        String[] maliciousWords = {
            "اربح",
            "اضغط",
            "تم اختراق",
            "رابط",
            "رقم سري",
            "هدية",
            "تم قفل",
            "حسابك"
        };

        // تنظيف الرسالة من أي رموز غير الحروف
        String simplifiedMessage = message.replaceAll("[^\\p{IsAlphabetic}\\p{IsArabic}]", "");

        boolean threatFound = false;

        for (String word : maliciousWords) {
            String simplifiedWord = word.replaceAll(" ", "");
            if (simplifiedMessage.contains(simplifiedWord)) {
                threatFound = true;
                System.out.println("تم اكتشاف تهديد محتمل: " + word);
            }
        }

        if (!threatFound) {
            System.out.println("الرسالة آمنة ولا تحتوي على كلمات تهديد معروفة.");
        } else {
            System.out.println("تحذير: قد تكون هذه الرسالة محاولة تصيّد أو احتيال.");
        }
    }
}