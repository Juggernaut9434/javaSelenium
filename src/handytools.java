public class handytools {
    public String randomChars() {
        StringBuilder text = new StringBuilder("_");
        String charSet = "abcdefghijklmnopqrstuvwxyz0123456789";
        for (int i = 0; i < 5; i++) {
            char c = charSet.charAt((int) (Math.random() * charSet.length()));
            text.append(c);

        }
        return text.toString();
    }
}
