package ru.forinnyy.tm.command.system;

import ru.forinnyy.tm.exception.entity.AbstractEntityException;
import ru.forinnyy.tm.exception.field.AbstractFieldException;

import static ru.forinnyy.tm.util.NumberUtil.formatBytes;

public final class SystemInfoCommand extends AbstractSystemCommand {

    private static final String DESCRIPTION = "Show system info.";

    private static final String ARGUMENT = "-i";

    private static final String NAME = "info";

    @Override
    public String getArgument() {
        return ARGUMENT;
    }

    @Override
    public String getDescription() {
        return DESCRIPTION;
    }

    @Override
    public String getName() {
        return NAME;
    }

    @Override
    public void execute() throws AbstractEntityException, AbstractFieldException {
        System.out.println("[SYSTEM INFO]");
        final int processorCount = Runtime.getRuntime().availableProcessors();
        System.out.println("PROCESSORS: " + processorCount);

        final long maxMemory = Runtime.getRuntime().maxMemory();
        final long totalMemory = Runtime.getRuntime().totalMemory();
        final long freeMemory = Runtime.getRuntime().freeMemory();
        final long usedMemory = totalMemory - freeMemory;

        System.out.println("MAX MEMORY: " + formatBytes(maxMemory));
        System.out.println("TOTAL MEMORY: " + formatBytes(totalMemory));
        System.out.println("FREE MEMORY: " + formatBytes(freeMemory));
        System.out.println("USED MEMORY: " + formatBytes(usedMemory));
    }

}
