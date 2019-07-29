package ru.job4j.array;
/**
 * Обертка над строкой.
 */
public class EndsWith {

    /**
     * Проверяет. что слово начинается с префикса.
     * @param post префикс.
     * @return если слово начинаеться с префикса
     */
    public boolean endsWith(String word, String post) {
        boolean result = true;
        char[] pst = post.toCharArray();
        char[] wrd = word.toCharArray();
        // проверить. что массив data имеет первые элементы одинаковые с value
        for (int i = pst.length -1, j = wrd.length - 1; i >= 0; i--, j--) {
            if (pst[i] != wrd[j]){
                result = false;
                break;
            }
        }
        return result;
    }
}
