package com.example.demo.component;

import dev.langchain4j.agent.tool.P;
import dev.langchain4j.agent.tool.Tool;
import org.springframework.stereotype.Component;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

// tools/CalculatorTool.java
@Component
public class CalculatorTool {

    @Tool("Performs basic arithmetic calculations. Use when user asks to calculate something.")
    public double calculate(@P("math expression like '10 * 5 + 3'") String expression) {
        // Simple evaluator - replace with ScriptEngine or exp4j for production
        ScriptEngineManager mgr = new ScriptEngineManager();
        ScriptEngine engine = mgr.getEngineByName("JavaScript");
        try {
            return Double.parseDouble(engine.eval(expression).toString());
        } catch (Exception e) {
            throw new RuntimeException("Could not evaluate: " + expression);
        }
    }
}