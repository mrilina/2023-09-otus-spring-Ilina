package ru.otus.hw.shell;

import lombok.RequiredArgsConstructor;
import org.springframework.shell.Availability;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellMethodAvailability;
import org.springframework.shell.standard.ShellOption;

import ru.otus.hw.service.TestRunnerService;

/**
 * Команды для запуска приложения.
 *
 * @author Irina Ilina
 */
@ShellComponent
@RequiredArgsConstructor
public class ApplicationCommands {

    /**
     * Cервис по запуску процесса тестирования.
     */
    private final TestRunnerService testService;

    /**
     * Привилегия.
     */
    private boolean permission;

    @ShellMethod(value = "Processing permission command", key = {"p", "perm", "permission"})
    public String personalDataProcessingPermission(@ShellOption(defaultValue = "true") boolean permission) {
        this.permission = permission;
        return "You are welcome!";
    }

    @ShellMethod(value = "Start testing", key = {"s", "start"})
    @ShellMethodAvailability(value = "hasPermission")
    public void runTest() {
        testService.run();
    }

    private Availability hasPermission() {
        return permission ? Availability.available() :
                Availability.unavailable("Please, give permission to start testing");
    }
}