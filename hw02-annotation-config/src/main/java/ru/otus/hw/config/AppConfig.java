package ru.otus.hw.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import ru.otus.hw.aspect.LoggingAspect;
import ru.otus.hw.dao.CsvQuestionDao;
import ru.otus.hw.dao.QuestionDao;
import ru.otus.hw.dao.dto.QuestionDtoConverter;
import ru.otus.hw.dao.dto.QuestionDtoConverterImpl;
import ru.otus.hw.service.IOService;
import ru.otus.hw.service.ResultService;
import ru.otus.hw.service.ResultServiceImpl;
import ru.otus.hw.service.StreamsIOService;
import ru.otus.hw.service.StudentService;
import ru.otus.hw.service.StudentServiceImpl;
import ru.otus.hw.service.TestRunnerService;
import ru.otus.hw.service.TestRunnerServiceImpl;
import ru.otus.hw.service.TestService;
import ru.otus.hw.service.TestServiceImpl;

/**
 * Конфигурация приложения.
 *
 * @author Irina Ilina
 */
@PropertySource("classpath:application.properties")
@Configuration
public class AppConfig implements TestConfig, TestFileNameProvider {

    @Value("${test.rightAnswersCountToPass}")
    private int rightAnswersCountToPass;

    /**
     * Имя файла с вопросами.
     */
    @Value("${test.fileName}")
    private String testFileName;

    /**
     * Возвращает количество правильных ответов, чтобы тест считался пройденным.
     *
     * @return количество правильных ответов
     */
    @Override
    public int getRightAnswersCountToPass() {
        return rightAnswersCountToPass;
    }

    /**
     * Возвращает имя файла с вопросами.
     *
     * @return имя файла
     */
    @Override
    public String getTestFileName() {
        return testFileName;
    }

    /**
     * Создает бин IOService.
     *
     * @return бин IOService
     */
    @Bean
    public IOService ioService() {
        return new StreamsIOService(System.out, System.in);
    }


    /**
     * Создает бин конвертера QuestionDtoConverter.
     *
     * @return бин IOService
     */
    @Bean
    public QuestionDtoConverter questionDtoConverter() {
        return new QuestionDtoConverterImpl();
    }

    /**
     * Создает бин QuestionDao.
     *
     * @param questionDtoConverter конвертер данных вопросов
     * @return бин QuestionDao
     */
    @Bean
    public QuestionDao questionDao(QuestionDtoConverter questionDtoConverter) {
        return new CsvQuestionDao(this, questionDtoConverter);
    }

    /**
     * Создает бин TestService.
     *
     * @param ioService   сервис ввода/вывода
     * @param questionDao dao вопросов
     * @return бин TestService
     */
    @Bean
    public TestService testService(IOService ioService, QuestionDao questionDao) {
        return new TestServiceImpl(ioService, questionDao);
    }

    /**
     * Создает бин StudentService.
     *
     * @param ioService сервис ввода/вывода
     * @return бин StudentService
     */
    @Bean
    public StudentService studentService(IOService ioService) {
        return new StudentServiceImpl(ioService);
    }

    /**
     * Создает бин ResultService.
     *
     * @param ioService сервис ввода/вывода
     * @return бин ResultService
     */
    @Bean
    public ResultService resultService(IOService ioService) {
        return new ResultServiceImpl(this, ioService);
    }

    /**
     * Создает бин TestRunnerService.
     *
     * @param testService    сервис тестирования
     * @param studentService сервис обработки данных о студенте
     * @param resultService  сервис обработки результатов тестирования
     * @return бин TestRunnerService
     */
    @Bean
    public TestRunnerService testRunnerService(TestService testService,
                                               StudentService studentService,
                                               ResultService resultService) {
        return new TestRunnerServiceImpl(testService, studentService, resultService);
    }

    /**
     * Создает бин LoggingAspect.
     *
     * @return бин LoggingAspect
     */
    @Bean
    public LoggingAspect loggingAspect() {
        return new LoggingAspect();
    }
}
