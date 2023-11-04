package ru.otus.hw.service;

import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import ru.otus.hw.config.LocaleConfig;

/**
 * Сервис считывания сообщений пользователю.
 *
 * @author Irina Ilina
 */

@RequiredArgsConstructor
@Service
@Primary
public class LocalizedMessagesServiceImpl implements LocalizedMessagesService {

    /**
     * Конфигурация локалей.
     */
    private final LocaleConfig localeConfig;

    /**
     * Бин для локализации.
     */
    private final MessageSource messageSource;

    /**
     * Возвращает сообщение.
     *
     * @param code код сообщения
     * @param args аргументы
     * @return сообщение
     */
    @Override
    public String getMessage(String code, Object... args) {
        return messageSource.getMessage(code, args, localeConfig.getLocale());
    }
}
