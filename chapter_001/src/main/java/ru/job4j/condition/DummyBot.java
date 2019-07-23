package ru.job4j.condition;

/**
 * @author Maksim K. (dunor@mail.ru)
 * @version $Id$
 * @since 23.07.19
 */
public class DummyBot {

    /**
     * Отвечает на вопросы.
     * @param question Вопрос от клиента.
     * @return Ответ.
     */
    public String answer (String question) {
        String rsl = "Это ставит меня в тупик. Задайте другой вопрос";
        if ("Привет, Бот!".equals(question)){
            return rsl = "Привет, умник!";
        } else if ("Пока.".equals(question)) {
            return rsl = "До скорой встречи!";
        }else {
            return rsl;
        }
    }
}
