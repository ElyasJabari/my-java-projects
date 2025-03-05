class RomanConverter {
    private static final String[] ROMAN_UNITS = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
    private static final String[] ROMAN_TENS = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "CX"};
    private static final String[] ROMAN_HUNDREDS = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM", "M"};

    public static String convertToRoman(int number) {
        if (number < 1 || number > 1099) {
            return null;
        }

        int hundreds = number / 100;
        int tens = (number / 10) % 10;
        int ones = number % 10;

        return ROMAN_HUNDREDS[hundreds] + ROMAN_TENS[tens] + ROMAN_UNITS[ones];
    }
}