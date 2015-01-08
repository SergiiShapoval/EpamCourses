package ua.epam.sergiishapoval.homework.hw13.polnote;

import ua.epam.sergiishapoval.homework.hw13.polnote.elements.Argument;
import ua.epam.sergiishapoval.homework.hw13.polnote.elements.ArgumentGroup;
import ua.epam.sergiishapoval.homework.hw13.polnote.elements.Component;
import ua.epam.sergiishapoval.homework.hw13.polnote.elements.Operation;

import java.util.*;

/**
 * Created by Сергей on 24.11.2014.
 * 	2. Реализовать Composite - Польская запись-аннотация:
 * 	(1+2)*5+16*7
 * 	Перевести в нотацию - там, где нет скобок =
 * 	нет приоритетов и можно делать операции по порядку
 * 	Два типа объектов: примитивы (числа) + объекты (набор чисел с операциями)
 * 	Строим дерево от наименьшего приоритета, к наибольшему
 * 	https://www.youtube.com/watch?v=fUxnb5eTRS0
 * 	https://medium.com/@tylermenezes/converting-between-prefix-infix-postfix-f16ab7ba73b4
 *
 * 	Important points:
 * 	abstract component to create Composite
 * 	all method throw Unsupported
 * 	Operation enum with different level and calculate
 * 	to deques in notation
 * 	special buffer for symbols,
 * 	put buffer to deque before any other operation and clear
 * 	match first and second argument respectively from deque
 * 	clear deques at the end
 * 	if compDeque is not empty - Exception
 */
public class PolishNotation {

    String expression;

    Component head;
    Deque<Operation> opDeque = new ArrayDeque<>();
    Deque<Component> compDeque = new ArrayDeque<>();

    public PolishNotation(String expression) {
        this.expression = expression;
    }

    public double calculate() {

        buildTree();

        return head.calculate();
    }

    private void buildTree() {
        StringBuilder buffer = new StringBuilder();
        System.out.println(expression);

        for (int i = 0; i < expression.length(); i++) {
            char currentChar = expression.charAt(i);
            System.out.println(currentChar);
            switch (currentChar){
                case ('+'):
                    addLevel(buffer,  Operation.ADD);
                    break;
                case ('-'):
                    addLevel(buffer, Operation.MINUS);
                    break;
                case ('*'):
                    addLevel(buffer, Operation.MULTIPLY);
                    break;
                case ('/'):
                    addLevel(buffer, Operation.DIVIDE);
                    break;
                case ('('):
                    opDeque.addLast(Operation.OPEN_BREACKETS);
                    buffer.delete(0, buffer.length());
                    break;
                case (')'):
                    Operation operation = opDeque.pollLast();
                    if (buffer.length() != 0) {
                        Component lastArg = new Argument(Double.parseDouble(buffer.toString()));
                        compDeque.addLast(lastArg);
                    }
                    while (operation != Operation.OPEN_BREACKETS){
                        Component secondArg = compDeque.pollLast();
                        Component firstArg = compDeque.pollLast();
                        Component component = new ArgumentGroup(operation, firstArg, secondArg);
                        compDeque.addLast(component);
                        operation = opDeque.pollLast();
                    }
                    buffer.delete(0, buffer.length());
                    break;


                default: {
                    buffer.append(currentChar);
                    continue;
                }
            }
            buffer.delete(0, buffer.length());
        }

        Component main = null;
        if (buffer.length() != 0) {
            Component lastArg = new Argument(Double.parseDouble(buffer.toString()));
            compDeque.addLast(lastArg);
        }
        if (opDeque.isEmpty()){
            main = compDeque.pollLast();
        } else {
            while (!opDeque.isEmpty()) {

                Component secondArg = compDeque.pollLast();
                Component firstArg = compDeque.pollLast();
                main = new ArgumentGroup(opDeque.pollLast(), firstArg, secondArg);
                compDeque.addLast(main);

            }
            compDeque.pollLast();
        }

        if (compDeque.isEmpty()) {
            head = main;
        }else {
            throw new IllegalStateException("Expression is incorrect");
        }

    }

    private void addLevel(StringBuilder buffer, Operation operation) {

        if (buffer.length() != 0){
            System.out.println(buffer);
            compDeque.addLast(new Argument(Double.parseDouble(buffer.toString())));
        }
        if (opDeque.isEmpty()){
            opDeque.addLast(operation);
        } else {


            if (opDeque.getLast().getPriority() != Operation.OPEN_BREACKETS.getPriority() &&  operation.getPriority() <= opDeque.getLast().getPriority() ){
                Component secondArg = compDeque.pollLast();
                Component firstArg = compDeque.pollLast();
                Component bufferComponent = new ArgumentGroup(opDeque.pollLast(), firstArg, secondArg);

                opDeque.addLast(operation);
                compDeque.addLast(bufferComponent);
            } else {
                opDeque.addLast(operation);
            }


        }
    }

}
