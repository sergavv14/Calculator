package calc.operations;

public enum EnumOperation {
    ADD("+"),       //Addition,
    SUB("-"),       //Subtraction
    MUL("*"),       //Multiplication
    DIV("/"),       //Division
    NOD("nod"),
    NOD_MAP("NOD");

    private final String operStr;

    EnumOperation(String s) {
        operStr = s;
    }

    public static EnumOperation getEnumOperation(String operStr) {
        switch (operStr){
            case "+":
                return ADD;
            case "-":
                return SUB;
            case "*":
                return MUL;
            case "/":
                return DIV;
            case "nod":
                return NOD;
            case "NOD":
                return NOD_MAP;
            default:
                return null;
        }
    }

    public String getOperStr() {
        return operStr;
    }
}
