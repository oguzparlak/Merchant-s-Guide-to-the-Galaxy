package logic.processors;

import utils.QuestionHandler;

public abstract class Processor {

    /**
     * The Concrete classes will consume this parameters
     */
    private String[] parameters;

    /**
     * QuestionHandler will responsible for
     * the read write operations to Memory
     */
    private QuestionHandler handler;

    Processor(String... parameters) {
        this.parameters = parameters;
        handler = QuestionHandler.getInstance();
    }

    Processor() {
        this((String) null);
    }

    String[] getParameters() {
        return parameters;
    }

    QuestionHandler getHandler() {
        return handler;
    }

    public abstract void process();

}
