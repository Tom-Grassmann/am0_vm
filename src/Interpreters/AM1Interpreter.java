package Interpreters;

import Constants.ArgPatterns;
import Constants.ColorConsole;
import Constants.Colors;
import Exceptions.HeapException;
import Exceptions.InvalidOperationArgumentException;
import Exceptions.StackException;
import GUI.Controller.EventOutput;
import InstructionSets.AM1Instructions;
import InstructionSets.Instructions;
import Operations.Operation;

import java.util.Map;

public class AM1Interpreter implements Interpreter {

    private Map<String, Operation> instructions;

    public AM1Interpreter(Instructions instructions) {

        if (instructions == null) throw new NullPointerException("Instructions to set were NULL!");
        if (!(instructions instanceof AM1Instructions)) System.out.println(ColorConsole.RED + "Warning: Using InstructionSet that is not AM1!" + ColorConsole.RESET);

        this.instructions = instructions.getInstructions();
    }

    @Override
    public void execute(String command) {

        // Exceptions
        if (command == null) throw new NullPointerException("Command to execute was NULL!");
        if (command.isEmpty()) throw new IllegalArgumentException("Command was empty!");

        String operation;
        String arg;

        // For command without parameter
        if (command.matches(ArgPatterns.COMMAND_SINGLE)) {

            operation = command;
            arg = "";

        // For command with parameter
        } else if (command.matches(ArgPatterns.COMMAND_PARAMETER)) {

            operation = command.substring(0, command.indexOf(' '));
            arg = command.substring(command.indexOf(' ') + 1);

        } else {

            throw new IllegalArgumentException(ColorConsole.RED + "Could not parse command! Command was: " + command + ColorConsole.RESET);
        }


        // Exceptions
        if (!this.instructions.containsKey(operation)) throw new IllegalArgumentException("Wrong OperationName in Command: " + command);

        // Run Command
        try {

            this.instructions.get(operation).run(arg);

        } catch (HeapException | StackException | InvalidOperationArgumentException e) {

            // ErrorOutput
            EventOutput.add(e.getMessage(), Colors.RED);
        }
    }
}
